package domain.reservation

import domain.customer.Customer
import domain.screening.Screening
import utils.Money

/**
 * @author Brian
 * @since 2023/07/04
 */
class Reservation(
    private val customer: Customer,
    private val screening: Screening,
    private val fee: Money,
    private val audienceCount: Int,
) {
}