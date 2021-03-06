package com.haroobang.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haroobang.service.MyRoomService;
import com.haroobang.ui.ThePager2;
import com.haroobang.vo.AccountVO;
import com.haroobang.vo.ReservationVO;
import com.haroobang.vo.RoomVO;

@Controller
@RequestMapping("/mypage")
public class MyRoomController {

	@Autowired
	@Qualifier("myRoomService")
	private MyRoomService myRoomService;

	// 이전 예약 리스트 페이지 보여주기
	@RequestMapping(value = "/myRoomReservation.action", method = RequestMethod.GET)
	public String myRoomReservation(@RequestParam("memberno") int memberNo, Model model, HttpSession session) {

		if (session.getAttribute("login") == null) {
			return "/account/login.action";
		} else {
			
			List<ReservationVO> myreservations = myRoomService.findAllMyReservations(memberNo);
			
			model.addAttribute("myreservations", myreservations);
		

			return "mypage/myRoomReservation";
		}

	}

	@RequestMapping(value = "/myRoomReservationDetail.action", method = RequestMethod.GET)
	public String myRoomReservationDetail(int reservationNo, Model model, HttpSession session) {

		if (session.getAttribute("login") == null) {
			return "redirect:/account/login.action";
		} else {
	
			ReservationVO reservationdetail = myRoomService.findReservationByRoomNo(reservationNo);

			model.addAttribute("reservation", reservationdetail);
			

			return "mypage/myRoomReservationDetail";
		}
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "/waitingList.action", method = RequestMethod.GET)
	public String lastReservationlist(@RequestParam("memberno")int memberNo, 
			@RequestParam(value = "pageno", required = false, defaultValue = "1")Integer pageNo, Model model, HttpSession session) {
		
		if (session.getAttribute("login") == null) {
			return "/account/login.action";
		} else {
			
			int pageSize = 4;	//한 페이지에 표시되는 데이터 개수
			int from = (pageNo - 1) * pageSize; // + 1; //해당 페이지에 포함된 시작 글번호
			int to = pageSize; /*from + pageSize;*/				//해당 페이지에 포함된 마지막 글번호 + 1
			int pagerSize = 5;	//한 번에 표시되는 페이지 번호 개수
			String linkUrl = "waitingList.action"; //페이지 번호를 눌렀을 때 이동할 경로
			
			List<RoomVO> waitings = myRoomService.findWaitingListByPage(memberNo, from, to);
			int likeCount = myRoomService.findWaitingCount(memberNo);
			
			ThePager2 pager = new ThePager2(likeCount, pageNo, memberNo, pageSize, pagerSize, linkUrl);
			
			model.addAttribute("waitings", waitings);
			model.addAttribute("pager", pager);
			model.addAttribute("pageno", pageNo);
			
			return "mypage/waitingList";
		}
	}
	
	@RequestMapping(value="/deleteMyRoom.action", method=RequestMethod.POST)
	@ResponseBody
	public String deleteMyRoom(String roomNo) {//HttpSession session, HttpServletRequest req, AccountVO account) {
		
		myRoomService.deleteMyRoom(roomNo);
		
		return "success";
	}
	
	@RequestMapping(value="/checkinApproval.action", method=RequestMethod.GET)
	@ResponseBody
	public String checkinApproval(int reservationNo) {
		String result = myRoomService.checkinApproval(reservationNo);
		return result;
	}
	
	@RequestMapping(value="calcelCheckin.action", method=RequestMethod.GET)
	@ResponseBody
	public String calcelCheckin(int reservationNo) {
		String result = myRoomService.calcelCheckin(reservationNo);
		return result;
	}
}
