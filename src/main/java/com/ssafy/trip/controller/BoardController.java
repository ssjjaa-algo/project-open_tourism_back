package com.ssafy.trip.controller;

import com.ssafy.trip.dto.request.BoardCreateRequestDto;
import com.ssafy.trip.dto.request.BoardDeleteRequestDto;
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
    public ResponseEntity<String> createBoard(@RequestBody BoardCreateRequestDto createBoardRequestDto) {
        System.out.println("hi");

        boardService.createBoard(createBoardRequestDto);
        return ResponseEntity.ok("OK");
    }

    @PatchMapping("/update")
    public ResponseEntity<String> updateBoard(@RequestBody BoardUpdateRequestDto updateBoardRequestDto) {
        boardService.updateBoard(updateBoardRequestDto);
        return ResponseEntity.ok("OK");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteBoard(@RequestBody BoardDeleteRequestDto boardDeleteRequestDto ) {
        int result = boardService.deleteBoard(boardDeleteRequestDto);
        if(result==0) {
            return ResponseEntity.ok("삭제 실패");
        }
        return ResponseEntity.ok("삭제 성공");
    }
}
