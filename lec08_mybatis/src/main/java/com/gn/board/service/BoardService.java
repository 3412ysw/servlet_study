package com.gn.board.service;

import static com.gn.common.sql.SqlSessionTemplate.getSqlSeeeion;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.gn.board.dao.BoardDao;
import com.gn.board.vo.Board;

public class BoardService {
	
	public List<Board> selectBoardList(){
		SqlSession session = getSqlSeeeion();
		List<Board> resultList = new BoardDao().selectBoardList(session);
		session.close();
		return resultList;
	}
}
