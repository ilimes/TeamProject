package com.project.trip.admin.vo;

import java.util.List;

import lombok.Data;

@Data
public class SlideImageVO {
	private String imgCode;
	private String originImgName;
	private String attachedImgName;
	private int imageIndex;
	private List<SlideImageVO> slideImageList;
	
}
