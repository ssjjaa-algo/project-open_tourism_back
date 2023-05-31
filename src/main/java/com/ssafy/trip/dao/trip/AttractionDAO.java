package com.ssafy.trip.dao.trip;

import com.ssafy.trip.domain.attraction.Attraction;
import com.ssafy.trip.domain.attraction.Gugun;
import com.ssafy.trip.domain.attraction.Sido;
import com.ssafy.trip.dto.request.AttractionRequestDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AttractionDAO {
    List<Sido> selectAllSido() throws DataAccessException;
    List<Gugun> selectGugun(int sidoCode);

    List<Attraction> selectAttractions(AttractionRequestDto attractionRequestDto);
}
