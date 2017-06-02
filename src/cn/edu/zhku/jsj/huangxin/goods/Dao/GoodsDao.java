package cn.edu.zhku.jsj.huangxin.goods.Dao;

import java.util.Map;

import cn.edu.zhku.jsj.huangxin.bean.Goods;
import cn.edu.zhku.jsj.huangxin.bean.PageBean;
import cn.edu.zhku.jsj.huangxin.util.BeanToMapUtil;
import cn.edu.zhku.jsj.huangxin.util.DBUtil;

public class GoodsDao {
	
	DBUtil du=new DBUtil();
	BeanToMapUtil bu=new BeanToMapUtil();
	/**
	 * ͨ����Ʒ���ֻ����Ʒ��Ϣ����ҳ��ʾ����ĳ����������
	 * @param curPage		��ǰҳ��
	 * @param goodsName		��Ʒ����
	 * @param columnName	����
	 * @param sort			����ʽdesc��asc
	 * @return	PageBean
	 */
	public PageBean getGoodsByName(int curPage,String goodsName,String columnName,String sort){
		String sql="select * from goods where goodsName like ? order by "+columnName+"+0 "+sort;
		goodsName="%"+goodsName+"%";
		Object[] params={goodsName};
		PageBean pb=du.getPageBean(sql,params,curPage);
		return pb;
	}
	/**
	 * ͨ����Ʒ���ͻ����Ʒ��Ϣ����ҳ��ʾ����ĳ����������
	 * @param curPage		��ǰҳ��
	 * @param type			��Ʒ����
	 * @param columnName	����
	 * @param sort			����ʽdesc��asc
	 * @return	PageBean
	 */
	public PageBean getGoodsByType(int curPage,String type,String columnName,String sort){
		String sql="select * from goods where type=? order by "+columnName+"+0 "+sort;
		Object[] params={type};
		PageBean pb=du.getPageBean(sql,params,curPage);
		return pb;
	}
	/**
	 * ͨ����ƷID�����Ʒ��Ϣ
	 * @param goodsID	��Ʒ���
	 * @return	Goods
	 */
	public Goods getAGoodsByID(int goodsID){
		String sql="select * from goods where goodsID=?";
		Object[] params={goodsID};
		Map<String,Object> m=du.getMap(sql, params);
		Goods goods=null;
		try {
			goods=bu.map2Bean(m, Goods.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return goods;
	}
}
