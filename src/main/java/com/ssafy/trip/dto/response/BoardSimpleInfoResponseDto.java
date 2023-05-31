package com.ssafy.trip.dto.response;

import com.ssafy.trip.domain.board.Board;
import com.ssafy.trip.exception.InvalidBoardRequestException;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@Getter
public class BoardSimpleInfoResponseDto {
    private int articleno;
    private String userId;
    private String subject;
    private int hit;
    private String regtime;

    public BoardSimpleInfoResponseDto(int articleno, String userId, String subject, int hit, String regtime) {
        setUserId(userId);
        setSubject(subject);
        setArticleno(articleno);
        setHit(hit);
        setRegtime(regtime);
    }

    private void setUserId(String userId) {
        this.userId = userId;
    }

    public void setSubject(String subject) {
        if (subject == null || subject.trim().length() == 0) throw new InvalidBoardRequestException("제목을 작성해주세요");
        this.subject = subject;
    }

    private void setArticleno(int articleno) {
        this.articleno = articleno;
    }

    private void setHit(int hit) {
        this.hit = hit;
    }

    public void setRegtime(String regtime) {
        this.regtime = regtime;
    }

    public static BoardSimpleInfoResponseDto of(Board board) {
        return BoardSimpleInfoResponseDto.builder()
                .articleno(board.getArticleno())
                .subject(board.getSubject())
                .hit(board.getHit())
                .regtime(board.getRegtime())
                .userId(board.getUserId())
                .build();
    }
}
