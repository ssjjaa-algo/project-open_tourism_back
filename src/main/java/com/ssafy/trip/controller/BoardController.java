package com.ssafy.trip.controller;

import com.ssafy.trip.dto.request.BoardCreateRequestDto;
import com.ssafy.trip.dto.request.BoardDeleteRequestDto;
import com.ssafy.trip.dto.request.BoardUpdateRequestDto;
import com.ssafy.trip.dto.response.BoardDetailInfoResponseDto;
import com.ssafy.trip.dto.response.BoardSimpleInfoResponseDto;
import com.ssafy.trip.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/board")
@RestController
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/detail/{articleno}")
    public ResponseEntity<BoardDetailInfoResponseDto> selectBoard(@PathVariable("articleno") int articleno) {
        return ResponseEntity.ok().body(boardService.selectBoard(articleno));
    }

    @GetMapping("/list")
    public ResponseEntity<List<BoardSimpleInfoResponseDto>> getBoardSimpleInfoList() {
        return ResponseEntity.ok().body(boardService.getSimpleInfoBoardList());
    }

    @PostMapping("/insert")
    public ResponseEntity<String> createBoard(@RequestBody BoardCreateRequestDto createBoardRequestDto) {
        boardService.createBoard(createBoardRequestDto);
        return ResponseEntity.ok("OK");
    }

    @PatchMapping("/update")
    public ResponseEntity<String> updateBoard(@RequestBody BoardUpdateRequestDto updateBoardRequestDto) {
        boardService.updateBoard(updateBoardRequestDto);
        return ResponseEntity.ok("OK");
    }

    @DeleteMapping("/delete/{articleno}")
    public ResponseEntity<String> deleteBoard(@PathVariable("articleno") int articleno) {
        int result = boardService.deleteBoard(articleno);
        if (result == 0) {
            return ResponseEntity.ok("FAIL");
        }
        return ResponseEntity.ok("OK");
    }


}
