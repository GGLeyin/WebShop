package cn.edu.zhku.jsj.huangxin.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import cn.edu.zhku.jsj.huangxin.bean.Goods;
import cn.edu.zhku.jsj.huangxin.bean.PageBean;
import cn.edu.zhku.jsj.huangxin.goods.Service.GoodsService;


public class GoodsTest {
	
	GoodsService gs=new GoodsService();
	
	@Test
	public void getByNameOSalesTest(){
		PageBean pb=gs.getByNameOSales(1, "可");
		List list=pb.getData();
		if(list==null){
			System.out.println("no");
		}else{
			System.out.println(list);
		}
	}
	@Test
	public void getByNameOPriceTest(){
		PageBean pb=gs.getByNameOPrice(1, "可乐");
		List list=pb.getData();
		if(list==null){
			System.out.println("no");
		}else{
			System.out.println(list);
		}
	}
	@Test
	public void getByTypeOPriceTest(){
		PageBean pb=gs.getByTypeOPrice(1, "饮料");
		List list=pb.getData();
		if(list==null){
			System.out.println("no");
		}else{
			System.out.println(list);
		}
	}
	@Test
	public void getByTypeOSalesTest(){
		PageBean pb=gs.getByTypeOSales(1, "饮料");
		List list=pb.getData();
		if(list==null){
			System.out.println("no");
		}else{
			System.out.println(list);
		}
	}
	@Test
	public void getByIDTest(){
		Goods goods=gs.getAGoodsByID(1);
		System.out.println(goods.getGoodsName());
	}
}
