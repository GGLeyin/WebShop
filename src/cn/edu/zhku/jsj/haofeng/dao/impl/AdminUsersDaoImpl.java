package cn.edu.zhku.jsj.haofeng.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zhku.jsj.haofeng.bean.User_list;
import cn.edu.zhku.jsj.haofeng.dao.AdminUsersDao;
import cn.edu.zhku.jsj.haofeng.util.DBUtil;


public class AdminUsersDaoImpl extends DBUtil implements AdminUsersDao {

	//查询总行数
	@Override
	public int RowCount() {
		int rowCount=0;
		String sql ="select count(*) from user_list"; 
		try {
			rs=commonQuery(sql);
			if(rs.next()){
				rowCount=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
	}

	//查询每页的内容
	@Override
	public List<User_list> getAll(String name,int pageSize, int pageNo) {
		List<User_list> userlist=new ArrayList<User_list>();
		String sql="select * from user_list where 1=1";
		if(name!=null&&name.length()>0){
			sql += " and userName like '%"+ name + "%' limit ?,?";
		}else{
			sql += " limit ?,?";
		}
		try {
			rs=commonQuery(sql,pageSize*(pageNo-1),pageSize*pageNo);
			while(rs.next()){
				User_list user=new User_list(
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("money"),
						rs.getString("consignee"),
						rs.getString("phone"),
						rs.getString("address"),
						rs.getString("shopName")
						);
				userlist.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userlist;
	}

	//删除
	@Override
	public int delete(String username) {
		int result =0;
		String sql="delete from Users where username=?";
		result=commonUpdate(sql, username);
		return result;
	}

}
