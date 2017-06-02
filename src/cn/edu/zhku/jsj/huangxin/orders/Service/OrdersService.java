package cn.edu.zhku.jsj.huangxin.orders.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.edu.zhku.jsj.huangxin.bean.Orders;
import cn.edu.zhku.jsj.huangxin.bean.PageBean;
import cn.edu.zhku.jsj.huangxin.orders.Dao.OrdersDao;

public class OrdersService {
	OrdersDao od=new OrdersDao();
	/**
	 * ͨ���û����Ͷ���״̬��ȡ������Ϣ����ҳ��ʾ
	 * @param curPage	��ǰҳ��
	 * @param username	�û���
	 * @param state		����״̬
	 * @return	PageBean
	 */
	public PageBean getOrdersByUser(int curPage,String username,String state){
		return od.getOrdersByUser(curPage, username, state);
	}
	/**
	 * �����ݿ����һ��������¼
	 * @param orders	������Ϣ
	 * @throws Exception �������ʧ���쳣
	 */
	public void addOrders(List<Map<String, Object>> pendingCart,String consignee,String phone,String address) throws Exception{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String time=df.format(new Date());
		for(Map<String, Object> map:pendingCart){
			Orders orders=new Orders((String)map.get("username"),(String) map.get("shopName"),(String)map.get("goodsName"),
					(String)map.get("quantity"), (String)map.get("subtotal"),consignee,phone,
					address,time);
			boolean rs=od.addOrders(orders);
			if(!rs){
				throw new Exception("��Ӷ���ʧ�ܣ�");
			}
		}
	}
	/**
	 * ɾ������
	 * @param ordersID	�������
	 * @return ɾ���ɹ�����true�����򷵻�false
	 * @throws Exception ɾ������ʧ���쳣
	 */
	public void deleteOrders(int ordersID) throws Exception{
		boolean rs=od.deleteOrders(ordersID);
		if(!rs){
			throw new Exception("ɾ������ʧ�ܣ�");
		}
	}
	/**
	 * ��ĳһ������״̬����Ϊ���ջ�
	 * @param ordersID	�������
	 * @throws Exception	�޸ĳ����쳣
	 */
	public void updateOrdersState(int ordersID) throws Exception{
		boolean rs=od.updateOrdersState(ordersID, "���ջ�");
		if(!rs){
			throw new Exception("�޸Ķ���״̬ʧ�ܣ�");
		}
	}
}
