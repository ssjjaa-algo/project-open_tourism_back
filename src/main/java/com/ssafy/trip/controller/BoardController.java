package com.ssafy.trip.controller;

import com.ssafy.trip.dto.request.CreateBoardRequestDto;
import com.ssafy.trip.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/board")
@RestController
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    /**
     * 현재 고민인 부분.
     * id값도 그냥 클라에서 쿠키로 보낸다음 토큰에 저장된 id값과 비교해야하는 건지..
     */
    @PostMapping("/insert")
    public ResponseEntity<Void> createBoard(@RequestBody CreateBoardRequestDto createBoardRequestDto) {
        boardService.createBoard(createBoardRequestDto);

        return ResponseEntity.ok().build();
    }

}
