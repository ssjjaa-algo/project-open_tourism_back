package com.ssafy.trip.controller;

import com.ssafy.trip.domain.member.Member;
import com.ssafy.trip.dto.request.MemberRegistRequest;
import com.ssafy.trip.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class MemberController {

    private final MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/regist")
    public ResponseEntity<String> regist(@RequestParam MemberRegistRequest memberRegistRequest) {

        String userid = memberRegistRequest.getUserId();
        String userpwd = memberRegistRequest.getUserPwd();
        String username = memberRegistRequest.getUserName();
        String useremail = memberRegistRequest.getUserEmail();

        Member member = new Member(userid,username,useremail,5, null);
        // 생성자 유효성 검사, pwd는 안집어넣은 상태

        System.out.println(member.toString());

        memberService.regist(member);

        return new ResponseEntity<>("회원가입이 완료되었습니다.", HttpStatus.OK);

    }

}
