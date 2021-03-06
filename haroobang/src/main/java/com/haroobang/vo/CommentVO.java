package com.haroobang.vo;

import java.util.List;

public class CommentVO {
	
	private int commentNo;
	private String content;
	private int rates;
	private int memberNo;
	private int roomNo;
	private int reportCount;
	private String regDate;
	private boolean restricted;
	private String nickName;
	private AccountVO member;
	private int reservationNo;
	private RoomVO roomVO;
	private List<RoomAttachVO> roomAttachList;
	
	public List<RoomAttachVO> getRoomAttachList() {
		return roomAttachList;
	}
	public void setRoomAttachList(List<RoomAttachVO> roomAttachList) {
		this.roomAttachList = roomAttachList;
	}
	public RoomVO getRoomVO() {
		return roomVO;
	}
	public void setRoomVO(RoomVO roomVO) {
		this.roomVO = roomVO;
	}
	public int getReservationNo() {
		return reservationNo;
	}
	public void setReservationNo(int reservationNo) {
		this.reservationNo = reservationNo;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public AccountVO getMember() {
		return member;
	}
	public void setMember(AccountVO member) {
		this.member = member;
	}
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getRates() {
		return rates;
	}
	public void setRates(int rates) {
		this.rates = rates;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public int getReportCount() {
		return reportCount;
	}
	public void setReportCount(int reportCount) {
		this.reportCount = reportCount;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public boolean isRestricted() {
		return restricted;
	}
	public void setRestricted(boolean restricted) {
		this.restricted = restricted;
	}
	

}
