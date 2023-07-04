package domain.discount.policies

import utils.Money
import domain.screening.Screening
import domain.discount.conditions.ifs.DiscountCondition
import domain.discount.policies.ifs.DiscountPolicy

/**
 * @author Brian
 * @since 2023/07/04
 */
class AmountDiscountPolicy(
    private val discountAmount: Money,
    private val conditions: List<DiscountCondition>
) : DiscountPolicy(conditions) {
    override fun getDiscountAmount(screening: Screening): Money {
        return discountAmount
    }
}