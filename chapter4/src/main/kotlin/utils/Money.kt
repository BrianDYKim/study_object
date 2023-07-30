package utils

import java.math.BigDecimal

/**
 * 금액에 관련된 다양한 계산을 구현하는 클래스
 * @author Brian
 * @since 2023/07/04
 */
class Money(
    private val amount: BigDecimal,
) {
    companion object {
        fun wons(amount: Long): Money {
            return Money(BigDecimal.valueOf(amount))
        }

        fun wons(amount: Double): Money {
            return Money(BigDecimal.valueOf(amount))
        }

        val ZERO = wons(0)
    }

    // 주어진 파라미터만큼 값을 더하여 Money를 반환하는 메소드
    fun plus(amount: Money): Money {
        return Money(this.amount.add(amount.amount))
    }

    // 주어진 파라미터만큼 값을 제하여 Money를 반환하는 메소드
    fun minus(amount: Money): Money {
        return Money(this.amount.minus(amount.amount))
    }

    // 주어진 파라미터만큼 가격을 곱하여 반환하는 메소드
    fun times(percent: Double): Money {
        return Money(
            this.amount.multiply(
                BigDecimal.valueOf(percent)
            )
        )
    }

    fun times(audienceCount: Int): Money {
        return Money(
            this.amount.multiply(
                BigDecimal.valueOf(audienceCount.toLong())
            )
        )
    }

    fun isLessThan(other: Money): Boolean {
        return amount < other.amount
    }

    fun isGreaterThanOrEqual(other: Money): Boolean {
        return amount >= other.amount
    }
}