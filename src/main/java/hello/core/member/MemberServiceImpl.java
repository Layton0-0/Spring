package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
// 구현체가 하나일 경우에는 맨 뒤에 Impl을 붙이는게 관례
public class MemberServiceImpl implements MemberService{

    // ctrl + shift + enter로 자동완성 하면 ;까지 자동완성 됨.
    // 다형성(부품 갈아끼우기)
    private final MemberRepository memberRepository;

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

    // MemberServiceImpl이 생성될 때 AppConfig에 의해 MemberRepository가 할당되어서 들어옴.
    // 어떤 Repository가 들어올 지 Impl은 알 수 없음.
    // DI (Dependency Injection, 의존관계 주입)
    @Autowired
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
