package com.project.trip.item.vo;

import com.project.trip.board.vo.PageVO;

public class ReviewVO extends PageVO {
	private int reviewNum;
	private int itemRate;
	private String title;
	private String writer;
	private String memName;
	private String content;
	private String createDate;
	private int readCnt;
	private String itemCode;
	private int rowNum;
	private ItemVO itemVO;
	private int likesCnt;
	private int replyCnt;
	private ReviewLikeVO reviewLikeVO;
	
	public int getReviewNum() {
		return reviewNum;
	}
	public void setReviewNum(int reviewNum) {
		this.reviewNum = reviewNum;
	}
	public int getItemRate() {
		return itemRate;
	}
	public void setItemRate(int itemRate) {
		this.itemRate = itemRate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public int getReadCnt() {
		return readCnt;
	}
	public void setReadCnt(int readCnt) {
		this.readCnt = readCnt;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public ItemVO getItemVO() {
		return itemVO;
	}
	public void setItemVO(ItemVO itemVO) {
		this.itemVO = itemVO;
	}
	public int getRowNum() {
		return rowNum;
	}
	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}
	public int getLikesCnt() {
		return likesCnt;
	}
	public void setLikesCnt(int likesCnt) {
		this.likesCnt = likesCnt;
	}
	public int getReplyCnt() {
		return replyCnt;
	}
	public void setReplyCnt(int replyCnt) {
		this.replyCnt = replyCnt;
	}
	public ReviewLikeVO getReviewLikeVO() {
		return reviewLikeVO;
	}
	public void setReviewLikeVO(ReviewLikeVO reviewLikeVO) {
		this.reviewLikeVO = reviewLikeVO;
	}
	
	
	
}
