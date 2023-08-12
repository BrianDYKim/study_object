package domain.discount.condition

import domain.discount.condition.ifs.DiscountCondition
import domain.screening.Screening
import java.time.DayOfWeek
import java.time.LocalTime

/**
 * @author Doyeop Kim
 * @since 2023/08/12
 */
class PeriodCondition(
    val dayOfWeek: DayOfWeek,
    val startTime: LocalTime,
    val endTime: LocalTime,
): DiscountCondition {
    override fun isSatisfiedBy(screening: Screening): Boolean {
        return dayOfWeek == screening.whenScreened.dayOfWeek &&
                startTime <= screening.whenScreened.toLocalTime() &&
                endTime >= screening.whenScreened.toLocalTime()
    }
}