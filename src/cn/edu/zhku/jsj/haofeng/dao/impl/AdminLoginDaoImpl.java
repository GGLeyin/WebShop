package cn.edu.zhku.jsj.haofeng.dao.impl;

import java.sql.SQLException;

import cn.edu.zhku.jsj.haofeng.bean.Admins;
import cn.edu.zhku.jsj.haofeng.bean.Boss;
import cn.edu.zhku.jsj.haofeng.dao.AdminLoginDao;
import cn.edu.zhku.jsj.haofeng.util.DBUtil;


public class AdminLoginDaoImpl extends DBUtil implements AdminLoginDao {

	@Override
	public Boss getBoss(String username, String password) {
		Boss boss=null;
		String sql="select * from Boss where bossName=? and bossPwd=?";
		try {
			rs=commonQuery(sql, username,password);
			if(rs.next()){
				boss=new Boss();
				boss.setId(rs.getInt("id"));
				boss.setBossName(rs.getString("bossName"));
				boss.setBossPwd(rs.getString("bossPwd"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boss;
	}

	@Override
	public Admins getAdmins(String username, String password) {
		Admins admins=null;
		String sql="select * from Admins where adminName=? and adminPwd=?";
		try {
			rs=commonQuery(sql, username,password);
			if(rs.next()){
				admins=new Admins();
				admins.setId(rs.getInt("id"));
				admins.setAdminName(rs.getString("adminName"));
				admins.setAdminPwd(rs.getString("adminPwd"));
				admins.setAdminAge(rs.getInt("adminAge"));
				admins.setAdminGender(rs.getString("adminGender"));
				admins.setAdminAddress(rs.getString("adminAddress"));
				admins.setAdminPhone(rs.getString("adminPhone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admins;
	}

	@Override
	public int update(String pwd, int id) {
		int result =0;
		String sql="update Admins set adminPwd=? where id=?";
		result=commonUpdate(sql,pwd, id);
		return result;
	}

	@Override
	public int updateB(String pwd, int id) {
		int result =0;
		String sql="update Boss set bossPwd =? where id=?";
		result=commonUpdate(sql,pwd, id);
		return result;
	}


}
