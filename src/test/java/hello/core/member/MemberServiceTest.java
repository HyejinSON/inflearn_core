package hello.core.member;

import hello.core.config.AppConfig;
import hello.core.member.entity.Grade;
import hello.core.member.entity.Member;
import hello.core.member.service.MemberServiceImpl;
import hello.core.member.service.serviceImpl.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    //    MemberService memberService = new MemberServiceImpl(memberRepository);
    MemberService memberService;

    /** @Test 실행 전 실행 */
    @BeforeEach
    public void beforEach() {
        AppConfig appConfig = new AppConfig();
        this.memberService = appConfig.memberService();
    }

    @Test
    void join() {
        Member member = new Member(1L, "memberA", Grade.VIP);

        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
