package com.project.trip.admin.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.project.trip.admin.service.AdminService;
import com.project.trip.admin.vo.BookSearchVO;
import com.project.trip.admin.vo.SideMenuVO;
import com.project.trip.admin.vo.SlideImageVO;
import com.project.trip.board.service.BoardService;
import com.project.trip.board.vo.BoardReplyVO;
import com.project.trip.board.vo.BoardVO;
import com.project.trip.buy.service.BuyService;
import com.project.trip.buy.vo.BookViewVO;
import com.project.trip.buy.vo.BuyVO;
import com.project.trip.item.service.ItemService;
import com.project.trip.item.vo.ImageVO;
import com.project.trip.item.vo.ItemVO;
import com.project.trip.member.vo.MemberVO;
import com.project.trip.util.TripUtil;

import net.sf.json.JSONArray;
import oracle.jdbc.proxy.annotation.Post;


@Controller
@RequestMapping("/admin")
public class AdminController {
		
	@Resource(name = "adminService")
	private AdminService adminService;
	
	@Resource(name = "itemService")
	private ItemService itemService;
	
	@Resource(name = "buyService")
	private BuyService buyService;
	
	@Resource(name = "boardService")
	private BoardService boardService;
	
	
	//????????? ?????? ????????? ????????? ????????? -> ???????????? ?????????
	@GetMapping("/itemManage")
	public String adminMenu() {
		
		return "redirect:/admin/regItem";
	}

	//???????????? ?????????
	@GetMapping("/itemList")
	public String itemList(Model model, ItemVO itemVO) {
		
		// 1. ?????? ???????????? ?????? ??????
		int listCnt = adminService.selectItemListCnt();
		
		itemVO.setTotalCnt(listCnt);
		
		// 2. ????????? ????????? ?????? ?????? ????????? ??????
		itemVO.setPageInfo();
		
		model.addAttribute("itemList", adminService.selectPageItemList(itemVO));
		
		return "admin/item_list_manage";
	}
	
	//???????????? ????????? ??????
	@GetMapping("/regItem")
	public String regItem(Model model, BookSearchVO bookSearchVO) {
		
		
		//????????? 1?????? ?????? ????????? ??????
		String firstDate = TripUtil.getStartDateToString();
		String nowDate = TripUtil.getNowDateToString();
		
		if(bookSearchVO.getSearchFromDate() == null) {
			bookSearchVO.setSearchFromDate(firstDate);
		}
		
		if(bookSearchVO.getSearchToDate() == null) {
			bookSearchVO.setSearchToDate(nowDate);
		}

		model.addAttribute("areaList", adminService.selectItemCategory());
		
		return "admin/reg_item";
	}
	
