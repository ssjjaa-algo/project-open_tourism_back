package com.ssafy.trip.dto.request;

import com.ssafy.trip.exception.InvalidAttractionAttributeException;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AttractionRequestDto {
    private int sidoCode;
    private int gugunCode;
    private int contentTypeId;

    public AttractionRequestDto(int sidoCode, int gugunCode, int contentTypeId) {
        setSidoCode(sidoCode);
        setGugunCode(gugunCode);
        setContentTypeId(contentTypeId);
    }

    public void setSidoCode(int sidoCode) {
        if(sidoCode<0) throw new InvalidAttractionAttributeException();
        this.sidoCode = sidoCode;
    }

    public void setGugunCode(int gugunCode) {
        if(gugunCode<0) throw new InvalidAttractionAttributeException();
        this.gugunCode = gugunCode;
    }

    public void setContentTypeId(int contentTypeId) {
        if(contentTypeId<0) throw new InvalidAttractionAttributeException();
        this.contentTypeId = contentTypeId;
    }

    @Override
    public String toString() {
        return "AttractionRequestDto{" +
                "sidoCode=" + sidoCode +
                ", gugunCode=" + gugunCode +
                ", contentTypeId=" + contentTypeId +
                '}';
    }
}
