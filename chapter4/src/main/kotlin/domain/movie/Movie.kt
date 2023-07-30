package domain.movie

import domain.discount.condition.DiscountCondition
import domain.movie.type.MovieType
import utils.Money
import java.time.Duration

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
}