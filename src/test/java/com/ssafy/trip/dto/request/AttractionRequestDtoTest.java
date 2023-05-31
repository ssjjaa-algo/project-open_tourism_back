package com.ssafy.trip.dto.request;

import com.ssafy.trip.exception.InvalidAttractionAttributeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class AttractionRequestDtoTest {

    @CsvSource(value = {"-1:1:1", "1:-1:1", "1:1:-1"}, delimiter = ':')
    @ParameterizedTest
    @DisplayName("잘못된 입력이 들어오면 InvalidAttractionAttributeException을 반환한다.")
    public void invalidInput(int sido, int gugun, int type) {
        //given

        //when //then
        assertThatThrownBy(() -> new AttractionRequestDto(sido, gugun, type))
                .isInstanceOf(InvalidAttractionAttributeException.class);
    }

    @Test
    @DisplayName("적절한 입력시 객체를 생성")
    public void validInput() {
        //given
        int sido = 1,gugun=2,type=3;

        //when
        AttractionRequestDto attractionRequestDto = new AttractionRequestDto(sido, gugun, type);

        // then
        assertThat(attractionRequestDto.getSidoCode()).isEqualTo(sido);
        assertThat(attractionRequestDto.getGugunCode()).isEqualTo(gugun);
        assertThat(attractionRequestDto.getContentTypeId()).isEqualTo(type);
    }
}