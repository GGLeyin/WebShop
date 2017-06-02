package cn.edu.zhku.jsj.haofeng.dao;

import java.util.List;


import cn.edu.zhku.jsj.haofeng.bean.Goods;

public interface AdminGoodsDao {

	//List<Tuijian> getAll(String name);

	int RowCount();

	List<Goods> getAll(int pageSize, int pageNo);

	int deleteById(int id);


	Goods getGoodsId(int id);

	//Tuijian getTuijianId(int id);

	int update(String goodsName, String price, String shopName,
			String inventory, String sales, String imagePath,
			String type,int goodsID);
	
	int insert(String goodsName, String price, String shopName,
			String inventory, String sales, String imagePath,
			String type);

}
