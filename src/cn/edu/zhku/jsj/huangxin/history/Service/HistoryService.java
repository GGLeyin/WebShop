package cn.edu.zhku.jsj.huangxin.history.Service;

import java.util.List;
import java.util.Map;

import cn.edu.zhku.jsj.huangxin.bean.PageBean;
import cn.edu.zhku.jsj.huangxin.history.Dao.HistoryDao;

public class HistoryService {

	HistoryDao hd=new HistoryDao();
	/**
	 * 通过用户名获得用户的消费历史记录
	 * @param username	用户名
	 * @return List<Map<String,Object>>
	 */
	public PageBean getHistoryByUsername(int curPage,String username){
		return hd.getHistoryByUsername(curPage,username);
	}
	public void addHistory(String username,String date,String useType,String amount) throws Exception{
		boolean rs=hd.addHistory(username, date, useType, amount);
		if(!rs){
			throw new Exception("添加消费历史记录失败!");
		}
	}
}
