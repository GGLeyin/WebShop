package cn.edu.zhku.jsj.haofeng.service.impl;

import java.util.List;

import cn.edu.zhku.jsj.haofeng.bean.Goods;
import cn.edu.zhku.jsj.haofeng.dao.AdminGoodsDao;
import cn.edu.zhku.jsj.haofeng.dao.impl.AdminGoodsDaoImpl;
import cn.edu.zhku.jsj.haofeng.service.AdminGoodsService;


public class AdminGoodsServiceImpl implements AdminGoodsService {

	private AdminGoodsDao adminGoodsDao=new AdminGoodsDaoImpl();

	@Override
	public int RowCount() {
		// TODO Auto-generated method stub
		return adminGoodsDao.RowCount();
	}

	@Override
	public List<Goods> getAll(int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return adminGoodsDao.getAll(pageSize, pageNo);
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return adminGoodsDao.deleteById(id);
	}

	@Override
	public Goods getGoodsId(int id) {
		// TODO Auto-generated method stub
		return adminGoodsDao.getGoodsId(id);
	}

	@Override
	public int update(String goodsName, String price,
			String shopName, String inventory, String sales, String imagePath,
			String type,int goodsID) {
		// TODO Auto-generated method stub
		return adminGoodsDao.update(goodsName, price, shopName, inventory, sales, imagePath, type, goodsID);
	}

	@Override
	public int insert(String goodsName, String price,
			String shopName, String inventory, String sales, String imagePath,
			String type) {
		// TODO Auto-generated method stub
		return adminGoodsDao.insert(goodsName, price, shopName, inventory, sales, imagePath, type);
	}
	
	

}
