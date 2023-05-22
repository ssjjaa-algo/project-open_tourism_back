package com.ssafy.trip.dao.trip;

import com.ssafy.trip.dto.request.BoardCreateRequestDto;
import com.ssafy.trip.dto.request.BoardDeleteRequestDto;
import com.ssafy.trip.dto.request.BoardUpdateRequestDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BoardDAO {
    void createBoard(BoardCreateRequestDto createBoardRequestDto);
    int updateBoard(BoardUpdateRequestDto updateBoardRequestDto);
    int deleteBoard(BoardDeleteRequestDto boardDeleteRequestDto);
}
