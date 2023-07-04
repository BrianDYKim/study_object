package domain.discount.conditions

import domain.screening.Screening
import domain.discount.conditions.ifs.DiscountCondition
import java.time.DayOfWeek
import java.time.LocalTime

/**
 * @author Brian
 * @since 2023/07/04
 */
class PeriodCondition(
    private val dayOfWeek: DayOfWeek,
    private val startTime: LocalTime,
    private val endTime: LocalTime,
) : DiscountCondition {
    // 기간 조건을 만족하는지 여부를 반환하는 메소드
    override fun isSatisfiedBy(screening: Screening): Boolean {
        return screening.getStartTime().dayOfWeek == dayOfWeek &&
                startTime <= screening.getStartTime().toLocalTime() &&
                endTime >= screening.getStartTime().toLocalTime()
    }
}