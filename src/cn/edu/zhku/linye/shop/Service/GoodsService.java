package cn.edu.zhku.linye.shop.Service;

import java.util.List;

import cn.edu.zhku.linye.shop.Goods;
import cn.edu.zhku.linye.shop.Dao.ShopDao;

public class GoodsService {
	
	ShopDao sd = new ShopDao();
	
	public boolean addGoods(Goods goods) throws Exception{

	    	boolean result = sd.addGoods(goods);
	    	return result;
	}
	
	public List<Goods> getGoods(Goods goods) throws Exception{

    	return sd.getGoods(goods);
	
	}
	
	public boolean deleGoods(String goodsID) throws Exception{
		
    	boolean result = sd.deleGoods(goodsID);

    	return result;
	}

	public boolean eidtGoods(Goods goods) throws Exception {
		boolean result = sd.editGoods(goods);
		return result;
	}
}
