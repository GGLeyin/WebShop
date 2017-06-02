package cn.edu.zhku.linye.shop.Service;

import cn.edu.zhku.jsj.huangxin.bean.User;
import cn.edu.zhku.linye.shop.Shop;
import cn.edu.zhku.linye.shop.Dao.ShopDao;

public class OpenService {
	ShopDao sd = new ShopDao();
	
	public boolean addShop(Shop shop) throws Exception{
		
    	boolean result = sd.addShop(shop);
    	if(result){
    		sd.updateUser(shop);
    		return result;
    	}
    	return result;
	}

	public User getUser(String username) throws Exception {
		return sd.getUser(username);
	}
}
