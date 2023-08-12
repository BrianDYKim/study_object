package domain.movie.ifs

import common.Money
import domain.discount.condition.ifs.DiscountCondition
import domain.screening.Screening
import java.time.Duration

/**
 * @author Doyeop Kim
 * @since 2023/08/12
 */
abstract class Movie(
    open val title: String,
    open val runningTime: Duration,
    open val fee: Money,
    open val discountConditions: List<DiscountCondition>
) {
    fun calculateMovieFee(screening: Screening): Money {
        return when (isDiscountable(screening)) {
            true -> fee.minus(calculateDiscountAmount())
            false -> fee
        }
    }

    // 할인 가능 여부를 판단하는 메소드
    private fun isDiscountable(screening: Screening): Boolean {
        return discountConditions.any { it.isSatisfiedBy(screening) }
    }

    // 할인 요금을 반환하는 메소드
    abstract fun calculateDiscountAmount(): Money
}