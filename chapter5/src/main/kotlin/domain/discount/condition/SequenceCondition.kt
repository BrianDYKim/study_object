package domain.discount.condition

import domain.discount.condition.ifs.DiscountCondition
import domain.screening.Screening

/**
 * @author Doyeop Kim
 * @since 2023/08/12
 */
class SequenceCondition(
    val sequence: Int
): DiscountCondition {
    override fun isSatisfiedBy(screening: Screening): Boolean {
        return sequence == screening.sequence
    }
}