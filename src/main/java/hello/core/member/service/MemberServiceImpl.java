package hello.core.member.service;

import hello.core.member.entity.Member;
import hello.core.member.repository.MemberRepository;
import hello.core.member.service.serviceImpl.MemberService;

public class MemberServiceImpl implements MemberService {
    /**
     * AppConfig에서 구현 객체(생성자)를 생성하여 여기에서는 생성자 주입을 받아 사용하기 때문에 기능에만 충실하면 됨
     * DI : Dependency Injection 의존성 주입
     */
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
