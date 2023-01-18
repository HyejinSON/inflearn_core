package hello.core;

import hello.core.config.AppConfig;
import hello.core.member.entity.Grade;
import hello.core.member.entity.Member;
import hello.core.member.service.MemberServiceImpl;
import hello.core.member.service.serviceImpl.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        MemberService memberService = new MemberServiceImpl();


        /** AppConfig에서 생성자주입을 선언했으므로 MemberService를 직접 참조하는 것이 아니라 AppConfig를 통해 참조한다. */
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        /** config에 bean으로 등록 후 사용 */
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);  //AppConfig에 설정되어 있는 Bean 정보를 세팅해 줌
        MemberService memberService = ac.getBean(MemberService.class);  //Bean에 설정되어 있는 것 중 가져 올 메서드명

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());

    }
}
