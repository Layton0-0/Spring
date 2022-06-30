package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
//    MemberService memberService = new MemberServiceImpl();

    MemberService memberService;

    // Test가 실행되기 전 무조건 실행되는 어노테이션
    // 테스트가 2번 있으면 2번 실행됨.
    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

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
