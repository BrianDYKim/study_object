package domain.discount.policies

import domain.discount.policies.ifs.DiscountPolicy
import domain.screening.Screening
import utils.Money

/**
 * 할인을 하나도 하지 않는 정책
 * @author Brian
 * @since 2023/07/04
 */
class NoneDiscountPolicy : DiscountPolicy(listOf()) {
    override fun getDiscountAmount(screening: Screening): Money {
        return Money.ZERO
    }
}