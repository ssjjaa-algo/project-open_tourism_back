package com.ssafy.trip.dao.trip;

import com.ssafy.trip.domain.member.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;

@Mapper
@Repository
public interface MemberDAO {

    void regist(Member member) throws DataAccessException;

    String duplicateId(String id) throws DataAccessException;

    String duplicateName(String name) throws DataAccessException;

    String duplicateEmail(String email) throws DataAccessException;
}
