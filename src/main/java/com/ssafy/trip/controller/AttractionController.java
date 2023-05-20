package com.ssafy.trip.controller;

import com.ssafy.trip.domain.attraction.Attraction;
import com.ssafy.trip.domain.attraction.Gugun;
import com.ssafy.trip.domain.attraction.Sido;
import com.ssafy.trip.dto.request.dto.AttractionRequestDto;
import com.ssafy.trip.service.AttractionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/gugun")
    public ResponseEntity<List<Gugun>> gugun(@RequestParam("sido") int sidoCode) {
        return ResponseEntity.ok()
                .body(attractionService.selectGugun(sidoCode));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Attraction>> attractions(AttractionRequestDto attractionRequestDto) {
        return ResponseEntity.ok().body(attractionService.selectAttractions(attractionRequestDto));
    }
}
