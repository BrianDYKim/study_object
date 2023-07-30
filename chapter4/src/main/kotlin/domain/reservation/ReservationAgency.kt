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
        val fee = screening.calculateFee(audienceCount)
        return Reservation(customer, screening, fee, audienceCount)
    }
}