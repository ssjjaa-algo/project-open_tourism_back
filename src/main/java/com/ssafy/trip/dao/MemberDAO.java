package com.ssafy.trip.dao;

import com.ssafy.trip.domain.member.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
@Mapper
@Repository
public interface MemberDAO {

    Member Regist() throws DataAccessException;
}
