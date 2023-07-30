package domain.movie.type

/**
 * @author Doyeop Kim
 * @since 2023/07/30
 */
enum class MovieType {
    AMOUNT_DISCOUNT, // 금액 할인 정책
    PERCENT_DISCOUNT, // 비율 할인 정책
    NONE_DISCOUNT, // 할인 정책 미적용
}