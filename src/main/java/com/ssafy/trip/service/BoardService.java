package com.ssafy.trip.service;

import com.ssafy.trip.dao.trip.BoardDAO;
import com.ssafy.trip.domain.board.Board;
import com.ssafy.trip.dto.request.BoardCreateRequestDto;
import com.ssafy.trip.dto.request.BoardDeleteRequestDto;
import com.ssafy.trip.dto.request.BoardUpdateRequestDto;
import com.ssafy.trip.dto.response.BoardDetailInfoResponseDto;
import com.ssafy.trip.dto.response.BoardSimpleInfoResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(value = "jesTransactionManager")
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

    public int deleteBoard(int articleno) {
        return boardDAO.deleteBoard(articleno);
    }

    public List<BoardSimpleInfoResponseDto> getSimpleInfoBoardList() {
        List<Board> boardList = boardDAO.getSimpleInfoBoardList();
        return createBoardResponseList(boardList);
    }

    private List<BoardSimpleInfoResponseDto> createBoardResponseList(List<Board> boardList) {
        List<BoardSimpleInfoResponseDto> boardSimpleInfoResponseDtoList
                = new ArrayList<>();
        for (Board board : boardList) {
            boardSimpleInfoResponseDtoList.add(BoardSimpleInfoResponseDto.of(board));
        }
        return boardSimpleInfoResponseDtoList;
    }

    public BoardDetailInfoResponseDto selectBoard(int articleno) {
        return BoardDetailInfoResponseDto.of(boardDAO.getBoardDetailInfo(articleno));
    }
}
