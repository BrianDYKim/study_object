package domain.screening

import common.Money
import domain.customer.Customer
import domain.movie.ifs.Movie
import domain.reservation.Reservation
import java.time.LocalDateTime

/**
 * @author Doyeop Kim
 * @since 2023/08/12
 */
class Screening(
    val movie: Movie,
    val sequence: Int,
    val whenScreened: LocalDateTime,
) {
    fun reserve(customer: Customer, audienceCount: Int): Reservation {
        TODO()
    }

    private fun calculateFee(audienceCount: Int): Money {
        return movie.calculateMovieFee(this).times(audienceCount)
    }
}