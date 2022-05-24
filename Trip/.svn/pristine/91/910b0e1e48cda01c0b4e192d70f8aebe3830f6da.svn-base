package com.project.trip.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.project.trip.admin.service.AdminService;
import com.project.trip.admin.vo.SideMenuVO;
import com.project.trip.admin.vo.SubMenuVO;
import com.project.trip.board.service.BoardService;

@Service("menuInterceptor")
public class MenuInterceptor extends HandlerInterceptorAdapter{
	
	@Resource(name = "adminService")
	private AdminService adminService;

	@Resource(name = "boardService")
	private BoardService boardService;
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		//공지사항 게시글 목록 보내기
		modelAndView.addObject("noticeList", boardService.selectNoticeList());
		
		//관리자 메뉴 목록 조회
		modelAndView.addObject("adminMenuList",adminService.selectAdminMenuList());	
		
		
		String menuCode = request.getParameter("menuCode");
		String subMenuCode = request.getParameter("subMenuCode");
		String sideMenuCode = request.getParameter("sideMenuCode");
		String adminMenuCode = request.getParameter("adminMenuCode");
		
		//상품관리 페이지 이동할 때
		if(modelAndView.getViewName().equals("admin/reg_item")) {
			if(sideMenuCode == null ) {
				sideMenuCode = "SIDE_MENU_101";
			}
			if(adminMenuCode == null) {
				adminMenuCode = "MENU_001";
			}
		}
		
		//상품삭제 할 때
		if(modelAndView.getViewName().equals("admin/item_list_manage")) {
			if(sideMenuCode == null ) {
				sideMenuCode = "SIDE_MENU_102";
			}
			if(adminMenuCode == null) {
				adminMenuCode = "MENU_001";
			}
		}
		//상품 수정
		if(modelAndView.getViewName().equals("admin/update_item")) {
			if(sideMenuCode == null ) {
				sideMenuCode = "SIDE_MENU_102";
			}
			if(adminMenuCode == null) {
				adminMenuCode = "MENU_001";
			}
		}
		
		//회원탈퇴 할 때
		if(modelAndView.getViewName().equals("admin/item_list_manage")) {
			if(sideMenuCode == null ) {
				sideMenuCode = "SIDE_MENU_202";
			}
			if(adminMenuCode == null) {
				adminMenuCode = "MENU_002";
			}
		}
		
		//이미지 등록 할 때
		if(modelAndView.getViewName().equals("admin/reg_image")) {
			if(sideMenuCode == null ) {
				sideMenuCode = "SIDE_MENU_103";
			}
			if(adminMenuCode == null) {
				adminMenuCode = "MENU_001";
			}
		}
		//이미지 수정 할 때
		if(modelAndView.getViewName().equals("admin/update_image")) {
			if(sideMenuCode == null ) {
				sideMenuCode = "SIDE_MENU_104";
			}
			if(adminMenuCode == null) {
				adminMenuCode = "MENU_001";
			}
		}
		
		//회원관리 페이지 이동할 때
		if(modelAndView.getViewName().equals("admin/member_manage")) {
			if(sideMenuCode == null) {
				sideMenuCode = "SIDE_MENU_201";
			}
		}
		
		//회원 상세페이지 이동할 때
		if(modelAndView.getViewName().equals("admin/member_detail")) {
			if(sideMenuCode == null) {
				sideMenuCode = "SIDE_MENU_201";
			}
			if(adminMenuCode == null) {
				adminMenuCode = "MENU_002";
			}
		}
		
		
		//예약관리 페이지 이동할 때
		if(modelAndView.getViewName().equals("admin/book_list")){
			if(sideMenuCode == null) {
				sideMenuCode = "SIDE_MENU_301";
			}
			if(adminMenuCode == null) {
				adminMenuCode = "MENU_003";
			}
			
		}
		
		//상담 및 문의관리 페이지 이동할 때
		if(modelAndView.getViewName().equals("admin/enquiry_list") || modelAndView.getViewName().equals("admin/enquiry_detail")){
			if(sideMenuCode == null) {
				sideMenuCode = "SIDE_MENU_401";
			}
			if(adminMenuCode == null) {
				adminMenuCode = "MENU_004";
			}
			
		}
		
		//메뉴 코드가 null 이면 001로 설정
		if(adminMenuCode == null) {
			if(menuCode == null) {
				menuCode = "MENU_001";
			}
		}
		
		SideMenuVO sideMenuVO = new SideMenuVO();
		sideMenuVO.setMenuCode(menuCode);
		sideMenuVO.setSideMenuCode(sideMenuCode);
		sideMenuVO.setAdminMenuCode(adminMenuCode);
		
		//서브 메뉴 관련 메뉴코드 설정
		SubMenuVO subMenuVO = new SubMenuVO();
		subMenuVO.setMenuCode(menuCode);
		
		modelAndView.addObject("menuList", adminService.selectMenuList());
		modelAndView.addObject("itemCateList", adminService.selectItemCategory());
		modelAndView.addObject("selectedSideMenu", sideMenuCode);
		modelAndView.addObject("selectedMenu", menuCode);
		modelAndView.addObject("selectedSubMenu", subMenuCode);
		modelAndView.addObject("selectedAdminMenu", adminMenuCode);
		modelAndView.addObject("sideMenuList", adminService.selectSideMenuList(sideMenuVO));
		modelAndView.addObject("subMenuList", adminService.selectSubMenuList(subMenuVO));
	}
}
