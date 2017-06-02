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
	private int pageSize=8; 		//ÿҳҪ��ʾ�ļ�¼��
	
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
	//���췽���������������������û�����������Ϣ
	public DBUtil(){
		driver="com.mysql.jdbc.Driver";
		url="jdbc:mysql://127.0.0.1:3306/web_shop?useUnicode=true&characterEncoding=utf8";
		username="root";
		password="";
	}
	//������Ӷ���
	private Connection getConnection(){
		try{
			Class.forName(driver);
			con=DriverManager.getConnection(url,username,password);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("����ʧ��");
		}
		return con;
	}
	//���������
	private PreparedStatement getPreparedStatement(String sql){
		try{
			pstmt=getConnection().prepareStatement(sql);
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("������ʧ��");
		}
		return pstmt;
	}
	//��pstmt��SQL������ò�����Ҫ�������������ʽ������
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
				System.out.println("���ò���ʧ��");
			}
		}
	}
	/**
	 * ִ�����ݿ��ѯ����ʱ�������ؽ����װ��List������
	 * @param sql ���ݿ��ѯ���
	 * @param params �����б�
	 * @return	�ɹ�����List���ϣ����򷵻�null
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
			System.out.println("��װ��Listʧ��");
			e.printStackTrace();
		}finally{
			close();
		}
		return list;
	}
	/**
	 * ִ�����ݿ��ѯ����ʱ�������صĽ���ĵ�һ����Ϣ��װ��Map������
	 * @param sql ��ѯ���ݿ�����
	 * @param params �����б�
	 * @return �ɹ�����һ�����в�ѯ����ĵ�һ����Ϣ��Map���ϣ����򷵻�null
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
	 * �������ݿ�
	 * @param sql �������ݿ�����
	 * @param params �����б�
	 * @return �ɹ�������Ӱ������������򷵻�0
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
	//�رն���
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
	//ִ�����ݿ��ѯ����ʱ�����ؽ���ļ�¼����
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
	 * ��ҳ��ʾ��ѯ���ʱ������ǰҳ�е�������Ϣ��װ��PageBean��
	 * @param sql	���ݿ��ѯ���
	 * @param params	��ѯ��������б�
	 * @param curPage ��ǰҳ��
	 * @return	��װ�е�ǰҳ������Ϣ��PageBean
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
