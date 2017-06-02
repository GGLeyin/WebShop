package cn.edu.zhku.jsj.huangxin.orders.Dao;

import cn.edu.zhku.jsj.huangxin.bean.Orders;
import cn.edu.zhku.jsj.huangxin.bean.PageBean;
import cn.edu.zhku.jsj.huangxin.util.DBUtil;

public class OrdersDao {
	
	DBUtil du=new DBUtil();
	/**
	 * ͨ���û����Ͷ���״̬��ȡ������Ϣ����ҳ��ʾ
	 * @param curPage	��ǰҳ��
	 * @param username	�û���
	 * @param state		����״̬
	 * @return	PageBean
	 */
	public PageBean getOrdersByUser(int curPage,String username,String state){
		String sql="select * from orders where username=? and state=? order by orderID desc";
		Object[] params={username,state};
		PageBean pb=du.getPageBean(sql,params,curPage);
		return pb;
	}
	/**
	 * �����ݿ����һ��������¼
	 * @param orders	������Ϣ
	 * @return	��ӳɹ�����true�����򷵻�false
	 */
	public boolean addOrders(Orders orders){
		boolean rs=false;
		String sql="insert into orders values(null,?,?,?,?,?,?,?,?,'������',?)";
		Object[] params={orders.getUsername(),orders.getShopName(),orders.getGoodsName(),orders.getQuantity(),orders.getPrice(),orders.getConsignee(),orders.getPhone(),orders.getAddress(),orders.getTime()};
		int i=du.update(sql, params);
		if(i>0){
			rs=true;
		}
		return rs;
	}
	/**
	 * ɾ������
	 * @param ordersID	ĳһ����
	 * @return ɾ���ɹ�����true�����򷵻�false
	 */
	public boolean deleteOrders(int ordersID){
		boolean rs=false;
		String sql="delete from orders where orderID=?";
		Object[] params={ordersID};
		int i=du.update(sql, params);
		if(i>0){
			rs=true;
		}
		return rs;
	}
	public boolean updateOrdersState(int ordersID,String state){
		boolean rs=false;
		String sql="update orders set state=? where orderID=?";
		Object[] params={state,ordersID};
		int i=du.update(sql, params);
		if(i>0){
			rs=true;
		}
		return rs;
	}
}
