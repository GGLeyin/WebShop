package cn.edu.zhku.jsj.haofeng.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zhku.jsj.haofeng.bean.Admins;
import cn.edu.zhku.jsj.haofeng.dao.AdminEmployeeDao;
import cn.edu.zhku.jsj.haofeng.util.DBUtil;


public class AdminEmployeeDaoImpl extends DBUtil implements AdminEmployeeDao {

	//查询，模糊查询
	@Override
	public List<Admins> getAll(String name) {
		List<Admins> adminslist=new ArrayList<Admins>();
		String sql="select * from Admins where 1=1";
		if(name !=null && name.length()>0){
			sql +=" and adminName like '%"+name+"%'";
		}
		try {
			Admins admin=null;
			rs=commonQuery(sql);
			while(rs.next()){
				admin=new Admins();
				admin.setId(rs.getInt("id"));
				admin.setAdminName(rs.getString("adminName"));
				admin.setAdminPwd(rs.getString("adminPwd"));
				admin.setAdminAge(rs.getInt("adminAge"));
				admin.setAdminGender(rs.getString("adminGender"));
				admin.setAdminAddress(rs.getString("adminAddress"));
				admin.setAdminPhone(rs.getString("adminPhone"));
				adminslist.add(admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return adminslist;
	}

	//新增
	@Override
	public int insert(String name, String pwd, int age, String gender,
			String address, String phone) {
		int result =0;
		String sql="insert into Admins(adminName,adminPwd,adminAge,adminGender,adminAddress,adminPhone)" +
				" values(?,?,?,?,?,?)";
		result =commonUpdate(sql,name,pwd,age,gender,address,phone);
		return result;
	}

	//根据id查询
	@Override
	public Admins getById(int id) {
		Admins admin=null;
		String sql="select * from Admins where id=?";
		try {
			rs=commonQuery(sql, id);
			if(rs.next()){
				admin=new Admins();
				admin.setId(rs.getInt("id"));
				admin.setAdminName(rs.getString("adminName"));
				admin.setAdminPwd(rs.getString("adminPwd"));
				admin.setAdminAge(rs.getInt("adminAge"));
				admin.setAdminGender(rs.getString("adminGender"));
				admin.setAdminAddress(rs.getString("adminAddress"));
				admin.setAdminPhone(rs.getString("adminPhone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admin;
	}

	//修改
	@Override
	public int update(String name, int age, String gender, String address,
			String phone, int id) {
		int result =0;
		String sql="update Admins set adminName=?,adminAge=?," +
				"adminGender=?,adminAddress=?,adminPhone=? where id=?";
		result=commonUpdate(sql, name,age,gender,address,phone,id);
		return result;
	}

	//删除
	@Override
	public int deleteById(int id) {
		int result =0;
		String sql="delete from Admins where id=?";
		result=commonUpdate(sql, id);
		return result;
	}
	
}