	//???????????? ??????????????? ???????????? ??????
	@PostMapping("/regItem")
	public String regItem(ItemVO itemVO,  MultipartHttpServletRequest multi, Model model) {

		//????????? ????????? ????????? ??????(List) ??????
		List<ImageVO> imgList = new ArrayList<ImageVO>();
		
		//????????? ?????? ?????? ?????? ??? ????????? ????????? ??????
		ImageVO imageVO = new ImageVO();
		
		//????????? ????????? IMG_CODE ?????? ??????
		int nextImgCode = adminService.selectNextImgCode();
		
		//????????? ????????? ITEM_CODE ?????? ??????
		String NextItemCode = adminService.selectNextItemCode();
		
		//????????? ?????? ?????????
		Iterator<String> inputTagNames = multi.getFileNames();
		
		//??????????????? ????????? ?????? ??????
		String uploadPath = "D:\\Git\\workspaceSTS\\Trip\\src\\main\\webapp\\resources\\images\\";
		
		while(inputTagNames.hasNext()) {
			//"mainImg", "subImg"
			String inputTagName = inputTagNames.next();
			
			//?????? ??????...
			if(inputTagName.equals("subImg")) {
				List<MultipartFile> fileList = multi.getFiles(inputTagName);
				
				for(MultipartFile file : fileList) {
					
					//??????????????? ?????? ????????? (???????????????)
					String originFileName = file.getOriginalFilename();
					
					if(!originFileName.equals("")) {
						//????????? ?????????
						String attachedFileName = System.currentTimeMillis() + "_" + originFileName;
						
						try {
							file.transferTo(new File(uploadPath + attachedFileName));
							
							ImageVO vo = new ImageVO();
							vo.setImgCode(nextImgCode++);
							vo.setOriginImgName(originFileName);
							vo.setAttachedImgName(attachedFileName);
							vo.setIsMain("N");
							vo.setItemCode(NextItemCode);
							imgList.add(vo);
							
						} catch (IllegalStateException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			//?????? ??????...
			else {
				//name??? "mainImg"??? input????????? ?????? ????????? ?????? ???.
				MultipartFile file = multi.getFile(inputTagName);
				
				//??????????????? ?????? ????????? (???????????????)
				String originFileName = file.getOriginalFilename();
				
				if(!originFileName.equals("")) {
					//????????? ?????????
					String attachedFileName = System.currentTimeMillis() + "_" + originFileName;
					
					//?????? ?????????
					//??????????????? ?????? ??? ???????????? ?????????
					try {
						file.transferTo(new File(uploadPath + attachedFileName));
						
						ImageVO vo = new ImageVO();
						vo.setImgCode(nextImgCode++);
						vo.setOriginImgName(originFileName);
						vo.setAttachedImgName(attachedFileName);
						vo.setIsMain("Y");
						vo.setItemCode(NextItemCode);
						
						
						imgList.add(vo);
						
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		itemVO.setItemCode(NextItemCode);
		imageVO.setImageList(imgList);
		adminService.regItem(itemVO, imageVO);
		
		return "redirect:/admin/itemManage";
	}
			
	//?????? ?????? ??????
	@GetMapping("deleteSelectedItem")
	public String deleteSelectedItem(ItemVO itemVO, SideMenuVO sideMenuVO) {
		
		//????????? ?????? ????????? ??????
		String filePath = "D:\\Git\\workspaceSTS\\Trip\\src\\main\\webapp\\resources\\images\\";
		List<ImageVO> image = itemService.selectImageList(itemVO);
		
		for(ImageVO img : image) {
			img.getAttachedImgName();
			File file = new File(filePath + img.getAttachedImgName());
			System.out.println(img.getAttachedImgName());
			if(file.exists()) {
				file.delete();
			}
		}
		
		adminService.deleteSelectedItem(itemVO);
		
		return "redirect:/admin/itemList";
	}
	
	//?????? ??????	
	@GetMapping("/itemUpdate")
	public String itemUpdate(Model model, ItemVO itemVO) {
		
		model.addAttribute("itemInfo", itemService.selectItemDetail(itemVO));
		
		return "admin/update_item";
	}
	@PostMapping("updateItem")
	public String updateItem(ItemVO itemVO) {
		
		adminService.updateItem(itemVO);
		
		return "redirect:/admin/itemList";
	}
		
	//???????????? ????????? ?????? ????????? ??????
	@GetMapping("/regImage")
	public String regImage(SlideImageVO slideImageVO) {
		return "admin/reg_image";
	}
	
	//???????????? ???????????? ????????? ??????
	@PostMapping("/regImage")
	public String regImage(MultipartHttpServletRequest multi, Model model, SlideImageVO slideImageVO) {
		
		//????????? ?????? ?????????
		Iterator<String> inputTagNames = multi.getFileNames();
		
		//??????????????? ????????? ?????? ??????
		String uploadPath = "D:\\Git\\workspaceSTS\\Trip\\src\\main\\webapp\\resources\\images\\slide\\";
		
		String inputTagName = inputTagNames.next();
		
		List<SlideImageVO> imageSize = adminService.selectSlideList();
		
		int index = adminService.selectImageIndex();
		
		if(imageSize.size() < 4) {
		
			
		if(inputTagName.equals("slideImage")) {
	
			MultipartFile file = multi.getFile(inputTagName);
			
			//??????????????? ?????? ????????? (???????????????)
			String originFileName = file.getOriginalFilename();
			
			String extension = originFileName.substring(originFileName.length()-4);
			
			if(!originFileName.equals("")) {
				
				//????????? ?????????
				String attachedFileName = "slideImage" + index + extension;
				
				//?????? ?????????
				try {
					file.transferTo(new File(uploadPath + attachedFileName));
					
					slideImageVO.setOriginImgName(originFileName);
					slideImageVO.setAttachedImgName(attachedFileName);
					
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		
		}
		adminService.regSlideImage(slideImageVO);
		}
		return "redirect:/admin/regImage";
	}
	
	//???????????? ????????? ?????? ?????????
	@GetMapping("/updateImage")
	public String updateImage(Model model) {
		model.addAttribute("imageList", adminService.selectSlideList());
		return "admin/update_image";
	}
	
	//???????????? ????????? ??????
	@PostMapping("/updateImage")
	public String updateImage(SlideImageVO slideImageVO, MultipartHttpServletRequest multi) {
		
		//????????? ?????? ?????????
		Iterator<String> inputTagNames = multi.getFileNames();
		
		//??????????????? ????????? ?????? ??????
		String uploadPath = "D:\\Git\\workspaceSTS\\Trip\\src\\main\\webapp\\resources\\images\\slide\\";
		
		String inputTagName = inputTagNames.next();
		String imgCode = slideImageVO.getImgCode();
		
		String index = imgCode.substring(imgCode.length()-1);
		
		if(inputTagName.equals("updateImg")) {
	
			MultipartFile file = multi.getFile(inputTagName);
			
			//??????????????? ?????? ????????? (???????????????)
			String originFileName = file.getOriginalFilename();
		
			String extension = originFileName.substring(originFileName.length()-4);
			
			if(!originFileName.equals("")) {
				//????????? ?????????
				String attachedFileName = "slideImage" + index + extension;
				
			//?????? ?????????
			try {
					file.transferTo(new File(uploadPath + attachedFileName));
					
					slideImageVO.setOriginImgName(originFileName);
					slideImageVO.setAttachedImgName(attachedFileName);
					
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		
		}
		
		adminService.updateSlideImage(slideImageVO);
		
		return "redirect:/admin/updateImage";
	}
	
	//???????????? ????????? ??????
	@GetMapping("/memberManage")
	public String memberManage(Model model) {
		
		model.addAttribute("memberList", adminService.selectMemberList());
		return "admin/member_manage";
	}
	
	//?????? ???????????? ?????????
	@GetMapping("memberDetail")
	public String memberDetail(Model model, MemberVO memberVO) {
		model.addAttribute("member", adminService.selectMemberDetail(memberVO));
		return "admin/member_detail";
	}
	
	//???????????? ?????? ??????
	@GetMapping("/memberSecession")
	public String memberSecession(Model model) {
		
		model.addAttribute("memSecession", adminService.selectDeactiveList());
		
		return "admin/member_secession";
	}
	@GetMapping("/SelectMemberSecession")
	public String selectedMemberSecession(MemberVO memberVO) {
		
		adminService.selectMemberSecession(memberVO);
		
		return "redirect:/admin/memberSecession";
	}
	
	//???????????? ????????? ??????
	@GetMapping("/bookManage")
	public String bookManage(Model model, BookViewVO bookViewVO) {
		
		// 1. ?????? ???????????? ?????? ??????
		int listCnt = adminService.selectBookListCnt();
		
		bookViewVO.setTotalCnt(listCnt);
		
		// 2. ????????? ????????? ?????? ?????? ????????? ??????
		bookViewVO.setPageInfo();
		
		model.addAttribute("bookList", adminService.selectBookList(bookViewVO));
		
		return "admin/book_list";
	}
	
	//?????? ??????
	@PostMapping("/bookCancel")
	@ResponseBody
	public void bookCancel(BuyVO buyVO) {
		
		adminService.deleteBook(buyVO);
		
	}
	
	//?????? ??? ???????????? ?????????
	@GetMapping("/helpManage")
	public String helpManage(Model model) {
		
		model.addAttribute("enquiryList", adminService.selectEnquiryList());
		
		return "admin/enquiry_list";
	}
	
	//1:1 ?????? ????????????
	@GetMapping("/enquDetail")
	public String enquDetail(BoardVO boardVO, Model model, SideMenuVO sideMenuVO, BoardReplyVO boardReplyVO) {
		 
	model.addAttribute("adminMenuList", adminService.selectAdminMenuList());
	model.addAttribute("sideMenuList" ,adminService.selectSideMenuList(sideMenuVO));
	model.addAttribute("selectedSideMenu", sideMenuVO.getSideMenuCode());
	model.addAttribute("boardInfo", boardService.selectBoard(boardVO));
	
	//?????? ????????? ?????????
	model.addAttribute("boardReplyList", boardService.selectReplyList(boardReplyVO));
	 
		return "admin/enquiry_detail";
	}
	
	//1:1 ?????? ?????? ??????
	@PostMapping("/boardReply")
	public String boardReply(BoardReplyVO boardReplyVO, HttpSession session) {
		String loginId = ((MemberVO)(session.getAttribute("loginInfo"))).getMemId();
		boardReplyVO.setWriter(loginId);
		
		boardService.insertBoardReply(boardReplyVO);
		
		return "redirect:/admin/enquDetail?sideMenuCode=SIDE_MENU_401&boardNum=" + boardReplyVO.getBoardNum();
	}
	
	//????????? ??????
	@GetMapping("/dateSales")
	public String dateSales(Model model, BookSearchVO bookSearchVO) {
		String defaultDate = TripUtil.getDefaultDate();
		
		//?????? ??????
		List<BuyVO> list = adminService.selectMonthSales();

		Gson gson = new Gson();
		JsonArray jsonArray = new JsonArray();
		
		Iterator<BuyVO> it = list.iterator();
		while(it.hasNext()) {
			BuyVO buyVO = it.next();
			JsonObject object = new JsonObject();
			int buyPrice = buyVO.getBuyPrice();
			
			object.addProperty("totalPrice", buyPrice);
			jsonArray.add(object);
		}
		
		
		//?????? ??????
		if(bookSearchVO.getSearchFromDate() == null) {
			bookSearchVO.setSearchFromDate(defaultDate);
		}
		List<BuyVO> yearList = adminService.selectYearSales(bookSearchVO);

		Gson gson1 = new Gson();
		JsonArray jsonArray1 = new JsonArray();
		
		Iterator<BuyVO> it1 = yearList.iterator();
		while(it1.hasNext()) {
			BuyVO buyVO = it1.next();
			JsonObject object = new JsonObject();
			int buyPrice = buyVO.getBuyPrice();
			String bookYear = buyVO.getBookDate();
			
			object.addProperty("bookYear", bookYear);
			object.addProperty("totalPrice", buyPrice);
			jsonArray1.add(object);
		}
		
		
		String json = gson.toJson(jsonArray);
		String json1 = gson1.toJson(jsonArray1);
		
		
		model.addAttribute("month", json);
		model.addAttribute("year", json1);

		
		return "admin/date_sales";
	}
	
	@GetMapping("/mapTest")
	public String mapTest() {
		
		return "admin/map_test";
	}
	@GetMapping("/mapTest2")
	public String mapTest2() {
		
		return "admin/map_test2";
	}
	
	@PostMapping("/calculation")
	@ResponseBody
	public List<Map<String, String>> calculation(String data) {
		
		int index= 0;
		List<Map<String, String>> list = JSONArray.fromObject(data);
		//?????? ??? ????????? ?????? ??????
		String[] lng = new String[list.size()];
		String[] lat = new String[list.size()];
		for(Map<String, String> map : list) {
			System.out.println("lat : " + map.get("lat") + " / lng=" + map.get("lng"));
			lng[index] = map.get("lng");
			lat[index] = map.get("lat");
			index++;
		}
		
		List<Map<String, String>> resultList = new ArrayList<Map<String,String>>();
		
		// ??????(Meter) ????????? ???????????? -> ??????1, ??????1, ??????2, ??????2
			List<Double> distanceList = new ArrayList<Double>();
			Map<Integer, Double> map = new HashMap<>();
			int distanceIndex = 0;
			for(int i = 0 ; i < lng.length - 1 ; i++) {
				distanceList.add(distance(Double.parseDouble(lat[distanceIndex]), Double.parseDouble(lng[distanceIndex]), Double.parseDouble(lat[i + 1]), Double.parseDouble(lng[i + 1]), "meter"));
				map.put(i + 1, distance(Double.parseDouble(lat[distanceIndex]), Double.parseDouble(lng[distanceIndex]), Double.parseDouble(lat[i + 1]), Double.parseDouble(lng[i + 1]), "meter"));
			}
			
			Map<Integer, Double> sort_map_by_value = map.entrySet().stream()
					.sorted(Map.Entry.comparingByValue())
					.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

			
			List<Map.Entry<Integer, Double>> entries =
			        map.entrySet().stream()
			                      .sorted(Map.Entry.comparingByKey())
			                      .collect(Collectors.toList());
			// sort by value
			System.out.println();
			entries = map.entrySet().stream()
			        .sorted(Map.Entry.comparingByValue())
			        .collect(Collectors.toList());
			
			Map<String, String> resultMapFirst = new HashMap<String, String>();
			resultMapFirst.put("lat", lat[0]);
			resultMapFirst.put("lng", lng[0]);
			resultList.add(resultMapFirst);
			
			for (Map.Entry<Integer, Double> entry : entries) {
				Map<String, String> resultMap = new HashMap<String, String>();
			    resultMap.put("lat", lat[entry.getKey()]);
			    resultMap.put("lng", lng[entry.getKey()]);
			    resultList.add(resultMap);
			}
		System.out.println(resultList);
		
		return resultList;
	}
	
	//????????????
	private static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
        
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
         
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
         
        if (unit == "kilometer") {
            dist = dist * 1.609344;
        } else if(unit == "meter"){
            dist = dist * 1609.344;
        }
 
        return (dist);
    }
 
    // This function converts decimal degrees to radians
    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }
     
    // This function converts radians to decimal degrees
    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }

	
}
