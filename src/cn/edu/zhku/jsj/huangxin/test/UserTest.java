package cn.edu.zhku.jsj.huangxin.test;

import org.junit.Test;

import cn.edu.zhku.jsj.huangxin.bean.User;
import cn.edu.zhku.jsj.huangxin.user.service.UserExistException;
import cn.edu.zhku.jsj.huangxin.user.service.UserService;


public class UserTest {
	UserService us=new UserService();
	@Test
	public void loginTest(){
		User user=us.login("huang", "1234");
		if(user!=null){
			System.out.println("yes");
		}else{
			System.out.println("no");
		}
	}
	@Test
	public void registerTest(){
		
		User user=new User("hun","123");
		try {
			us.register(user);
		} catch (UserExistException e){
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void updatePwTest(){
		
		User user=null;
		try {
			us.updatepw("huang", "1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
