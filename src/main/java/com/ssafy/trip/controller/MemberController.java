package com.ssafy.trip.controller;

import com.ssafy.trip.domain.member.Member;
import com.ssafy.trip.dto.request.MemberDuplicateIdRequestDto;
import com.ssafy.trip.dto.request.MemberRegistRequest;
import com.ssafy.trip.exception.InvalidRegistException;
import com.ssafy.trip.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String> regist(@RequestBody MemberRegistRequest memberRegistRequest) {

        try {
            String userid = memberRegistRequest.getUserId();
            String userpwd = memberRegistRequest.getUserPwd();
            String username = memberRegistRequest.getUserName();
            String useremail = memberRegistRequest.getUserEmail();

            System.out.println(userid + " " + userpwd);
            Member member = new Member(userid, username, useremail, 5, null);
            System.out.println("생성자 완료");
            // 생성자 유효성 검사, pwd는 안집어넣고
            memberService.regist(member, userpwd); // service로 보내 salt값으로 넣으러 간다

            System.out.println(member.getUserId() + " " + member.getUserPwd());
        } catch (Exception e){ // 예외처리 세분화 예정
                // 예외처리 전략
                return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/duplicateId")
    public ResponseEntity<String> duplicateId(@RequestBody MemberDuplicatgeIdRequestDto id) {
        System.out.println("Check duplicateId " + id);
        if(memberService.duplicateId(id)) {
            return new ResponseEntity<>("duplicate",HttpStatus.OK);
        }

        else {
            return new ResponseEntity<>("notDuplicate",HttpStatus.OK);
        }

    }
    @PostMapping("/duplicateName")
    public ResponseEntity<String> duplicateName(@RequestBody String name) {

        if(memberService.duplicateName(name)) {
            return new ResponseEntity<>("duplicate",HttpStatus.OK);
        }

        else {
            return new ResponseEntity<>("notDuplicate",HttpStatus.OK);
        }

    }
    @PostMapping("/duplicateEmail")
    public ResponseEntity<String> duplicateEmail(@RequestBody String email) {

        if(memberService.duplicateEmail(email)) {
            return new ResponseEntity<>("duplicate",HttpStatus.OK);
        }

        else {
            return new ResponseEntity<>("notDuplicate",HttpStatus.OK);
        }

    }

}

/*

Git branch feature/member/
Git checkout feature/member/
Git add.
Git commit -m “메시지”
Git push
(복사)
git push --set-upstream origin feature/member/login

 */