package com.ssafy.trip.dao.trip;

import com.ssafy.trip.domain.board.Board;
import com.ssafy.trip.dto.request.BoardCreateRequestDto;
import com.ssafy.trip.dto.request.BoardUpdateRequestDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BoardDAO {
    void createBoard(BoardCreateRequestDto createBoardRequestDto) throws DataAccessException;

    int updateBoard(BoardUpdateRequestDto updateBoardRequestDto) throws DataAccessException;

    int deleteBoard(@Param("articleno") int articleno, @Param("userId")String userId) throws DataAccessException;

    List<Board> getSimpleInfoBoardList() throws DataAccessException;

    Board getBoardDetailInfo(@Param("articleno") int articleno, @Param("userId") String userId) throws DataAccessException;

}
