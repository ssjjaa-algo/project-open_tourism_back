package com.ssafy.trip.service;

import com.ssafy.trip.dao.BoardDAO;
import com.ssafy.trip.dto.request.CreateBoardRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BoardService {

    private final BoardDAO boardDAO;

    public BoardService(BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }

    public void createBoard(CreateBoardRequestDto createBoardRequestDto) {
        boardDAO.createBoard(createBoardRequestDto);
    }
}
