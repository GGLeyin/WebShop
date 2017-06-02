package cn.edu.zhku.linye.shop.Service;

import cn.edu.zhku.linye.shop.Shop;
import cn.edu.zhku.linye.shop.Dao.ShopDao;

public class ShopInfoService {
	ShopDao sd = new ShopDao();
	
	public Shop getShop(String username) throws Exception{
		
		return sd.getShop(username);
	}

	public Shop getShop(String shopName, String description, String account) throws Exception{
		
		return sd.editShop(shopName,description,account);
	}
}
