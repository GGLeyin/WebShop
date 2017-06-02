package cn.edu.zhku.jsj.huangxin.history.Dao;

import java.util.List;
import java.util.Map;

import cn.edu.zhku.jsj.huangxin.bean.PageBean;
import cn.edu.zhku.jsj.huangxin.util.DBUtil;

public class HistoryDao {
	
	DBUtil du=new DBUtil();
	/**
	 * 通过用户名获得用户的消费历史记录
	 * @param username	用户名
	 * @return List<Map<String,Object>>
	 */
	public PageBean getHistoryByUsername(int curPage,String username){
		String sql="select * from history where username=?";
		Object[] params={username};
		 return du.getPageBean(sql, params, curPage);
	}
	/**
	 * 添加一条用户的消费历史记录
	 * @param username	用户名
	 * @param date		时间
	 * @param userType	使用类型
	 * @param amount	金额
	 * @return	添加成功返回true，否则返回false
	 */
	public boolean addHistory(String username,String date,String useType,String amount){
		boolean rs=false;
		String sql="insert into history values(null,?,?,?,?)";
		Object[] params={username,date,useType,amount};
		int i=du.update(sql, params);
		if(i>0){
			rs=true;
		}
		return rs;
	}
}
