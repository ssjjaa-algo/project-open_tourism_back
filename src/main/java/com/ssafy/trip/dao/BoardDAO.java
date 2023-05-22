package com.ssafy.trip.dao;

import com.ssafy.trip.dto.request.CreateBoardRequestDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BoardDAO {

    void createBoard(CreateBoardRequestDto createBoardRequestDto);
}
