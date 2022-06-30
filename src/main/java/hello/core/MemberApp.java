package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        // 기존의 DIP 안 지켜지던 방식
//        MemberService memberService = new MemberServiceImpl();
        
        // AppConfig라는 기획자를 불러와 서비스를 할당하는 상황. 의존성 주입
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        // config 해놓은 빈들을 스프링 컨테이너에 다 넣고 알아서 관리해줌.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberYJ", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
