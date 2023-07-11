package domain.movie

import domain.screening.Screening
import utils.Money
import domain.discount.policies.ifs.DiscountPolicy
import java.time.Duration

/**
 * @author Brian
 * @since 2023/07/04
 */
class Movie(
    private val title: String,
    private val runningTime: Duration,
    private val fee: Money,
    private val discountPolicy: DiscountPolicy,
) {
    fun getFee(): Money = fee

    fun calculateMovieFee(screening: Screening): Money {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening))
    }
}