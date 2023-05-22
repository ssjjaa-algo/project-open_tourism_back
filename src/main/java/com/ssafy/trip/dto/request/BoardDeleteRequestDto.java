package com.ssafy.trip.dto.request;

import com.ssafy.trip.exception.InvalidBoardRequestException;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardDeleteRequestDto {
    private String userId;
    private int articleno;
    public void setUserId(String userId) { //앞에서 검사하기에 유효성 검증로직 현재는 필요 없음.
        this.userId = userId;
    }
    public void setArticleno(int articleno) {
        if(articleno<0) throw new InvalidBoardRequestException("장난치지 마세요.");
        this.articleno = articleno;
    }
}
