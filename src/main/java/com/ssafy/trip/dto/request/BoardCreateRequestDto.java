package com.ssafy.trip.dto.request;

import com.ssafy.trip.exception.InvalidBoardRequestException;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    public void setUserId(String userId) { //앞단에서 검사할 것이므로 따로 유효성 로직을 넣지 않는다.
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
