package com.ssafy.trip.dao;

import com.ssafy.trip.domain.member.MemberSecure;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MemberSecDAO {
    MemberSecure insertSalt() throws DataAccessException;
    String getSalt() throws DataAccessException;
}
