package inheritance.taxPolicy

import common.Money
import inheritance.basicPolicy.RegularPhone
import java.time.Duration

/**
 * @author Doyeop Kim
 * @since 2023/11/03
 */
class TaxableRegularPhone(
    override val amountMoney: Money,
    override val seconds: Duration,
    private val taxRate: Double,
) : RegularPhone(amountMoney, seconds) {
    override fun calculateFee(): Money {
        val fee = super.calculateFee()

        return fee.plus(fee.times(taxRate).amount)
    }

    override fun afterCalculated(fee: Money): Money {
        return fee.plus(fee.times(taxRate).amount)
    }
}