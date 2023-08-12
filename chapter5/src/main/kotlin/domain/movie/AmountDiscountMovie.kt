package domain.movie

import common.Money
import domain.discount.condition.ifs.DiscountCondition
import domain.movie.ifs.Movie
import java.time.Duration

/**
 * @author Doyeop Kim
 * @since 2023/08/12
 */
class AmountDiscountMovie(
    override val title: String,
    override val runningTime: Duration,
    override val fee: Money,
    override val discountConditions: List<DiscountCondition>,
    val discountAmount: Money
) : Movie(title, runningTime, fee, discountConditions) {

    override fun calculateDiscountAmount(): Money {
        return discountAmount
    }
}