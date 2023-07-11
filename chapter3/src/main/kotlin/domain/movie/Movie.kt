package domain.movie

import domain.screening.Screening
import utils.Money
import domain.discount.policies.ifs.DiscountPolicy
import java.time.Duration

/**
 * @author Brian
 * @since 2023/07/04
 */
class Movie(
    private val title: String,
    private val runningTime: Duration,
    private val fee: Money,
    private val discountPolicy: DiscountPolicy,
) {
    fun getFee(): Money = fee

    fun calculateMovieFee(screening: Screening): Money {
        // 아래의 방법은 할인에 의한 가격 결정 책임이 movie에 존재하기 때문에 일관성이 없다
//        return discountPolicy?.let {
//            fee.minus(it.calculateDiscountAmount(screening))
//        } ?: fee

        // NoneDiscountPolicy 클래스를 생성하는 경우 위와 같이 예외 케이스를 적용하지 않고도 할인 일관성을 유지 가능하다
        return fee.minus(discountPolicy.calculateDiscountAmount(screening))
    }
}