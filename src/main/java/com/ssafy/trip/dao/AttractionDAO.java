package com.ssafy.trip.dao;

import com.ssafy.trip.domain.attraction.Sido;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AttractionDAO {
    List<Sido> selectAllSido() throws DataAccessException;
}
