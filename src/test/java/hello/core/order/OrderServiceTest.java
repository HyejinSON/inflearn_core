package hello.core.order;

import hello.core.config.AppConfig;
import hello.core.member.entity.Grade;
import hello.core.member.entity.Member;
import hello.core.member.service.MemberServiceImpl;
import hello.core.member.service.serviceImpl.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

//    MemberService memberService = new MemberServiceImpl(memberRepository);
//    OrderService orderService = new OrderServiceImpl(memberRepository, discountPolicy);

    MemberService memberService;
    OrderService orderService;

    /** @Test 실행 전 실행 */
    @BeforeEach
    public void beforEach() {
        AppConfig appConfig = new AppConfig();
        this.memberService = appConfig.memberService();
        this.orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
