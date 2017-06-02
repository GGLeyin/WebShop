package cn.edu.zhku.jsj.huangxin.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import cn.edu.zhku.jsj.huangxin.cart.Service.CartService;


public class CartTest {
	CartService cs=new CartService();
	@Test
	public void getCartByUsernameTest(){
		List<Map<String, Object>> cart=cs.getCartByUsername("huang");
		System.out.println(cart);
	}
	@Test
	public void addCart(){
		try {
			cs.addCartItem("huang",1,"10");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void updateQuentityTest(){
		try {
			cs.updateQuentity("huang",1, "8");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void deleteCartItem(){
		try {
			cs.deleteCartItem(3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
