package com.ssafy.trip.dto.request;

import com.ssafy.trip.exception.NoBoardContentException;
import com.ssafy.trip.exception.NoBoardSubjectException;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardUpdateRequestDto {
    private int articleno;
    private String userId;
    private String content;
    private String subject;

    public BoardUpdateRequestDto(int articleno, String userId, String content, String subject) {
        setArticleno(articleno);
        setUserId(userId);
        setContent(content);
        setSubject(subject);
    }

    public void setArticleno(int articleno) {
        this.articleno = articleno;
    }

    public void setUserId(String userId) { //앞단에서 검사할 것이므로 따로 유효성 로직을 넣지 않는다.
        this.userId = userId;
    }

    public void setContent(String content) {
        if (content == null || content.trim().length() == 0) throw new NoBoardContentException();
        this.content = content;
    }

    public void setSubject(String subject) {
        if (subject == null || subject.trim().length() == 0) throw new NoBoardSubjectException();
        this.subject = subject;
    }
}
