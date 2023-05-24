package com.ssafy.trip.dto.request;

import com.ssafy.trip.exception.InvalidBoardRequestException;
import com.ssafy.trip.exception.MaliciousAccessException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@NoArgsConstructor
public class BoardCreateRequestDto {

    private String userId;
    private String content;
    private String subject;

    public BoardCreateRequestDto(String userId, String content, String subject) {
        setUserId(userId);
        setContent(content);
        setSubject(subject);
    }

    public void setUserId(String userId) { //악의적인 형태. Malicious로 exception 처리
        if(userId==null || userId.trim().length()==0) throw new MaliciousAccessException();
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
}
