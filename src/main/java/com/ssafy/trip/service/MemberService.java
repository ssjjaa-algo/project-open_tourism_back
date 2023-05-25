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
@Transactional("jesTransactionManager")
public class MemberService {

    private MemberDAO memberDAO;
    private MemberSecDAO memberSecDAO;

    @Autowired
    public MemberService(MemberDAO memberDAO, MemberSecDAO memberSecDAO) {
        this.memberDAO = memberDAO;
        this.memberSecDAO = memberSecDAO;
    }

    @Transactional
    public void regist(Member member, String pwd) {
        String salt = DataUtil.getSalt();
        String encPw = DataUtil.getEncrypt(pwd,salt);
        member.setUserPwd(encPw); // salt 작업 후 비밀번호까지 넣어준 다음에
        try {
            memberDAO.regist(member); // 비번 넣어주고
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        MemberSecure memberSecure = new MemberSecure(member.getUserId(),salt);
        memberSecDAO.regist(memberSecure);

    }

    public boolean duplicateId(String userId) {

        String duplicate = memberDAO.duplicateId(userId);

        if (duplicate == null) {
            return false; // 중복이 아님
        }

        return true; // 중복임

    }
    public boolean duplicateName(String userName) {

        String duplicate = memberDAO.duplicateName(userName);

        System.out.println(duplicate);
        if (duplicate == null) {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean duplicateEmail(String userEmail) {

        String duplicate = memberDAO.duplicateEmail(userEmail);

        if (duplicate == null) {
            return false;
        }
        else {
            return true;
        }
    }

    public Member login(String userId, String userPwd) {

        String salt = memberSecDAO.getSalt(userId);
        if (salt == null) return null;

        String encPw = DataUtil.getEncrypt(userPwd,salt);

        System.out.println(userId + " " + encPw);

        return memberDAO.login(userId,encPw); // 해당 pw를 가진 member 찾으러 가지
    }

    public void modifyInfo(String userId, String userPwd) {
        String salt = DataUtil.getSalt();
        String encPw = DataUtil.getEncrypt(userPwd,salt);

        Member member = memberDAO.findById(userId);
        System.out.println("modifyInfo Service 에서 반환" + member.getUserId());
        System.out.println("member 이전 비밀번호 = " + member.getUserPwd());
        member.setUserPwd(encPw); //
        System.out.println("member 이후 비밀번호 = " + member.getUserPwd());
        try {
            memberDAO.update(member.getUserId(),encPw); // 비번 넣어주고
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("현재 저장되있는 salt 확인 : " + memberSecDAO.getSalt(member.getUserId()));
        memberSecDAO.update(member.getUserId(),salt);
        System.out.println("이후 저장되있는 salt 확인 : " + memberSecDAO.getSalt(member.getUserId()));

    }
}
