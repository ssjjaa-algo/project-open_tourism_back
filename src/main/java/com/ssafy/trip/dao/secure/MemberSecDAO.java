package com.ssafy.trip.dao.secure;

import com.ssafy.trip.domain.member.MemberSecure;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MemberSecDAO {
    void regist(MemberSecure memberSecure) throws DataAccessException;
    String getSalt(String userId) throws DataAccessException;


    void update(String userId, String salt) throws DataAccessException;
}
