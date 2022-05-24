package com.project.trip.buy.service;

import java.util.List;

import com.project.trip.buy.vo.BookItemVO;
import com.project.trip.buy.vo.BuyVO;
import com.project.trip.cart.vo.CartVO;
import com.project.trip.member.vo.TempMemberVO;

public interface BuyService {
	//상품 구매시 구매정보 등록
	void bookItem(BuyVO buyVO, TempMemberVO tempMemberVO);
	
	//선택 상품 구매
	void selectedBuyCartList(BuyVO buyVO, CartVO cartVO);
	
	//비회원 구매 상품 조회
	BookItemVO selectTempMemberBookInfo(TempMemberVO tempMemberVO);
	
	//해당 예약 넘버 존재하는지 조회 -- 비회원용
	int findBookInfo(TempMemberVO tempMemberVO);
	
	//비회원 예약 취소
	void deleteTempBook(TempMemberVO tempMemberVO);
}
