package com.ssafy.trip.domain.attraction;

import com.ssafy.trip.exception.InvalidAttractionAttributeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class SidoTest {

    @CsvSource(value = {"-1,제주", "1,", "1, "})
    @ParameterizedTest
    @DisplayName("잘못된 입력이 들어오면 InvalidAttractionAttributeException을 반환한다.")
    public void invalidSidoInput(int sidoCode, String sidoName) {
        //given
        //when //then
        assertThatThrownBy(() -> new Sido(sidoCode, sidoName))
                .isInstanceOf(InvalidAttractionAttributeException.class);
    }

    @Test
    @DisplayName("적절한 입력시 객체를 생성")
    public void validSidoInput() {
        //given
        int sidoCode = 1;
        String sidoName="제주";

        //when
        Sido sido = new Sido(sidoCode, sidoName);

        // then
        assertThat(sido.getSidoCode()).isEqualTo(sidoCode);
        assertThat(sido.getSidoName()).isEqualTo(sidoName);
    }
}