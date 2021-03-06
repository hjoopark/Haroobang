package com.haroobang.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.haroobang.mapper.RoomListMapper;
import com.haroobang.vo.LikedVO;
import com.haroobang.vo.RoomAttachVO;
import com.haroobang.vo.RoomVO;

@Repository("RoomListDao")//커밋...
public class RoomListDaoImpl implements RoomListDao{
	
	@Autowired
	@Qualifier("RoomListMapper")
	private RoomListMapper roomListMapper;

	@Override
	public List<RoomVO> selectAllRooms() {
		List<RoomVO> rooms = roomListMapper.selectAllRooms();
		return rooms;
	}

	@Override
	public List<RoomAttachVO> selectRoomAttachByRoomNo(int roomNo) {
		List<RoomAttachVO> attachs = roomListMapper.selectRoomAttachByRoomNo(roomNo);
		return attachs;
	}

	@Override
	public List<RoomVO> selectAllDisapprovalRooms() {
		List<RoomVO> rooms = roomListMapper.selectAllDisapprovalRooms();
		return rooms;
	}

	@Override
	public void approvalRoom(String formdate) {
		roomListMapper.approvalRoom(Integer.parseInt(formdate));
	}

	@Override
	public List<RoomVO> selectAllRoomByPage(int from, int to) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("first", from);
		params.put("last", to);
		
		List<RoomVO> rooms = roomListMapper.selectRoomList(params);
		return rooms;
	}

	@Override
	public int selectRoomCount() {
		int count = roomListMapper.selectRoomCount();
		return count;
	}

	@Override
	public int selectSearchRoomCount(RoomVO vo) {
		int count = roomListMapper.selectSearchRoomCount(vo);
		return count;
	}
	
	@Override
	public List<RoomVO> searchRoomListDao(RoomVO vo, int from, int to) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("RoomVO", vo);
		params.put("first", from);
		params.put("last", to);
		
		List<RoomVO> list = roomListMapper.searchRoomList(params);
		return list;
	}

	@Override
	public void likedRoom(String memberno, String roomno) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("memberno", Integer.parseInt(memberno));
		params.put("roomno", Integer.parseInt(roomno));
		
		roomListMapper.likedRoom(params);
	}

	@Override
	public void unLikedRoom(String memberno, String roomno) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("memberno", Integer.parseInt(memberno));
		params.put("roomno", Integer.parseInt(roomno));
		
		roomListMapper.unLikedRoom(params);
	}

	@Override
	public List<LikedVO> selectAllLiked(int memberNo) {
		List<LikedVO> likeds = roomListMapper.selectAllLiked(memberNo);
		return likeds;
	}

	@Override
	public List<RoomVO> selectAllDisapprovalRoomByPage(int from, int to) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("first", from);
		params.put("last", to);
		
		List<RoomVO> rooms = roomListMapper.selectDisapprovalRoomList(params);
		return rooms;
	}

	@Override
	public int selectDisapprovalRoomCount() {
		int count = roomListMapper.selectDisapprovalRoomCount();
		return count;
	}

	@Override
	public void deleteRoom(String roomno) {
		roomListMapper.deleteRoom(Integer.parseInt(roomno));
	}

	@Override
	public void deleteapproval(String formdate) {
		roomListMapper.deleteapproval(Integer.parseInt(formdate));
	}

	@Override
	public int selectCountsint(int roomNo) {
		int counts = roomListMapper.selectCountsint(roomNo);
		return counts;
	}
}
