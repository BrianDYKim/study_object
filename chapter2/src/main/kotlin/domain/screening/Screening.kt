package domain.screening

import domain.movie.Movie
import domain.reservation.Reservation
import utils.Money
import java.time.LocalDateTime

/**
 * @author Brian
 * @since 2023/07/04
 */
class Screening(
    private val movie: Movie,
    private val sequence: Int,
    private val whenScreened: LocalDateTime,
) {
    fun getStartTime(): LocalDateTime = this.whenScreened

    fun isSequence(sequence: Int): Boolean = this.sequence == sequence

    fun getMovieFee(): Money = movie.fee

    /** 예약을 처리하는 메소드
     * @param customer 예매자에 대한 정보
     * @param audienceCount 인원 수
     * @return reservation
     */
    fun reserve(customer: Customer, audienceCount: Int): Reservation {
        return Reservation(customer, this, calculateFee(audienceCount), audienceCount)
    }

    private fun calculateFee(audienceCount: Int): Money {
        // 영화 가격을 계산하여 인원수만큼 곱해서 반환한다
        return movie.calculateMovieFee(this).times(audienceCount)
    }
}