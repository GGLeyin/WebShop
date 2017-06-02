package cn.edu.zhku.jsj.huangxin.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.zhku.jsj.huangxin.bean.PageBean;

public class DBUtil {
	
	private String driver;
	private String url;
	private String username;
	private String password;
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private int pageSize=8; 		//每页要显示的记录数
	
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	//构造方法，定义驱动程序连接用户名和密码信息
	public DBUtil(){
		driver="com.mysql.jdbc.Driver";
		url="jdbc:mysql://127.0.0.1:3306/web_shop?useUnicode=true&characterEncoding=utf8";
		username="root";
		password="";
	}
	//获得连接对象
	private Connection getConnection(){
		try{
			Class.forName(driver);
			con=DriverManager.getConnection(url,username,password);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("连接失败");
		}
		return con;
	}
	//获得语句对象
	private PreparedStatement getPreparedStatement(String sql){
		try{
			pstmt=getConnection().prepareStatement(sql);
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("获得语句失败");
		}
		return pstmt;
	}
	//给pstmt的SQL语句设置参数（要求参数以数组形式给出）
	private void setParams(String sql,Object[] params){
		pstmt=this.getPreparedStatement(sql);
		for(int i=0;i<params.length;i++){
			try{
				if((params[i])instanceof String){
					pstmt.setString(i+1, (String)params[i]);
				}else if((params[i]) instanceof Integer){
					pstmt.setInt(i+1, (Integer)params[i]);
				}
			}catch(SQLException e){
				e.printStackTrace();
				System.out.println("设置参数失败");
			}
		}
	}
	/**
	 * 执行数据库查询操作时，将返回结果封装到List对象中
	 * @param sql 数据库查询语句
	 * @param params 参数列表
	 * @return	成功返回List集合，否则返回null
	 */
	public List<Map<String,Object>> getList(String sql,Object[] params){
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		try{
			this.setParams(sql,params);
			ResultSet rs=pstmt.executeQuery();
			ResultSetMetaData rsmd=rs.getMetaData();
			while(rs.next()){
				Map<String,Object> m=new HashMap<String,Object>();
				for(int i=1;i<=rsmd.getColumnCount();i++){
					String colName=rsmd.getColumnName(i);
					if(colName.indexOf("ID")>=0){
						m.put(colName, rs.getInt(colName));
					}else{
						m.put(colName, rs.getString(colName));
					}
				}
				list.add(m);
			}
		}catch(SQLException e){
			System.out.println("封装到List失败");
			e.printStackTrace();
		}finally{
			close();
		}
		return list;
	}
	/**
	 * 执行数据库查询操作时，将返回的结果的第一条信息封装到Map对象中
	 * @param sql 查询数据库的语句
	 * @param params 参数列表
	 * @return 成功返回一个带有查询结果的第一条信息的Map集合，否则返回null
	 */
	public Map<String,Object> getMap(String sql,Object[] params){
		List<Map<String,Object>> list=getList(sql,params);
		if(list.isEmpty()){
			return null;
		}else{
			return (Map<String,Object>) list.get(0);
		}
	}
	/**
	 * 更新数据库
	 * @param sql 更新数据库的语句
	 * @param params 参数列表
	 * @return 成功返回受影响的行数，否则返回0
	 */
	public int update(String sql,Object[] params){
		int recNo=0;
		try{
			setParams(sql,params);
			recNo=pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close();
		}
		return recNo;
	}
	//关闭对象
	private void close(){
		try{
			if(rs!=null)
				rs.close();
			if(pstmt!=null)
				pstmt.close();
			if(con!=null)
				con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	//执行数据库查询操作时，返回结果的记录总数
	private int getTotalRows(String sql,Object[] params){
		sql=sql.toLowerCase();			
		String countSql="";
		int count = 0;
		if(sql.indexOf("group")>=0){
			countSql="select count(*) from ("+sql+") as tempNum";						
		}else{
			countSql="select count(*) as tempNum "+sql.substring(sql.indexOf("from"));	
		}
		this.setParams(countSql,params);
		try {
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	/**
	 * 分页显示查询结果时，将当前页中的所有信息封装到PageBean中
	 * @param sql	数据库查询语句
	 * @param params	查询所需参数列表
	 * @param curPage 当前页数
	 * @return	封装有当前页所有信息的PageBean
	 */
	public PageBean getPageBean(String sql,Object[] params,int curPage){
		String newSql=sql+" limit "+(curPage-1)*pageSize+","+pageSize;
		List<Map<String,Object>> data=this.getList(newSql, params);
		PageBean pb=new PageBean();
		pb.setCurPage(curPage);
		pb.setPageSize(pageSize);
		pb.setTotalRows(getTotalRows(sql,params));
		pb.setData(data);
		return pb;
	}
}
