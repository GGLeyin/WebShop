package cn.edu.zhku.jsj.haofeng.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zhku.jsj.haofeng.bean.Goods;
import cn.edu.zhku.jsj.haofeng.dao.AdminGoodsDao;
import cn.edu.zhku.jsj.haofeng.util.DBUtil;


public class AdminGoodsDaoImpl extends DBUtil implements AdminGoodsDao {


	@Override
	public int RowCount() {
		int rowCount=0;
		String sql ="select count(*) from Goods"; 
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
	public List<Goods> getAll(int pageSize, int pageNo) {
		List<Goods> goodlist=new ArrayList<Goods>();
		
		//分页查询，pagesize 定义一页显示数， pageNO 定义查找的页码
		String sql="select * from goods limit ?,?";
		try {
			rs=commonQuery(sql,pageSize*(pageNo-1),pageSize*pageNo);
			while(rs.next()){
				Goods good=new Goods();
						good.setGoodsID(rs.getInt("goodsID"));
						good.setGoodsName(rs.getString("goodsName"));
						good.setPrice(rs.getString("price"));
						good.setShopName(rs.getString("shopName"));
						good.setInventory(rs.getString("inventory"));
						good.setSales(rs.getString("sales"));
						good.setImagePath(rs.getString("imagePath"));
						good.setType(rs.getString("type"));
				goodlist.add(good);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return goodlist;
	}

	//delete
	@Override
	public int deleteById(int id) {
		int result =0;
		String sql=null;
		//shangchu goods
			sql="delete from Goods where goodsID=?";
		
		result=commonUpdate(sql, id);
		return result;
	}

	@Override
	public int insert(String goodsName, String price, String shopName,
			String inventory, String sales, String imagePath,
			String type) {
		int result =0;
		String sql=null;
		
		sql ="insert into Goods(goodsName,price,shopName,inventory," +
				"sales,imagePath,type) values(?,?,?,?,?,?,?)";

		result=commonUpdate(sql,goodsName,price,shopName,inventory,sales,imagePath,type);
		return result;
	}

	//根据id查询
	@Override
	public Goods getGoodsId(int id) {
		Goods good=null;
		String sql="select * from Goods where goodsID=?";
		try {
			rs=commonQuery(sql,id);
			if(rs.next()){
				good =new Goods(
						rs.getInt("goodsID"),
						rs.getString("goodsName"),
						rs.getString("price"),
						rs.getString("shopName"),
						rs.getString("inventory"),
						rs.getString("sales"),
						rs.getString("imagePath"),
						rs.getString("type")
					);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return good;
	}


	//修改
	@Override
	public int update(String goodsName, String price, String shopName,
			String inventory, String sales, String imagePath,
			String type,int goodsID) {
		int result =0;
		String sql=null;
		
		sql ="update Goods set goodsName=?,price=?,shopName=?,inventory=?,sales=?," +
					"imagePath=?,type=? where goodsID=?";
		
		
		result=commonUpdate(sql,goodsName,price,shopName,inventory,
				sales,imagePath,type,goodsID);
		System.out.println(result);
		return result;
	}

}
