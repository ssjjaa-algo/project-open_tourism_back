package com.ssafy.trip.controller;

import com.ssafy.trip.dto.request.BoardCreateRequestDto;
import com.ssafy.trip.dto.request.BoardUpdateRequestDto;
import com.ssafy.trip.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Void> createBoard(@RequestBody BoardCreateRequestDto createBoardRequestDto) {
        boardService.createBoard(createBoardRequestDto);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/update")
    public ResponseEntity<Void> updateBoard(@RequestBody BoardUpdateRequestDto updateBoardRequestDto) {
        boardService.updateBoard(updateBoardRequestDto);
        return ResponseEntity.ok().build();
    }


}
