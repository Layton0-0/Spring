package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    // 단위 테스트: 순수 자바코드로만 테스트 하는 것
    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "memberYJ", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemAAA", 10000);
        // 할인 가격이 1000원인가? -> 맞으면 초록창, 틀리면 빨간창과 에러메시지
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
