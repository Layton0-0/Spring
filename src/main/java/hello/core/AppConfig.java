package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 설정 정보에 configuration을 붙임.
// spring이 이 악물고 싱글톤 보장해 줌.
// AppConfig@CGLIB라는 새로운 AppConfig를 상속하는 클래스를 만들어서 싱글톤을 보장함.
// Configuration 어노테이션을 빼면 싱글톤 컨테이너가 적용이 안됨.
@Configuration
public class AppConfig {
    // 어떤 구현체를 쓸지 한눈에 볼 수 있음.

    // Bean을 붙이면 Spring Container에 등록이 됨.
    @Bean
    public MemberService memberService(){
        // MemberService가 생성될 때 MemberServiceImpl에 MemoryMemberRepository를 담아서 생성한다.
        // DIP 지킴.
        return new MemberServiceImpl(memberRepository());
    }

    // MemberRepository에 대한 구현체로
    @Bean
    public MemberRepository memberRepository() {
        // MemoryMemberRepository를 사용하겠다.
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        // 이 반환된 객체를 스프링 컨테이너에 등록한다. 등록된 객체를 스프링 빈이라고 한다.
        return new RateDiscountPolicy();
    }



}

