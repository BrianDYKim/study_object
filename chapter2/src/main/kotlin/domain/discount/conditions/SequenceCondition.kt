package domain.discount.conditions

import domain.screening.Screening
import domain.discount.conditions.ifs.DiscountCondition

/**
 * @author Brian
 * @since 2023/07/04
 */
class SequenceCondition(
    private val sequence: Int,
) : DiscountCondition {
    // 순번 조건을 만족하는지 여부를 반환하는 메소드
    override fun isSatisfiedBy(screening: Screening): Boolean {
        return screening.isSequence(sequence)
    }
}