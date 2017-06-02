package cn.edu.zhku.jsj.huangxin.user.dao;

import java.util.Map;

import cn.edu.zhku.jsj.huangxin.bean.User;
import cn.edu.zhku.jsj.huangxin.util.BeanToMapUtil;
import cn.edu.zhku.jsj.huangxin.util.DBUtil;

public class UserDao {
	
	DBUtil du=new DBUtil();
	BeanToMapUtil bu=new BeanToMapUtil();
	/**
	 * ͨ���û��������������ݿ��ѯ���û��Ƿ����
	 * @param username	�û���
	 * @param password	����
	 * @return	����Map
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
	 * �����ݿ��ѯ���û����Ƿ����
	 * @param username �û���
	 * @return	�û������ڷ���true�����򷵻�false
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
	 * �����ݿ�����û���������
	 * @param username	�û���
	 * @param password	����
	 * @return	��ӳɹ�����true�����򷵻�false
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
