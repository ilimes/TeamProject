package com.project.trip.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.project.trip.admin.service.AdminService;
import com.project.trip.admin.vo.SubMenuVO;
import com.project.trip.board.service.BoardService;
import com.project.trip.board.vo.BoardVO;
import com.project.trip.member.vo.MemberVO;

@Service("boardInterceptor")
public class BoardInterceptor extends HandlerInterceptorAdapter{
	
	@Resource(name = "boardService")
	private BoardService boardService;
	
	@Resource(name = "adminService")
	private AdminService adminService;
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		//공지사항 게시글 목록 보내기
		modelAndView.addObject("noticeList", boardService.selectNoticeList());		
		
		String subMenuCode = request.getParameter("subMenuCode");
		String sideMenuCode = request.getParameter("sideMenuCode");
		String menuCode = request.getParameter("menuCode");
		int nowPage;
		if(request.getParameter("nowPage") != null) {
			nowPage = Integer.parseInt(request.getParameter("nowPage"));
		}
		else {
			nowPage = 1;
		}
		
		//고객센터 페이지 이동할 때
		if(modelAndView.getViewName().equals("board/board_list")) {
			if (sideMenuCode == null) {
				sideMenuCode = ("SIDE_MENU_001");
			}
			if(menuCode == null) {
				menuCode = "SERVICE";
			}
		}
		
		BoardVO boardVO = new BoardVO();
		boardVO.setMenuCode(menuCode);
		boardVO.setSideMenuCode(sideMenuCode);
		boardVO.setNowPage(nowPage);
		
		//검색 기능 데이터 받고 넣기
		String title = request.getParameter("title");
		boardVO.setTitle(title);
		String content = request.getParameter("content");
		boardVO.setContent(content);
		String writer = request.getParameter("writer");
		boardVO.setWriter(writer);
		
		String boardTitle = "";
		if (sideMenuCode.equals("SIDE_MENU_001")) {
			boardTitle = "공지사항";
		} 
		else if (sideMenuCode.equals("SIDE_MENU_002")) {
			boardTitle = "1:1 문의";
		} 
		
		if(sideMenuCode.equals("SIDE_MENU_002")) {
			HttpSession session = request.getSession();
			String loginId = "";
			if(session.getAttribute("loginInfo") == null) {
				modelAndView.addObject("message", "<strong>현재 로그인 상태가 아닙니다.</strong> 1:1 문의는 로그인 후 이용해주세요.");
			}
			else {
				loginId = ((MemberVO)(session.getAttribute("loginInfo"))).getMemId();
				modelAndView.addObject("message", "등록하신 문의글이 없습니다.");
			}
			//memId 채워주기
			boardVO.setWriter(loginId);
		}
		
		//1. 페이징 처리 위해서 게시글 세기
		boardVO.setTotalCnt(boardService.selectBoardListCnt(boardVO));
		
		// 2. 페이징 처리를 위한 세팅 메소드 호출
		boardVO.setPageInfo();
		
		//메뉴 코드가 null 이면 001로 설정
		if(menuCode == null) {
			menuCode = "MENU_001";
		}
		
		//서브 메뉴 관련 메뉴코드 설정
		SubMenuVO subMenuVO = new SubMenuVO();
		subMenuVO.setMenuCode(menuCode);
		
		//사이드 메뉴 볼드처리 위해서 선택된 사이드메뉴 보내기
		modelAndView.addObject("selectedSideMenu", sideMenuCode);
		
		//상단 메뉴 보내기
		modelAndView.addObject("menuList", adminService.selectMenuList());
		
		//타이틀 보내기
		modelAndView.addObject("boardTitle", boardTitle);
		
		//게시글 목록 보내기
		modelAndView.addObject("boardList", boardService.selectBoardList(boardVO));
		
		//상단 공지를 위한 게시글 목록 보내기
		modelAndView.addObject("topBoardList", boardService.selectAllBoardList(boardVO));
		
		//사이드메뉴 리스트 보내기
		modelAndView.addObject("sideMenuList", adminService.selectSideMenuList(boardVO));
		
		//BoardVO 보내기 - 페이징 처리 위해서
		modelAndView.addObject("boardVO", boardVO);
		
		//임시 서브메뉴 - itemCateList로 보냄
		modelAndView.addObject("itemCateList", adminService.selectItemCategory());
		
		//선택된 메뉴코드, 서브 메뉴 코드 보내기
		modelAndView.addObject("selectedMenu", menuCode);
		modelAndView.addObject("selectedSubMenu", subMenuCode);
	
	}
}
