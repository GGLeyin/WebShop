package cn.edu.zhku.jsj.huangxin.history.Dao;

import java.util.List;
import java.util.Map;

import cn.edu.zhku.jsj.huangxin.bean.PageBean;
import cn.edu.zhku.jsj.huangxin.util.DBUtil;

public class HistoryDao {
	
	DBUtil du=new DBUtil();
	/**
	 * ͨ���û�������û���������ʷ��¼
	 * @param username	�û���
	 * @return List<Map<String,Object>>
	 */
	public PageBean getHistoryByUsername(int curPage,String username){
		String sql="select * from history where username=?";
		Object[] params={username};
		 return du.getPageBean(sql, params, curPage);
	}
	/**
	 * ���һ���û���������ʷ��¼
	 * @param username	�û���
	 * @param date		ʱ��
	 * @param userType	ʹ������
	 * @param amount	���
	 * @return	��ӳɹ�����true�����򷵻�false
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
