package cn.edu.zhku.jsj.huangxin.user.dao;

import java.util.Map;

import cn.edu.zhku.jsj.huangxin.bean.User;
import cn.edu.zhku.jsj.huangxin.util.BeanToMapUtil;
import cn.edu.zhku.jsj.huangxin.util.DBUtil;

public class UserDao {
	
	DBUtil du=new DBUtil();
	BeanToMapUtil bu=new BeanToMapUtil();
	/**
	 * 通过用户名和密码向数据库查询该用户是否存在
	 * @param username	用户名
	 * @param password	密码
	 * @return	返回Map
	 */
	public User getUserByNameAndPw(String username,String password){
		
		String sql="select * from user_list where username=? and password=?";
		String[] params={username,password};
		Map<String,Object> m=du.getMap(sql, params);
		User user=null;
		if(m!=null){
			try {
				user=BeanToMapUtil.map2Bean(m, User.class);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return user;
	}
	/**
	 * 向数据库查询该用户名是否存在
	 * @param username 用户名
	 * @return	用户名存在返回true，否则返回false
	 */
	public boolean findUsername(String username){
		
		boolean rs=false;
		String sql="select * from user_list where username=?";
		String[] params={username};
		Map<String,Object> m=du.getMap(sql, params);
		if(m!=null){
			rs=true;
		}
		return rs;
	}
	/**
	 * 向数据库添加用户名和密码
	 * @param username	用户名
	 * @param password	密码
	 * @return	添加成功返回true，否则返回false
	 */
	public boolean addUser(String username,String password){
		
		boolean rs=false;
		String sql="insert into user_list value(?,?,'100',null,null,null,null)";
		String[] params={username,password};
		int i=du.update(sql, params);
		if(i>0){
			rs=true;
		}
		return rs;
	}
	public boolean update(String username,String columnName,String value){
		
		boolean rs=false;
		String sql="update user_list set "+columnName+"=? where username=?";
		String[] params={value,username};
		int i=du.update(sql, params);
		if(i>0){
			rs=true;
		}
		return rs;
	}
	public void updateMoney(String username,String money){
		String sql="update user_list set money=? where username=?";
		Object[] params={money,username};
		du.update(sql, params);
	}
}
