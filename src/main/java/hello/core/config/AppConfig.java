package hello.core.config;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.repository.MemoryMemberRepository;
import hello.core.member.service.MemberServiceImpl;
import hello.core.member.service.serviceImpl.MemberService;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 생성자 주입
 * 어플리케이션의 실제 동작에 필요한 구현객체를 생성한다.
 */
@Configuration      //구성(설정) 정보
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();  // 금액할인
        return new RateDiscountPolicy();    //비율할인
    }
}
