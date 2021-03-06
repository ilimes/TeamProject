package com.project.trip.item.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonObject;
import com.project.trip.admin.service.AdminService;
import com.project.trip.admin.vo.MenuVO;
import com.project.trip.admin.vo.SideMenuVO;
import com.project.trip.board.service.BoardService;
import com.project.trip.board.vo.BoardReplyVO;
import com.project.trip.board.vo.BoardVO;
import com.project.trip.board.vo.PageVO;
import com.project.trip.buy.vo.BookViewVO;
import com.project.trip.item.service.ItemService;
import com.project.trip.item.vo.ItemVO;
import com.project.trip.item.vo.ReviewLikeVO;
import com.project.trip.item.vo.ReviewReplyVO;
import com.project.trip.item.vo.ReviewVO;
import com.project.trip.member.vo.MemberVO;

import oracle.jdbc.proxy.annotation.Post;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Resource(name="adminService")
	private AdminService adminService;
	
	@Resource(name="itemService")
	private ItemService itemService;
	
	@Resource(name="boardService")
	private BoardService boardService;
	
	@GetMapping("/mainPage")
	public String mainPage(Model model, ReviewVO reviewVO) {
		reviewVO.setRowNum(5);
		model.addAttribute("reviewList", itemService.selectBestReview(reviewVO));
		
		return "template/main";
	}
	
	@GetMapping("/itemList")
	public String itemList(Model model, ItemVO itemVO) {
		
		//????????? ????????? ?????????
		model.addAttribute("itemList", itemService.selectItemList(itemVO));
		
		return "item/item_list";
	}
	
	@GetMapping("/itemDetail")
	public String itemDetail(Model model, ItemVO itemVO, PageVO pageVO, ReviewVO reviewVO) {
		
		//????????? ???????????? ?????????
		model.addAttribute("itemInfo", itemService.selectItemDetail(itemVO));
		//1. ????????? ?????? ????????? ????????? ??????
		int totalCnt = itemService.selectReviewListCnt(reviewVO);
		reviewVO.setTotalCnt(totalCnt);
		// -- ?????? ???????????? ???????????? ????????? displayCnt??? totalCnt??? ??????.
		reviewVO.setDisplayCnt(totalCnt);
		// 2. ????????? ????????? ?????? ?????? ????????? ??????
		reviewVO.setPageInfo();   
		//?????? ????????? ?????????
		model.addAttribute("reviewList", itemService.selectReviewList(reviewVO));
		
		return "item/item_detail";
	}
	
	@GetMapping("/tripReview")
	public String tripReview() {
		return "redirect:/item/review?menuCode=MENU_002";
	}
	
	@GetMapping("/bestReview")
	public String bestReview(Model model, PageVO pageVO, ReviewVO reviewVO) {
		reviewVO.setRowNum(10);
		model.addAttribute("reviewList", itemService.selectBestReview(reviewVO));
		return "item/best_review";
	}
	
	@GetMapping("/review")
	public String review(Model model, PageVO pageVO, ReviewVO reviewVO) {
		//1. ????????? ?????? ????????? ????????? ??????
		reviewVO.setTotalCnt(itemService.selectReviewListCnt(reviewVO));
		// 2. ????????? ????????? ?????? ?????? ????????? ??????
		reviewVO.setPageInfo();    
		
		model.addAttribute("reviewList", itemService.selectReviewList(reviewVO));
		return "item/review";
	}
	
	@GetMapping("/tripInfo")
	public String tripInfo() {
		return "item/weather";
	}
	
	@GetMapping("/weather")
	public String weather() {
		return "item/weather";
	}
	
	@GetMapping("/needs")
	public String needs() {
		return "item/needs";
	}
	
	@GetMapping("/reviewWriteForm")
	public String reviewWriteForm(Model model, BookViewVO bookViewVO, HttpSession session) {
		//memId ???????????? - ???????????? & ????????????
		String loginId = ((MemberVO)(session.getAttribute("loginInfo"))).getMemId();
		bookViewVO.setMemId(loginId);
		//?????? ????????? ?????????
		model.addAttribute("bookList", itemService.selectBookList(bookViewVO));
		return "item/review_write_form";
	}
	
	@PostMapping("/insertReview")
	public String insertReview(HttpSession session, ReviewVO reviewVO) {
		//memId ???????????? - ????????????
		String loginId = ((MemberVO)(session.getAttribute("loginInfo"))).getMemId();
		//memId ????????????
		reviewVO.setWriter(loginId);
		
		itemService.insertReview(reviewVO);
		
		return "redirect:/item/review?menuCode=MENU_002&selectedMenu=MENU_002";
	}
	
	// ????????? ?????????
    @RequestMapping(value="/fileupload", method = RequestMethod.POST)
    public void imageUpload(HttpServletRequest request, HttpServletResponse response, MultipartHttpServletRequest multiFile, @RequestParam MultipartFile upload) throws Exception{
    	// ?????? ?????? ??????
    	UUID uid = UUID.randomUUID();
    	
    	OutputStream out = null;
    	PrintWriter printWriter = null;
    	
    	//?????????
    	response.setCharacterEncoding("utf-8");
    	response.setContentType("text/html;charset=utf-8");
    	try{
    		//?????? ?????? ????????????
    		String fileName = upload.getOriginalFilename();
    		byte[] bytes = upload.getBytes();
    		
    		//????????? ?????? ??????
    		String path = "D:/Git/workspaceSTS/Trip/src/main/webapp/resources/ckeditor/images/";	// ????????? ?????? ??????(?????? ?????? ??????)
    		String ckUploadPath = path + uid + "_" + fileName;
    		File folder = new File(path);
    		System.out.println("path:"+path);	// ????????? ???????????? console??? ??????
    		//?????? ???????????? ??????
    		if(!folder.exists()){
    			try{
    				folder.mkdirs(); // ?????? ??????
    		}catch(Exception e){
    			e.getStackTrace();
    		}
    	}
    	
    	out = new FileOutputStream(new File(ckUploadPath));
    	out.write(bytes);
    	out.flush(); // outputStram??? ????????? ???????????? ???????????? ?????????
    	
    	String callback = request.getParameter("CKEditorFuncNum");
    	printWriter = response.getWriter();
    	String fileUrl = "/item/ckImgSubmit?uid=" + uid + "&fileName=" + fileName; // ????????????
    	
    	// ???????????? ????????? ??????
    	printWriter.println("<script>window.parent.CKEDITOR.tools.callFunction("+callback+",'"+fileUrl+"','???????????? ????????????????????????.')"+"</script>");
    	printWriter.flush();
    	
    	}catch(IOException e){
    		e.printStackTrace();
    	} finally {
    		try {
    		if(out != null) { out.close(); }
    		if(printWriter != null) { printWriter.close(); }
    	} catch(IOException e) { e.printStackTrace(); }
    	}
    	return;
    }
	
 // ????????? ????????? ????????? ????????????
    @RequestMapping(value="/ckImgSubmit")
    public void ckSubmit(@RequestParam(value="uid") String uid
    		, @RequestParam(value="fileName") String fileName
    		, HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
    	
    	//????????? ????????? ????????? ??????
    	String path = "D:/Git/workspaceSTS/Trip/src/main/webapp/resources/ckeditor/images/";	// ????????? ????????? ??????
    	System.out.println("path:"+path);
    	String sDirPath = path + uid + "_" + fileName;
    	
    	File imgFile = new File(sDirPath);
    	
    	//?????? ????????? ?????? ????????? ?????? ??????????????? ??? ????????? ????????? ????????????.
    	if(imgFile.isFile()){
    		byte[] buf = new byte[1024];
    		int readByte = 0;
    		int length = 0;
    		byte[] imgBuf = null;
    		
    		FileInputStream fileInputStream = null;
    		ByteArrayOutputStream outputStream = null;
    		ServletOutputStream out = null;
    		
    		try{
    			fileInputStream = new FileInputStream(imgFile);
    			outputStream = new ByteArrayOutputStream();
    			out = response.getOutputStream();
    			
    			while((readByte = fileInputStream.read(buf)) != -1){
    				outputStream.write(buf, 0, readByte); 
    			}
    			
    			imgBuf = outputStream.toByteArray();
    			length = imgBuf.length;
    			out.write(imgBuf, 0, length);
    			out.flush();
    			
    		}catch(IOException e){
    			e.printStackTrace();
    		}finally {
    			outputStream.close();
    			fileInputStream.close();
    			out.close();
    			}
    		}
    }
    
	@GetMapping("/reviewDetail")
	public String reviewDetail(Model model, HttpSession session, MenuVO menuVO, ReviewVO reviewVO, ReviewLikeVO reviewLikeVO, ReviewReplyVO reviewReplyVO) {
		//????????? ???????????????
		itemService.updateReadCnt(reviewVO);
		
		//memId ???????????? - ????????????, ?????? ?????? emptyID??? ??????
		String memId = "";
		if(session.getAttribute("loginInfo") == null) {
			memId = "emptyID";
		}
		else {
			memId = ((MemberVO)(session.getAttribute("loginInfo"))).getMemId();
		}
		
		reviewLikeVO.setReviewNum(reviewVO.getReviewNum());
		reviewLikeVO.setMemId(memId);
		
		model.addAttribute("myReviewLikeCnt", itemService.selectMyReviewLikeCnt(reviewLikeVO));

		//?????? ?????? ?????????
		model.addAttribute("reviewInfo", itemService.selectReviewDetail(reviewVO));
		//?????? ????????? ?????????
		model.addAttribute("reviewReplyList", itemService.selectReplyList(reviewReplyVO));
		
		return "item/review_detail";
	}
	
	@GetMapping("/deleteReview")
	public String deleteBoard(Model model, MenuVO menuVO, ReviewVO reviewVO) {
		itemService.deleteReview(reviewVO);
		return "redirect:/item/review?menuCode=" + menuVO.getMenuCode();
	}
	
	@ResponseBody
	@PostMapping("/updateReview")
	public ReviewVO updateBoard(ReviewVO reviewVO) {
		itemService.updateReview(reviewVO);
		return reviewVO;
	}
	
	@PostMapping("/insertMyReviewLike")
	public String insertMyReviewLike(ReviewLikeVO reviewLikeVO) {
		itemService.insertMyReviewLike(reviewLikeVO);
		return "redirect:/item/reviewDetail?menuCode=MENU_002&reviewNum=" + reviewLikeVO.getReviewNum();
	}
	
	@PostMapping("/deleteMyReviewLike")
	public String deleteMyReviewLike(ReviewLikeVO reviewLikeVO) {
		itemService.deleteMyReviewLike(reviewLikeVO);
		return "redirect:/item/reviewDetail?menuCode=MENU_002&reviewNum=" + reviewLikeVO.getReviewNum();
	}
	
	@PostMapping("/insertReviewReply")
	public String insertReviewReply(ReviewReplyVO reviewReplyVO, HttpSession session) {
		//memId ???????????? - ???????????? & ????????????
		String loginId = ((MemberVO)(session.getAttribute("loginInfo"))).getMemId();
		reviewReplyVO.setWriter(loginId);
		
		itemService.insertReviewReply(reviewReplyVO);
		return "redirect:/item/reviewDetail?menuCode=MENU_002&reviewNum=" + reviewReplyVO.getReviewNum();
	}
	
	@PostMapping("/deleteReviewReply")
	public String deleteReviewReply(ReviewReplyVO reviewReplyVO) {
		itemService.deleteReviewReply(reviewReplyVO);
		return "redirect:/item/reviewDetail?menuCode=MENU_002&reviewNum=" + reviewReplyVO.getReviewNum();
	}
	
	@GetMapping("/popUp")
    public ModelAndView popupGet(Model model, ReviewReplyVO reviewReplyVO, HttpSession session) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/item/modify_reply");
        
		//memId ???????????? - ???????????? & ????????????
		String loginId = ((MemberVO)(session.getAttribute("loginInfo"))).getMemId();
		reviewReplyVO.setWriter(loginId);
        
        return mav;
    }
	
	@PostMapping("/modifyReviewReply")
	public void modifyReviewReply(ReviewReplyVO reviewReplyVO) {
		itemService.updateReviewReply(reviewReplyVO);
	}
	
	@GetMapping("/chatting")
	public String goChat() {
		return "redirect:/chat/login?menuCode=MENU_003";
	}
	
	@GetMapping("/mapRoute")
	public String mapRoute() {
		return "item/map_route";
	}
	
}
