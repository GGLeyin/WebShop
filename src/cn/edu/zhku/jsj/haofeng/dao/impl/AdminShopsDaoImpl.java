package cn.edu.zhku.jsj.haofeng.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zhku.jsj.haofeng.bean.Shops;
import cn.edu.zhku.jsj.haofeng.dao.AdminShopsDao;
import cn.edu.zhku.jsj.haofeng.util.DBUtil;


public class AdminShopsDaoImpl extends DBUtil implements AdminShopsDao {

	@Override
	public List<Shops> getAll(String name) {
		List<Shops> shopslist=new ArrayList<Shops>();
		String sql="select * from Shops where 1=1";
		if(name !=null && name.length()>0){
			sql +=" and shopName like '%"+name+"%'";
		}
		try {
			Shops shop=null;
			rs=commonQuery(sql);
			while(rs.next()){
				shop=new Shops();
				shop.setShopName(rs.getString("shopName"));
				shop.setDescription(rs.getString("description"));
				shop.setBuildTime(rs.getString("buildTime"));
				shop.setUsername(rs.getString("username"));
				shopslist.add(shop);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return shopslist;
	}

	@Override
	public int insert(String shopName, String description, String buildTime,
			String username) {
			int result =0;
			String sql="insert into Shops(shopName,description,buildTime,username)" +
					" values(?,?,?,?)";
			result =commonUpdate(sql,shopName,description,buildTime,username);
			return result;
	}

	@Override
	public int update(String shopName, String description, String buildTime,
			String username) {
		int result =0;
		String sql="update Shops set shopName=?,description=?," +
				"buildTime=?,username=?";
		result=commonUpdate(sql,shopName,description,buildTime,username);
		return result;
	}

	@Override
	public int deleteByShopName(String shopName) {
		int result =0;
		String sql="delete from Shops where shopName=?";
		result=commonUpdate(sql, shopName);
		return result;
	}
	
	@Override
	public Shops getShopName(String shopName) {
		Shops shop=null;
		String sql="select * from Shops where shopName=?";
		try {
			rs=commonQuery(sql,shopName);
			if(rs.next()){
				shop =new Shops(
						rs.getString("shopName"),
						rs.getString("description"),
						rs.getString("buildTime"),
						rs.getString("username")
					);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return shop;
	}
	
	@Override
	public int RowCount() {
		int rowCount=0;
		String sql ="select count(*) from Shops"; 
		try {
			rs=commonQuery(sql);
			if(rs.next()){
				rowCount=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
	}

	@Override
	public List<Shops> getAll(int pageSize, int pageNo) {
		List<Shops> shoplist=new ArrayList<Shops>();
		
		//分页查询，pagesize 定义一页显示数， pageNO 定义查找的页码
		String sql="select * from shops limit ?,?";
		try {
			rs=commonQuery(sql,pageSize*(pageNo-1),pageSize*pageNo);
			while(rs.next()){
				Shops shop=new Shops(rs.getString("shopName"), rs.getString("description"),
						rs.getString("buildTime"), rs.getString("username"));
				shoplist.add(shop);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return shoplist;
	}

}
