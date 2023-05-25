package com.ssafy.trip.controller;

import com.ssafy.trip.dto.request.BoardCreateRequestDto;
import com.ssafy.trip.dto.request.BoardDeleteRequestDto;
import com.ssafy.trip.dto.request.BoardUpdateRequestDto;
import com.ssafy.trip.dto.response.BoardDetailInfoResponseDto;
import com.ssafy.trip.dto.response.BoardSimpleInfoResponseDto;
import com.ssafy.trip.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/board")
@RestController
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/detail/{articleno}")
    public ResponseEntity<BoardDetailInfoResponseDto> selectBoard(
            @PathVariable("articleno") int articleno,
            HttpServletRequest request
            ) {
        HttpSession session = request.getSession(false);

        return ResponseEntity.ok().body(boardService.selectBoard(articleno,
                (String)session.getAttribute("userId")));
    }

    @GetMapping("/list")
    public ResponseEntity<List<BoardSimpleInfoResponseDto>> getBoardSimpleInfoList() {
        return ResponseEntity.ok().body(boardService.getSimpleInfoBoardList());
    }

    @PostMapping("/insert")
    public ResponseEntity<String> createBoard(@RequestBody BoardCreateRequestDto createBoardRequestDto,
                                                HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        System.out.println(createBoardRequestDto.getUserId());
        createBoardRequestDto.setUserId((String)session.getAttribute("userId"));
        boardService.createBoard(createBoardRequestDto);
        return ResponseEntity.ok("OK");
    }

    @PatchMapping("/update")
    public ResponseEntity<String> updateBoard(@RequestBody BoardUpdateRequestDto updateBoardRequestDto,
                                              HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        updateBoardRequestDto.setUserId((String)session.getAttribute("userId"));
        boardService.updateBoard(updateBoardRequestDto);
        return ResponseEntity.ok("OK");
    }

    @DeleteMapping("/delete/{articleno}")
    public ResponseEntity<String> deleteBoard(@PathVariable("articleno") int articleno, HttpServletRequest request) {
        HttpSession session = request.getSession();
        boardService.deleteBoard(articleno, (String)session.getAttribute("userId"));
        return ResponseEntity.ok("OK");
    }


}
