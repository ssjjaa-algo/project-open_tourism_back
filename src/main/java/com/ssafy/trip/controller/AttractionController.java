package com.ssafy.trip.controller;

import com.ssafy.trip.domain.attraction.Sido;
import com.ssafy.trip.service.AttractionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/attraction")
public class AttractionController {

    private AttractionService attractionService;

    public AttractionController(AttractionService attractionService) {
        this.attractionService = attractionService;
    }

    @GetMapping("/sido")
    public ResponseEntity<List<Sido>> sido() {
        return ResponseEntity.ok()
                .body(attractionService.selectAllSido());
    }
}
