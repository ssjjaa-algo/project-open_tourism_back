package com.ssafy.trip.domain.attraction;

import com.ssafy.trip.exception.InvalidAttractionAttributeException;
import lombok.Getter;

@Getter
public class Sido {

    private int sidoCode;
    private String sidoName;

    public Sido(int sidoCode, String sidoName) throws InvalidAttractionAttributeException {
        setSidoCode(sidoCode);
        setSidoName(sidoName);
    }

    public void setSidoName(String sidoName) {
        if (sidoName == null || sidoName.length() == 0) return;
        this.sidoName = sidoName;
    }

    private void setSidoCode(int sidoCode) throws InvalidAttractionAttributeException {
        if (sidoCode < 0) {
            throw new InvalidAttractionAttributeException();
        }
        this.sidoCode = sidoCode;
    }

    @Override
    public String toString() {
        return "Sido{" +
                "sidoCode=" + sidoCode +
                ", sidoName='" + sidoName + '\'' +
                '}';
    }
}
