package inheritance.basicPolicy

import common.Call
import common.Money
import inheritance.Phone
import java.time.Duration

/**
 * @author Doyeop Kim
 * @since 2023/11/03
 */
open class RegularPhone(
    open val amountMoney: Money,
    open val seconds: Duration,
) : Phone() {
    override fun calculateCallFee(call: Call): Money {
        return amountMoney.times((call.duration.seconds / seconds.seconds).toDouble())
    }
}