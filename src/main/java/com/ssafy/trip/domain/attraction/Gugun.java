package com.ssafy.trip.domain.attraction;

import com.ssafy.trip.exception.InvalidAttractionAttributeException;
import lombok.Getter;

@Getter
public class Gugun {
    private int gugunCode;
    private String gugunName;
    private int sidoCode;

    public Gugun(int gugunCode, String gugunName, int sidoCode) {
        setSidoCode(sidoCode);
        setGugunCode(gugunCode);
        setGugunName(gugunName);
    }

    private void setGugunCode(int gugunCode) {
        if(gugunCode<1) throw new InvalidAttractionAttributeException();
        this.gugunCode = gugunCode;
    }

    private void setGugunName(String gugunName) {
        if(gugunName==null || gugunName.length()==0) throw new InvalidAttractionAttributeException();
        this.gugunName = gugunName;
    }

    private void setSidoCode(int sidoCode) {
        if(sidoCode<1) throw new InvalidAttractionAttributeException();
        this.sidoCode = sidoCode;
    }
}
