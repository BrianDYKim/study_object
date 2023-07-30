package domain.reservation

import domain.customer.Customer
import domain.discount.condition.type.DiscountConditionType
import domain.movie.Movie
import domain.movie.type.MovieType
import domain.screening.Screening
import utils.Money

/**
 * 데이터 중심의 설계를 하게되면 응집도, 결합도에서 문제가 많이 발생한다
 * @author Doyeop Kim
 * @since 2023/07/30
 */
class ReservationAgency {
    // 예약을 처리하는 메소드
    fun reserve(screening: Screening, customer: Customer, audienceCount: Int): Reservation {
        val movie = screening.movie

        val discountable = movie.discountConditions.map {
            when (it.type) {
                DiscountConditionType.PERIOD -> screening.whenScreened.dayOfWeek == it.dayOfWeek
                        && it.startTime <= screening.whenScreened.toLocalTime()
                        && it.endTime >= screening.whenScreened.toLocalTime()

                else -> it.sequence == screening.sequence
            }
        }
            .contains(true)

        // 비용 계산
        val fee = when(discountable) {
            true -> {
                val discountAmount = calculateDiscountAmount(movie)
                movie.fee.minus(discountAmount)
            }
            false -> movie.fee
        }

        return Reservation(customer, screening, fee, audienceCount)
    }

    // discountAmount를 계산하는 메소드
    private fun calculateDiscountAmount(movie: Movie): Money {
        return when(movie.movieType) {
            MovieType.AMOUNT_DISCOUNT -> movie.discountAmount
            MovieType.PERCENT_DISCOUNT -> movie.fee.times(movie.discountPercent)
            MovieType.NONE_DISCOUNT -> Money.ZERO
        }
    }
}