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

    String duplicateId(String userId) throws DataAccessException;

    String duplicateName(String userName) throws DataAccessException;

    String duplicateEmail(String userEmail) throws DataAccessException;

    Member login(String userId, String userPwd) throws DataAccessException;
}
