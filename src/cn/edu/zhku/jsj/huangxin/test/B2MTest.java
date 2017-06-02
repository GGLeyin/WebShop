package cn.edu.zhku.jsj.huangxin.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import cn.edu.zhku.jsj.huangxin.util.BeanToMapUtil;


public class B2MTest {
	
	BeanToMapUtil bu=new BeanToMapUtil();
	@Test
	public void test(){
		Map<String,Object> m=new HashMap<String,Object>();
		m.put("name", "huang");
		m.put("password",123);
		Map<String,Object> m2=new HashMap<String,Object>();
		m2.put("name", "huan");
		m2.put("password",12);
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		list.add(m);
		list.add(m2);
		List<Userp> lu;
		try {
			lu=bu.listMap2ListBean(list,Userp.class);
			System.out.println(lu.get(1).getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
