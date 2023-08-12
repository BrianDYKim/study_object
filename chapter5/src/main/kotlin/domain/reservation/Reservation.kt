package domain.reservation

import common.Money
import domain.customer.Customer
import domain.screening.Screening

/**
 * @author Doyeop Kim
 * @since 2023/08/12
 */
class Reservation(
    val customer: Customer,
    val screening: Screening,
    val fee: Money,
    val audienceCount: Int
) {
}