package domain.discount.condition.ifs

import domain.screening.Screening

/**
 * @author Doyeop Kim
 * @since 2023/08/12
 */
interface DiscountCondition {
    fun isSatisfiedBy(screening: Screening): Boolean
}