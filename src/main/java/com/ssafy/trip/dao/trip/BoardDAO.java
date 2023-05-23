package com.ssafy.trip.dao.trip;

import com.ssafy.trip.domain.board.Board;
import com.ssafy.trip.dto.request.BoardCreateRequestDto;
import com.ssafy.trip.dto.request.BoardDeleteRequestDto;
import com.ssafy.trip.dto.request.BoardUpdateRequestDto;
import com.ssafy.trip.dto.response.BoardDetailInfoResponseDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BoardDAO {
    void createBoard(BoardCreateRequestDto createBoardRequestDto);
    int updateBoard(BoardUpdateRequestDto updateBoardRequestDto);
    int deleteBoard(BoardDeleteRequestDto boardDeleteRequestDto);
    List<Board> getSimpleInfoBoardList();
    Board getBoardDetailInfo(@Param("articleno")int articleno);
}
