package domain.reservation

import domain.customer.Customer
import domain.screening.Screening
import utils.Money

/**
 * @author Doyeop Kim
 * @since 2023/07/30
 */
class Reservation(
    val customer: Customer,
    val screening: Screening,
    val fee: Money,
    val audienceCount: Int,
) {
}