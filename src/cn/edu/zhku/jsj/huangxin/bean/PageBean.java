package cn.edu.zhku.jsj.huangxin.bean;

import java.util.List;
import java.util.Map;

public class PageBean {
	
	private int curPage;			//当前页数
	private int totalPages;			//总页数
	private int totalRows;			//总行数
	private int pageSize;			//每页显示行数
	private List<Map<String,Object>> data;				//每页显示的数据
	
	public int getCurPage(){
		if(curPage>getTotalPages()){
			curPage=getTotalPages();
		}else if(curPage<1){
			curPage=1;
		}
		return curPage;
	}
	public void setCurPage(int curPage){
		this.curPage=curPage;
	}
	public int getTotalPages(){
		if(totalRows%pageSize==0){
			totalPages=totalRows/pageSize;
		}else{
			totalPages=totalRows/pageSize+1;
		}
		return totalPages;
	}
	public void setTotalPages(int totalPages){
		this.totalPages=totalPages;
	}
	public int getTotalRows(){
		return totalRows;
	}
	public void setTotalRows(int totalRows){
		this.totalRows=totalRows;
	}
	public int getPageSize(){
		return pageSize;
	}
	public void setPageSize(int pageSize){
		this.pageSize=pageSize;
	}
	public List<Map<String,Object>> getData(){
		return data;
	}
	public void setData(List<Map<String,Object>> data){
		this.data=data;
	}
}
