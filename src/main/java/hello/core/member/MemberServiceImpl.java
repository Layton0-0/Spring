package hello.core.member;

// 구현체가 하나일 경우에는 맨 뒤에 Impl을 붙이는게 관례
public class MemberServiceImpl implements MemberService{

    // ctrl + shift + enter로 자동완성 하면 ;까지 자동완성 됨.
    // 다형성(부품 갈아끼우기)
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
