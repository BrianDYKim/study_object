package domain.discount.conditions.ifs

import domain.screening.Screening

/**
 * @author Brian
 * @since 2023/07/04
 */
interface DiscountCondition {
    fun isSatisfiedBy(screening: Screening): Boolean
}