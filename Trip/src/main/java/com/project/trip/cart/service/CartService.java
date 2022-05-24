package com.project.trip.cart.service;

import java.util.List;

import com.project.trip.cart.vo.CartVO;
import com.project.trip.cart.vo.CartViewVO;

public interface CartService {
	
	//장바구니에 아이템 넣기
	int insertCart(CartVO cartVO);
	
	List<CartViewVO> selectCartList(String memId);
	
	int deleteCart(CartVO cartVO);
	
	int deleteCarts(CartVO cartVO);
	
	int updateItemCnt(CartVO cartVO);
}
