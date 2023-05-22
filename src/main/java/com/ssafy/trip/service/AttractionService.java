package com.ssafy.trip.service;


import com.ssafy.trip.dao.AttractionDAO;
import com.ssafy.trip.domain.attraction.Attraction;
import com.ssafy.trip.domain.attraction.Gugun;
import com.ssafy.trip.domain.attraction.Sido;
import com.ssafy.trip.dto.request.AttractionRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AttractionService {

    AttractionDAO attractionDAO;

    public AttractionService(AttractionDAO attractionDAO) {
        this.attractionDAO = attractionDAO;
    }

    public List<Sido> selectAllSido() {
         return attractionDAO.selectAllSido();
     }

    public List<Gugun> selectGugun(int sidoCode) {
        return attractionDAO.selectGugun(sidoCode);
    }

    public List<Attraction> selectAttractions(AttractionRequestDto attractionRequestDto) {
        return attractionDAO.selectAttractions(attractionRequestDto);
    }
}
