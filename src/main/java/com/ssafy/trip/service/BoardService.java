package com.ssafy.trip.service;

import com.ssafy.trip.dao.BoardDAO;
import com.ssafy.trip.dto.request.BoardCreateRequestDto;
import com.ssafy.trip.dto.request.BoardDeleteRequestDto;
import com.ssafy.trip.dto.request.BoardUpdateRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BoardService {

    private final BoardDAO boardDAO;

    public BoardService(BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }

    public void createBoard(BoardCreateRequestDto createBoardRequestDto) {
        boardDAO.createBoard(createBoardRequestDto);
    }

    public void updateBoard(BoardUpdateRequestDto updateBoardRequestDto) {
        boardDAO.updateBoard(updateBoardRequestDto);
    }

    public int deleteBoard(BoardDeleteRequestDto boardDeleteRequestDto) {
        return boardDAO.deleteBoard(boardDeleteRequestDto);
    }
}
