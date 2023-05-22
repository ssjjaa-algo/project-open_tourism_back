package com.ssafy.trip.domain.attraction;

import com.ssafy.trip.exception.InvalidAttractionAttributeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class GugunTest {

    @CsvSource(value = {"-1,제주,1", "-1,,1", "1,제주,-1"})
    @ParameterizedTest
    @DisplayName("잘못된 입력이 들어오면 InvalidAttractionAttributeException을 반환한다.")
    public void invalidGugunInput(int gugunCode, String gugunName,int sidoCode) {
        //given
        //when //then
        assertThatThrownBy(() -> new Gugun(gugunCode, gugunName, sidoCode))
                .isInstanceOf(InvalidAttractionAttributeException.class);
    }

    @Test
    @DisplayName("적절한 입력시 객체를 생성")
    public void validGugunInput() {
        //given
        int sidoCode = 1;
        String gugunName="제주";
        int gugunCode = 1;

        //when
        Gugun gugun = new Gugun(gugunCode, gugunName, sidoCode);
        // then
        assertThat(gugun.getSidoCode()).isEqualTo(sidoCode);
        assertThat(gugun.getGugunName()).isEqualTo(gugunName);
        assertThat(gugun.getGugunCode()).isEqualTo(gugunCode);
    }
}