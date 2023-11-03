package inheritance

import common.Call
import common.Money

/**
 * @author Doyeop Kim
 * @since 2023/11/03
 */
abstract class Phone {
    private val calls = mutableListOf<Call>()

    open fun calculateFee(): Money {
        return calls
            .map { calculateCallFee(it) }
            .reduce { acc, currentMoney -> acc.plus(currentMoney.amount) }
    }

    abstract fun calculateCallFee(call: Call): Money

    protected open fun afterCalculated(fee: Money): Money {
        return fee
    }
}