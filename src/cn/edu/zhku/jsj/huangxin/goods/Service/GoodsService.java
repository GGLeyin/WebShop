package cn.edu.zhku.jsj.huangxin.goods.Service;

import cn.edu.zhku.jsj.huangxin.bean.Goods;
import cn.edu.zhku.jsj.huangxin.bean.PageBean;
import cn.edu.zhku.jsj.huangxin.goods.Dao.GoodsDao;

public class GoodsService {
	
	GoodsDao gd=new GoodsDao();
	/**
	 * ͨ����Ʒ���ֻ����Ʒ��Ϣ����ҳ��ʾ�����������Ӹߵ�������
	 * @param curPage	��ǰҳ��
	 * @param goodsName	��Ʒ��
	 * @return	PageBean
	 */
	public PageBean getByNameOSales(int curPage,String goodsName){
		return gd.getGoodsByName(curPage, goodsName, "sales","desc");
	}
	/**
	 * ͨ����Ʒ���ֻ����Ʒ��Ϣ����ҳ��ʾ�����ռ۸�ӵ͵�������
	 * @param curPage	��ǰҳ��
	 * @param goodsName	��Ʒ��
	 * @return	PageBean
	 */
	public PageBean getByNameOPrice(int curPage,String goodsName){
		return gd.getGoodsByName(curPage, goodsName, "price","asc");
	}
	/**
	 * ͨ����Ʒ���ͻ����Ʒ��Ϣ����ҳ��ʾ�����������Ӹߵ�������
	 * @param curPage	��ǰҳ��
	 * @param type	��Ʒ����
	 * @return	PageBean
	 */
	public PageBean getByTypeOSales(int curPage,String type){
		return gd.getGoodsByType(curPage, type,"sales","desc");
	}
	/**
	 * ͨ����Ʒ���ͻ����Ʒ��Ϣ����ҳ��ʾ�����ռ۸�ӵ͵�������
	 * @param curPage	��ǰҳ��
	 * @param goodsName	��Ʒ����
	 * @return	PageBean
	 */
	public PageBean getByTypeOPrice(int curPage,String type){
		return gd.getGoodsByType(curPage, type,"price","asc");
	}
	/**
	 * ͨ����ƷID�����Ʒ��Ϣ
	 * @param goodsID	��Ʒ���
	 * @return	Goods
	 */
	public Goods getAGoodsByID(int goodsID){
		return gd.getAGoodsByID(goodsID);
	}
}
