package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired
    MemberRepository  memberRepository;
    @Test
    public void join() throws Exception{
        Member member = new Member();
        member.setName("kim");

        Long saveId = memberService.join(member);


        Assertions.assertEquals(member, memberRepository.findOne(saveId));
    }

    @Test
    public void check() throws Exception{
        Member  member1 = new Member();
        member1.setName("kim");

        Member  member2 = new Member();
        member2.setName("kim");

        memberService.join(member1);
        try {
            memberService.join(member2);
        }catch ( IllegalStateException e ){
            return;
        }

        Assertions.fail( "예외발생" );
    }

}