package com.project.trip.board.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.trip.admin.service.AdminService;
import com.project.trip.admin.vo.SideMenuVO;
import com.project.trip.board.service.BoardService;
import com.project.trip.board.vo.BoardReplyVO;
import com.project.trip.board.vo.BoardVO;
import com.project.trip.member.vo.MemberVO;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Resource(name="adminService")
	private AdminService adminService;
	
	@Resource(name="boardService")
	private BoardService boardService;
	
	@GetMapping("/boardList")
	public String boardList(Model model, SideMenuVO sideMenuVO, BoardVO boardVO) {
		return "board/board_list";
	}
	
	@GetMapping("/notice")
	public String notice() {
		return "board/board_list";
	}
	@GetMapping("/question")
	public String question() {
		return "board/board_list";
	}
	@GetMapping("/terms")
	public String terms() {
		return "board/terms_of_use";
	}
	@GetMapping("/companyMap")
	public String companyMap() {
		return "board/company_map";
	}
	
	@GetMapping("/boardWriteForm")
	public String boardWriteForm(Model model, SideMenuVO sideMenuVO, BoardVO boardVO) {
		//타이틀 보내기
		model.addAttribute("boardTitle", "글쓰기");
		
		return "board/board_write_form";
	}

	@PostMapping("/boardWrite")
	public String boardWrite(Model model, SideMenuVO sideMenuVO, BoardVO boardVO, HttpSession session) {
		//memId 받아오기 - 세션에서 & 채워주기
		String loginId = ((MemberVO)(session.getAttribute("loginInfo"))).getMemId();
		boardVO.setWriter(loginId);
		
		boardService.insertBoard(boardVO);
		
		return "redirect:/board/boardList?menuCode=" + sideMenuVO.getMenuCode() +"&sideMenuCode=" + sideMenuVO.getSideMenuCode();
	}
	
	@GetMapping("/boardDetail")
	public String boardDetail(Model model, SideMenuVO sideMenuVO, BoardVO boardVO, BoardReplyVO boardReplyVO) {
		//조회수 늘리기
		boardService.updateReadCnt(boardVO);
		//게시글 정보 보내기
		model.addAttribute("boardInfo", boardService.selectBoard(boardVO));
		//댓글 리스트 보내기
		model.addAttribute("boardReplyList", boardService.selectReplyList(boardReplyVO));
		
		return "board/board_detail";
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(Model model, SideMenuVO sideMenuVO, BoardVO boardVO) {
		boardService.deleteBoard(boardVO);
		return "redirect:/board/boardList?menuCode=" + sideMenuVO.getMenuCode() + "&sideMenuCode=" + sideMenuVO.getSideMenuCode();
	}
	
	@ResponseBody
	@PostMapping("/updateBoard")
	public BoardVO updateBoard(BoardVO boardVO) {
		boardService.updateBoard(boardVO);
		return boardVO;
	}
	
	@PostMapping("/insertBoardReply")
	public String insertBoardReply(BoardReplyVO boardReplyVO, HttpSession session) {
		//memId 받아오기 - 세션에서 & 채워주기
		String loginId = ((MemberVO)(session.getAttribute("loginInfo"))).getMemId();
		boardReplyVO.setWriter(loginId);
		
		boardService.insertBoardReply(boardReplyVO);
		return "redirect:/board/boardDetail?menuCode=SERVICE&sideMenuCode=SIDE_MENU_002&boardNum=" + boardReplyVO.getBoardNum();
	}
	
	@GetMapping("/popUp")
    public ModelAndView popupGet(Model model, BoardVO boardVO, BoardReplyVO boardReplyVO, HttpSession session) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/board/modify_reply");
        
		//memId 받아오기 - 세션에서 & 채워주기
		String loginId = ((MemberVO)(session.getAttribute("loginInfo"))).getMemId();
		boardReplyVO.setWriter(loginId);
        
        return mav;
    }
	
	@PostMapping("/deleteBoardReply")
	public String deleteReviewReply(BoardReplyVO boardReplyVO) {
		boardService.deleteBoardReply(boardReplyVO);
		return "redirect:/board/boardDetail?menuCode=SERVICE&sideMenuCode=SIDE_MENU_002&boardNum=" + boardReplyVO.getBoardNum();
	}
	
	@PostMapping("/modifyBoardReply")
	public void modifyBoardReply(BoardVO boardVO, BoardReplyVO boardReplyVO) {
		boardService.updateBoardReply(boardReplyVO);
	}
	
}
