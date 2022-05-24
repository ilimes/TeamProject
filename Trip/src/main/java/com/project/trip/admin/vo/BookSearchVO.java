package com.project.trip.admin.vo;

import com.project.trip.board.vo.PageVO;

public class BookSearchVO extends PageVO{
	private String searchFromDate;
	private String searchToDate;
	
	public String getSearchFromDate() {
		return searchFromDate;
	}
	public void setSearchFromDate(String searchFromDate) {
		this.searchFromDate = searchFromDate;
	}
	public String getSearchToDate() {
		return searchToDate;
	}
	public void setSearchToDate(String searchToDate) {
		this.searchToDate = searchToDate;
	}
	
	
}
