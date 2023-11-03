package common

import java.time.Duration
import java.time.LocalDateTime

/**
 * @author Doyeop Kim
 * @since 2023/11/03
 */
data class Call(
    val from: LocalDateTime,
    val to: LocalDateTime,
    val duration: Duration,
)