package com.ssafy.trip.domain.board;

import com.ssafy.trip.exception.InvalidBoardRequestException;

import java.util.Date;

public class Board {
    private int articleno;
    private String userId;
    private String content;
    private String subject;
    private int hit;
    private Date regtime;

    public Board(int articleno, String userId, String content, String subject, int hit, Date regtime) {
        setUserId(userId);
        setContent(content);
        setSubject(subject);
        setArticleno(articleno);
        setRegtime(regtime);
        setHit(hit);
    }

    private void setUserId(String userId) {
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

    private void setRegtime(Date regtime) {
        this.regtime = regtime;
    }
}
