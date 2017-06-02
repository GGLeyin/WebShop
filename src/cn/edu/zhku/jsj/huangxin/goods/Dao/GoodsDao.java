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
	 * 通过商品名字获得商品信息，分页显示，按某个列名排序
	 * @param curPage		当前页数
	 * @param goodsName		商品名字
	 * @param columnName	列名
	 * @param sort			排序方式desc或asc
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
	 * 通过商品类型获得商品信息，分页显示，按某个列名排序
	 * @param curPage		当前页数
	 * @param type			商品类型
	 * @param columnName	列名
	 * @param sort			排序方式desc或asc
	 * @return	PageBean
	 */
	public PageBean getGoodsByType(int curPage,String type,String columnName,String sort){
		String sql="select * from goods where type=? order by "+columnName+"+0 "+sort;
		Object[] params={type};
		PageBean pb=du.getPageBean(sql,params,curPage);
		return pb;
	}
	/**
	 * 通过商品ID获得商品信息
	 * @param goodsID	商品编号
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
