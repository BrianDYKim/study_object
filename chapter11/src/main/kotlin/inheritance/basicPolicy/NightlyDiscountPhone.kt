package inheritance.basicPolicy

import common.Call
import common.Money
import inheritance.Phone
import java.time.Duration

/**
 * @author Doyeop Kim
 * @since 2023/11/03
 */
open class NightlyDiscountPhone(
    open val nightlyAmount: Money,
    open val regularAmount: Money,
    open val seconds: Duration,
) : Phone() {
    companion object {
        const val LATE_NIGHT_HOUR = 22
    }

    override fun calculateCallFee(call: Call): Money {
        return when (call.from.hour >= LATE_NIGHT_HOUR) {
            true -> nightlyAmount.times((call.duration.seconds / seconds.seconds).toDouble())
            false -> regularAmount.times((call.duration.seconds / seconds.seconds).toDouble())
        }
    }
}