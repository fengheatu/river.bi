package com.river.utils;

import java.util.ArrayList;
import java.util.List;

public class PageBean<T> {
	
	private int page;
	private int pageSize;
	private long totalcount;
	private List<T> pageBeanList = new ArrayList<T>();
//	private int totalPages;
	private String url;

	public int getTotalPages() {
		int totalPages = (int)(this.totalcount/this.pageSize);
		return ((this.totalcount%pageSize) == 0)?totalPages:totalPages+1;
	}


	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public long getTotalcount() {
		return totalcount;
	}


	public void setTotalcount(long totalcount) {
		this.totalcount = totalcount;
	}


	public List<T> getPageBeanList() {
		return pageBeanList;
	}


	public void setPageBeanList(List<T> pageBeanList) {
		this.pageBeanList = pageBeanList;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}
	
	
}	
