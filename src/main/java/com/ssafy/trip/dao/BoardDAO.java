package com.ssafy.trip.dao;

import com.ssafy.trip.dto.request.BoardCreateRequestDto;
import com.ssafy.trip.dto.request.BoardUpdateRequestDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BoardDAO {
    void createBoard(BoardCreateRequestDto createBoardRequestDto);
    void updateBoard(BoardUpdateRequestDto updateBoardRequestDto);
}
