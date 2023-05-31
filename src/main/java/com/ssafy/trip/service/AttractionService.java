package com.ssafy.trip.service;


import com.ssafy.trip.dao.AttractionDAO;
import com.ssafy.trip.domain.attraction.Sido;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttractionService {

    AttractionDAO attractionDAO;

    public AttractionService(AttractionDAO attractionDAO) {
        this.attractionDAO = attractionDAO;
    }

    public List<Sido> selectAllSido() {
         return attractionDAO.selectAllSido();
     }
}
