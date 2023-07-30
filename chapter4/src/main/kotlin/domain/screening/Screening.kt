package domain.screening

import domain.movie.Movie
import java.time.LocalDateTime

/**
 * @author Doyeop Kim
 * @since 2023/07/30
 */
class Screening(
    val movie: Movie,
    val sequence: Int,
    val whenScreened: LocalDateTime,
) {
}