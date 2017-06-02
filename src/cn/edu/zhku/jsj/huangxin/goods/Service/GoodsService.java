package cn.edu.zhku.jsj.huangxin.goods.Service;

import cn.edu.zhku.jsj.huangxin.bean.Goods;
import cn.edu.zhku.jsj.huangxin.bean.PageBean;
import cn.edu.zhku.jsj.huangxin.goods.Dao.GoodsDao;

public class GoodsService {
	
	GoodsDao gd=new GoodsDao();
	/**
	 * 通过商品名字获得商品信息，分页显示，按照销量从高到低排序
	 * @param curPage	当前页数
	 * @param goodsName	商品名
	 * @return	PageBean
	 */
	public PageBean getByNameOSales(int curPage,String goodsName){
		return gd.getGoodsByName(curPage, goodsName, "sales","desc");
	}
	/**
	 * 通过商品名字获得商品信息，分页显示，按照价格从低到高排序
	 * @param curPage	当前页数
	 * @param goodsName	商品名
	 * @return	PageBean
	 */
	public PageBean getByNameOPrice(int curPage,String goodsName){
		return gd.getGoodsByName(curPage, goodsName, "price","asc");
	}
	/**
	 * 通过商品类型获得商品信息，分页显示，按照销量从高到低排序
	 * @param curPage	当前页数
	 * @param type	商品类型
	 * @return	PageBean
	 */
	public PageBean getByTypeOSales(int curPage,String type){
		return gd.getGoodsByType(curPage, type,"sales","desc");
	}
	/**
	 * 通过商品类型获得商品信息，分页显示，按照价格从低到高排序
	 * @param curPage	当前页数
	 * @param goodsName	商品类型
	 * @return	PageBean
	 */
	public PageBean getByTypeOPrice(int curPage,String type){
		return gd.getGoodsByType(curPage, type,"price","asc");
	}
	/**
	 * 通过商品ID获得商品信息
	 * @param goodsID	商品编号
	 * @return	Goods
	 */
	public Goods getAGoodsByID(int goodsID){
		return gd.getAGoodsByID(goodsID);
	}
}
