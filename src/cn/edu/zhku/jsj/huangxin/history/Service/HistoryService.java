package cn.edu.zhku.jsj.huangxin.history.Service;

import java.util.List;
import java.util.Map;

import cn.edu.zhku.jsj.huangxin.bean.PageBean;
import cn.edu.zhku.jsj.huangxin.history.Dao.HistoryDao;

public class HistoryService {

	HistoryDao hd=new HistoryDao();
	/**
	 * ͨ���û�������û���������ʷ��¼
	 * @param username	�û���
	 * @return List<Map<String,Object>>
	 */
	public PageBean getHistoryByUsername(int curPage,String username){
		return hd.getHistoryByUsername(curPage,username);
	}
	public void addHistory(String username,String date,String useType,String amount) throws Exception{
		boolean rs=hd.addHistory(username, date, useType, amount);
		if(!rs){
			throw new Exception("���������ʷ��¼ʧ��!");
		}
	}
}
