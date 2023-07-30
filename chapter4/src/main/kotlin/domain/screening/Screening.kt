package domain.screening

import domain.movie.Movie
import domain.movie.type.MovieType
import utils.Money
import java.time.LocalDateTime

/**
 * @author Doyeop Kim
 * @since 2023/07/30
 */
class Screening(
    val movie: Movie,
    val sequence: Int,
    val whenScreened: LocalDateTime,
) {
    // 상영 비용을 계산하는 메서드
    fun calculateFee(audienceCount: Int): Money {
        if (movie.isDiscountable(whenScreened, sequence)) {
            return when(movie.movieType) {
                MovieType.AMOUNT_DISCOUNT -> movie.calculateAmountDiscountedFee().times(audienceCount)
                MovieType.PERCENT_DISCOUNT -> movie.calculatePercentDiscountedFee().times(audienceCount)
                else -> movie.calculateNoneDiscountedFee().times(audienceCount)
            }
        }

        return movie.calculateNoneDiscountedFee().times(audienceCount)
    }
}