package com.ssafy.trip.service;

import com.ssafy.trip.dao.MemberDAO;
import com.ssafy.trip.dao.MemberSecDAO;
import com.ssafy.trip.domain.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MemberService {

    private MemberDAO memberDAO;
    private MemberSecDAO memberSecDAO;

    public MemberService(MemberDAO memberDAO, MemberSecDAO memberSecDAO) {
        this.memberDAO = memberDAO;
        this.memberSecDAO = memberSecDAO;
    }

    public void regist(Member member) {

        String salt = UUID.randomUUID().toString();



    }
}
