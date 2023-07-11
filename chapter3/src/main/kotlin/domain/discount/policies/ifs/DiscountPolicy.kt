package domain.discount.policies.ifs

import utils.Money
import domain.screening.Screening
import domain.discount.conditions.ifs.DiscountCondition

/**
 * @author Brian
 * @since 2023/07/04
 */
abstract class DiscountPolicy(
    private val conditions: List<DiscountCondition>
) {
    fun calculateDiscountAmount(screening: Screening): Money {
        // 할인 조건들 중에 하나라도 만족하는 경우에는 할인의 양을 계산하고, 아닌 경우에는 null을 할당
        return conditions.firstOrNull() { it.isSatisfiedBy(screening) }
            ?.let { getDiscountAmount(screening) }
            ?: Money.ZERO
    }

    // 할인의 총량을 계산하는 메소드
    protected abstract fun getDiscountAmount(screening: Screening): Money
}