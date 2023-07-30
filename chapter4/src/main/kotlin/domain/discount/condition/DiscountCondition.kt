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
}