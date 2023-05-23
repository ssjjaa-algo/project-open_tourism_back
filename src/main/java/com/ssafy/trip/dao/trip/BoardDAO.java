package com.ssafy.trip.dao.trip;

import com.ssafy.trip.domain.board.Board;
import com.ssafy.trip.dto.request.BoardCreateRequestDto;
import com.ssafy.trip.dto.request.BoardDeleteRequestDto;
import com.ssafy.trip.dto.request.BoardUpdateRequestDto;
import com.ssafy.trip.dto.response.BoardDetailInfoResponseDto;
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
    int deleteBoard(@Param("articleno") int articleno) throws DataAccessException;
    List<Board> getSimpleInfoBoardList() throws DataAccessException;
    Board getBoardDetailInfo(@Param("articleno")int articleno) throws DataAccessException;
}
