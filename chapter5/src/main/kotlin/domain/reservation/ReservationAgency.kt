package domain.reservation

import common.Money
import domain.customer.Customer
import domain.movie.AmountDiscountMovie
import domain.movie.NoneDiscountMovie
import domain.movie.PercentDiscountMovie
import domain.movie.ifs.Movie
import domain.screening.Screening

/**
 * @author Doyeop Kim
 * @since 2023/08/12
 */
class ReservationAgency {
    fun reserve(screening: Screening, customer: Customer, audienceCount: Int): Reservation {
        val fee = calculateFee(screening, audienceCount)
        return createReservation(screening, customer, audienceCount, fee)
    }

    private fun calculateFee(screening: Screening, audienceCount: Int): Money {
        return screening.movie.calculateMovieFee(screening)
            .times(audienceCount)
    }

    private fun createReservation(screening: Screening, customer: Customer, audienceCount: Int, fee: Money): Reservation {
        return Reservation(customer, screening, fee, audienceCount)
    }
}