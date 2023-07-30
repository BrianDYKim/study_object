package domain.discount.condition

import domain.discount.condition.type.DiscountConditionType
import java.time.DayOfWeek
import java.time.LocalTime

/**
 * @author Doyeop Kim
 * @since 2023/07/30
 */
class DiscountCondition(
    val type: DiscountConditionType,
    val sequence: Int,
    val dayOfWeek: DayOfWeek,
    val startTime: LocalTime,
    val endTime: LocalTime,
) {
    fun isDiscountable(dayOfWeek: DayOfWeek, time: LocalTime): Boolean {
        if (this.type != DiscountConditionType.PERIOD) {
            throw IllegalArgumentException()
        }

        return this.dayOfWeek == dayOfWeek
                && this.startTime <= time
                && this.endTime >= time
    }

    fun isDiscountable(sequence: Int): Boolean {
        if (this.type != DiscountConditionType.SEQUENCE) {
            throw IllegalArgumentException();
        }

        return this.sequence == sequence
    }
}