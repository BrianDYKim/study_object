package common

/**
 * @author Doyeop Kim
 * @since 2023/11/03
 */
data class Money(val amount: Double) {
    companion object {
        val ZERO = Money(0.0)

        fun of(value: Double) = Money(value)
    }

    fun plus(value: Double): Money {
        return Money(this.amount + value)
    }

    fun times(value: Double): Money {
        return Money(this.amount * value)
    }
}