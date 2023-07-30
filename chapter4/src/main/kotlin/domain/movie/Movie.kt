package domain.movie

import domain.discount.condition.DiscountCondition
import domain.discount.condition.type.DiscountConditionType
import domain.movie.type.MovieType
import utils.Money
import java.time.Duration
import java.time.LocalDateTime

/**
 * @author Doyeop Kim
 * @since 2023/07/30
 */
class Movie(
    val title: String,
    val runningTime: Duration,
    val fee: Money,
    val discountConditions: List<DiscountCondition>,
    val movieType: MovieType,
    val discountAmount: Money,
    val discountPercent: Double,
) {
    // 할인 가능 여부를 반환하는 메소드
    fun isDiscountable(whenScreened: LocalDateTime, sequence: Int): Boolean {
        return this.discountConditions.map {
            when (it.type) {
                DiscountConditionType.PERIOD -> with(whenScreened) {
                    it.isDiscountable(this.dayOfWeek, this.toLocalTime())
                }

                else -> it.isDiscountable(sequence)
            }
        }
            .contains(true)
    }

    // 총량 할인 정책에 의해서 할인된 금액을 반환하는 메소드
    fun calculateAmountDiscountedFee(): Money {
        if (this.movieType != MovieType.AMOUNT_DISCOUNT) {
            throw IllegalArgumentException()
        }

        return this.fee.minus(this.discountAmount)
    }

    // 비율 할인 정책에 의해서 할인된 금액을 반환하는 메소드
    fun calculatePercentDiscountedFee(): Money {
        if (this.movieType != MovieType.PERCENT_DISCOUNT) {
            throw IllegalArgumentException()
        }

        return this.fee.minus(this.fee.times(this.discountPercent))
    }

    fun calculateNoneDiscountedFee(): Money {
        if (this.movieType != MovieType.NONE_DISCOUNT) {
            throw IllegalArgumentException()
        }

        return this.fee
    }
}