package com.ssafy.trip.service;

import com.ssafy.trip.dao.trip.MemberDAO;
import com.ssafy.trip.dao.secure.MemberSecDAO;
import com.ssafy.trip.domain.member.Member;
import com.ssafy.trip.domain.member.MemberSecure;
import com.ssafy.trip.util.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {

    private MemberDAO memberDAO;
    private MemberSecDAO memberSecDAO;

    @Autowired
    public MemberService(MemberDAO memberDAO, MemberSecDAO memberSecDAO) {
        this.memberDAO = memberDAO;
        this.memberSecDAO = memberSecDAO;
    }

    public void regist(Member member, String pwd) {
        System.out.println("hh");
         // salt 처리
        String salt = DataUtil.getSalt();
        String encPw = DataUtil.getEncrypt(pwd,salt);
        System.out.println(salt + " " + encPw);
        member.setUserPwd(encPw); // salt 작업 후 비밀번호까지 넣어준 다음에
        System.out.println("encPw member에 삽입");
        try {
            memberDAO.regist(member); // 비번 넣어주고
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("memberDAO 일 끝");
        // memberSecure 객체 생성
        // 다중 DB 분리작업 필요
        System.out.println("memberSecure 차례");
        MemberSecure memberSecure = new MemberSecure(member.getUserId(),salt);
        System.out.println(memberSecure.getUserId() + "memberSecure 생성 완료");
        memberSecDAO.regist(memberSecure);
        System.out.println("memberSecure 삽입 완료");

    }

    public boolean duplicateId(String id) {

        String duplicate = memberDAO.duplicateId(id);

        if (duplicate == null) {
            return false;
        }
        else {
            return true;
        }
    }
    public boolean duplicateName(String name) {

        String duplicate = memberDAO.duplicateName(name);

        if (duplicate == null) {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean duplicateEmail(String email) {

        String duplicate = memberDAO.duplicateEmail(email);

        if (duplicate == null) {
            return false;
        }
        else {
            return true;
        }

    }
}
