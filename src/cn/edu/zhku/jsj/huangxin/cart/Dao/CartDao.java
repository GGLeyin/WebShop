package cn.edu.zhku.jsj.huangxin.cart.Dao;

import java.util.List;
import java.util.Map;

import cn.edu.zhku.jsj.huangxin.util.BeanToMapUtil;
import cn.edu.zhku.jsj.huangxin.util.DBUtil;

public class CartDao {
	
	DBUtil du=new DBUtil();
	BeanToMapUtil bmu=new BeanToMapUtil();
	/**
	 * ͨ���û�����ȡ���ﳵ����Ʒ
	 * @param username	�û���
	 * @return	��Ʒ�б�list
	 */
	public List<Map<String,Object>> getCartByUsername(String username){
		String sql="select * from cart,goods where cart.goodsID=goods.goodsID and username=?";
		Object[] params={username};
		List<Map<String,Object>> list=du.getList(sql, params);
		return list;
	}
	/**
	 * �����ݿ����һ��������
	 * @param username	�û���
	 * @param goodsID	��Ʒ���
	 * @param quantity	����
	 * @param subtotal	С��
	 * @return	��ӳɹ�����true�����򷵻�false
	 */
	public boolean addCartItem(String username,int goodsID,String quantity,String subtotal){
		boolean rs=false;
		String sql="insert into cart values(null,?,?,?,?)";
		Object[] params={username,goodsID,quantity,subtotal};
		int i=du.update(sql, params);
		if(i>0){
			rs=true;
		}
		return rs;
	}
	/**
	 * �����û����������Ʒ������
	 * @param username	�û���
	 * @param goodsID	��Ʒ���
	 * @param quantity	����
	 * @return	�޸ĳɹ�����true�����򷵻�false
	 */
	public boolean updateCartItem(String username,int goodsID,String quantity,String subtotal){
		 boolean rs=false;
		 String sql = "update cart set quantity=?,subtotal=?where username=? and goodsID=?";
		 Object[] params={quantity,subtotal,username,goodsID};
		 int i=du.update(sql, params);
		 if(i>0){
			 rs=true;
		 }
		 return rs;
	}
	/**
	 * ɾ��������
	 * @param cartID	������ı��
	 * @return	ɾ���ɹ�����true�����򷵻�false
	 */
	public boolean deleteCartItem(int cartID){
		boolean rs=false;
		String sql="delete from cart where cartID=?";
		Object[] params={cartID};
		int i=du.update(sql, params);
		if(i>0){
			rs=true;
		}
		return rs;
	}
	/**
	 * �жϹ������Ƿ��Ѵ���
	 * @param username	�û���
	 * @param goodsID	��Ʒ���
	 * @return	���ڷ���true�����򷵻�false
	 */
	public boolean isCartItemExist(String username,int goodsID){
		boolean rs=false;
		String sql="select * from cart where username=? and goodsID=?";
		Object[] params={username,goodsID};
		Map m=du.getMap(sql, params);
		if(m!=null){
			rs=true;
		}
		return rs;
	}
	public String getQuantity(String username,int goodsID){
		String sql="select quantity from cart where username=? and goodsID=?";
		Object[] params={username,goodsID};
		Map m=du.getMap(sql, params);
		Object o=m.get("quantity");
		return (String)o;
	}
}
