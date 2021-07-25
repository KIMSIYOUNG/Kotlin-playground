package domain

import domain.MoveStrategy.ALWAYS_GO
import domain.MoveStrategy.STAND_STILL
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.tuple
import org.junit.jupiter.api.Test

@Suppress("NonAsciiCharacters")
internal class CarTest {

    @Test
    fun `자동차의 생성위치는 0으로 고정되고, 아이디는 존재하지 않는다(디비에 저장될 때 생성된다)`() {
        /* given */
        val car = Car("시영")

        /* when, then */
        assertThat(car.position).isEqualTo(0)
        assertThat(car.id).isNull()
    }

    @Test
    fun `5이상의 값이 나오는 전략은 항상 자동차가 움직인다`() {
        /* given */
        val car = Car("시영")

        /* when */
        car.move(ALWAYS_GO, 1)

        /* then */
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `4이하의 값이 나오는 전략은 항상 자동차가 움직이지 않는다`() {
        /* given */
        val car = Car("시영")

        /* when */
        car.move(STAND_STILL, 1)

        /* then */
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `차가 움직이는 것과 관계없이 항상 매 라운드의 기록이 저장된다`() {
        /* given */
        val car = Car("시영")

        /* when */
        car.move(STAND_STILL, 1)
        val roundOne = car.position

        car.move(STAND_STILL, 2)
        val roundTwo = car.position

        /* then */
        assertThat(car.snapshots).hasSize(2)
            .extracting(CarMoveSnapshot::name, CarMoveSnapshot::round, CarMoveSnapshot::position)
            .containsExactly(
                tuple(car.name, 1, roundOne),
                tuple(car.name, 2, roundTwo)
            )
    }
}