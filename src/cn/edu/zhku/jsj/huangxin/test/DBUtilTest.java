package cn.edu.zhku.jsj.huangxin.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import cn.edu.zhku.jsj.huangxin.bean.PageBean;
import cn.edu.zhku.jsj.huangxin.util.DBUtil;


public class DBUtilTest {
	
	DBUtil du=new DBUtil();
	
	@Test
	public void getListTest(){
		String sql="select * from user_list";
		Object[] params={}; 
		List list=du.getList(sql, params);
			System.out.println(list.isEmpty());
	}
	@Test
	public void getMapTest(){
		String sql="select * from user_list where username=? and password=?";
		Object[] params={"huang","123"}; 
		Map m=du.getMap(sql, params);
			System.out.println((m==null));
	}
	@Test
	public void updateTest(){
		String sql="insert into user_list value(?,?,null,null,null,null)";
		Object[] params={"huan","123"}; 
		int i=du.update(sql, params);
		System.out.println(i);
	}
	@Test
	public void getPageBeanTest(){
		String sql="select * from user_list where password=?";
		Object[] params={"123"}; 
		PageBean pb=du.getPageBean(sql,params,1);
		System.out.println(pb.getData().get(0));
	}
}
