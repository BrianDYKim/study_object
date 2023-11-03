package inheritance.taxPolicy

import common.Money
import inheritance.basicPolicy.NightlyDiscountPhone
import java.time.Duration

/**
 * @author Doyeop Kim
 * @since 2023/11/03
 */
class TaxableNightDiscountPhone(
    override val nightlyAmount: Money,
    override val regularAmount: Money,
    override val seconds: Duration,
    private val taxRate: Double,
) : NightlyDiscountPhone(nightlyAmount, regularAmount, seconds) {
    override fun afterCalculated(fee: Money): Money {
        return fee.plus(fee.times(taxRate).amount)
    }
}