package com.ssafy.trip.domain.board;

import com.ssafy.trip.exception.InvalidBoardRequestException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;

@Getter
@NoArgsConstructor
public class Board {
    private int articleno;
    private String userId;
    private String content;
    private String subject;
    private int hit;
    private String regtime;

    public Board(int articleno, String userId, String content, String subject, int hit, String regtime) {
        setUserId(userId);
        setContent(content);
        setSubject(subject);
        setArticleno(articleno);
        setRegtime(regtime);
        setHit(hit);
    }

    private void setUserId(String userId) {
        if (userId == null ||userId.trim().length() == 0) throw new InvalidBoardRequestException("잘못된 요청입니다.");
        this.userId = userId;
    }

    public void setContent(String content) {
        if (content == null || content.trim().length() == 0) throw new InvalidBoardRequestException("내용을 작성해주세요");
        this.content = content;
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

    private void setRegtime(String regtime) {
        this.regtime = regtime;
    }
}
