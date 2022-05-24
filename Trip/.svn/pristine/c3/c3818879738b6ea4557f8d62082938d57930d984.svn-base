package com.project.trip.board.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.trip.admin.vo.SideMenuVO;
import com.project.trip.board.vo.BoardReplyVO;
import com.project.trip.board.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<BoardVO> selectBoardList(BoardVO boardVO) {
		return sqlSession.selectList("boardMapper.selectBoardList", boardVO);
	}
	
	@Override
	public List<BoardVO> selectAllBoardList(BoardVO boardVO) {
		return sqlSession.selectList("boardMapper.selectAllBoardList", boardVO);
	}

	@Override
	public BoardVO selectBoard(BoardVO boardVO) {
		return sqlSession.selectOne("boardMapper.selectBoard", boardVO);
	}

	@Override
	public int selectBoardListCnt(BoardVO boardVO) {
		return sqlSession.selectOne("boardMapper.selectBoardListCnt", boardVO);
	}

	@Override
	public void insertBoard(BoardVO boardVO) {
		sqlSession.insert("boardMapper.insertBoard", boardVO);
	}

	@Override
	public void updateReadCnt(BoardVO boardVO) {
		sqlSession.update("boardMapper.updateReadCnt", boardVO);
	}

	@Override
	public void deleteBoard(BoardVO boardVO) {
		sqlSession.delete("boardMapper.deleteBoard", boardVO);
	}

	@Override
	public void updateBoard(BoardVO boardVO) {
		sqlSession.update("boardMapper.updateBoard", boardVO);
	}

	@Override
	public List<BoardVO> selectNoticeList() {
		return sqlSession.selectList("boardMapper.selectNoticeList");
	}

	@Override
	public void insertBoardReply(BoardReplyVO boardReplyVO) {
		sqlSession.insert("boardMapper.insertBoardReply", boardReplyVO);
	}

	@Override
	public List<BoardReplyVO> selectReplyList(BoardReplyVO boardReplyVO) {
		return sqlSession.selectList("boardMapper.selectReplyList", boardReplyVO);
	}
	
	@Override
	public void deleteBoardReply(BoardReplyVO boardReplyVO) {
		sqlSession.delete("boardMapper.deleteBoardReply", boardReplyVO);
	}

	@Override
	public void updateBoardReply(BoardReplyVO boardReplyVO) {
		sqlSession.update("boardMapper.updateBoardReply", boardReplyVO);
	}

	
}
