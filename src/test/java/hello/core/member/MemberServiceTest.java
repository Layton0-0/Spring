package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService = new MemberServiceImpl();

    @Test
    void join(){
        //given(주어진 값)
        Member member = new Member(1L, "memberYJ", Grade.VIP);

        //when(~ 할 때)
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then(결과 값)
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
