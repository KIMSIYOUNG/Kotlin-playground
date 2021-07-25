package cars.domain

import cars.domain.MoveStrategy.ALWAYS_GO
import cars.domain.MoveStrategy.STAND_STILL
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.tuple
import org.junit.jupiter.api.Test

@Suppress("NonAsciiCharacters")
internal class CarsTest {

    @Test
    fun `차가 없는 경우에 빈 값을 반환하고 경기를 정상적으로 진행한다`() {
        /* given */
        val userNames = emptyList<String>()

        /* when */
        val cars = Cars.create(userNames)
        cars.move(10, ALWAYS_GO)

        /* then */
        assertThat(cars.cars).isNotNull
        assertThat(cars.cars).isEmpty()
        assertThat(cars.getGroupedSnapshots()).isNotNull
        assertThat(cars.getGroupedSnapshots()).isEmpty()
        assertThat(cars.findWinners()).isEmpty()
    }

    @Test
    fun `이름이 담긴 리스트를 통해 자동차를 생성할 수 있다`() {
        /* given */
        val userNames = listOf("시영", "범준", "운장")

        /* when */
        val cars = Cars.create(userNames)

        /* then */
        assertThat(cars.cars).hasSize(3)
            .extracting(Car::name)
            .containsExactly(tuple("시영"), tuple("범준"), tuple("운장"))
    }

    @Test
    fun `입력한 경기수만큼 이동 전략에 따라 각 자동차를 이동시킨다`() {
        /* given */
        val cars = Cars.create(listOf("시영", "범준", "운장"))

        /* when */
        cars.move(10, ALWAYS_GO)

        /* then */
        assertThat(cars.cars).hasSize(3)
            .extracting(Car::name, Car::position)
            .containsExactly(
                tuple("시영", 10),
                tuple("범준", 10),
                tuple("운장", 10)
            )

    }

    @Test
    fun `매 라운드별 결과는 스냅샷으로 관리되고 확인할 수 있다`() {
        /* given */
        val cars = Cars.create(listOf("시영", "범준", "운장"))

        /* when */
        cars.move(1, ALWAYS_GO)
        val groupedSnapshots = cars.getGroupedSnapshots()


        /* then */
        assertThat(groupedSnapshots).hasSize(1)
        assertThat(groupedSnapshots[0])
            .extracting(CarMoveSnapshot::name, CarMoveSnapshot::position, CarMoveSnapshot::round)
            .containsExactly(
                tuple("시영", 1, 0),
                tuple("범준", 1, 0),
                tuple("운장", 1, 0),
            )
    }

    @Test
    fun `가장 멀리간 차와 위치가 동일한 사람이 복수라면 모두가 승자가 된다`() {
        /* given */
        val cars = Cars.create(listOf("시영", "범준", "운장"))
        cars.move(10, ALWAYS_GO)

        /* when */
        val findWinners = cars.findWinners()

        /* then */
        assertThat(findWinners).hasSize(3)
            .extracting(Car::name)
            .contains(tuple("시영"), tuple("범준"), tuple("운장"))
    }

    @Test
    fun `위치를 통해 승자를 찾을 수 있다`() {
        /* given */
        val car1 = Car("시영")
        val car2 = Car("운장")

        car1.move(ALWAYS_GO, 1)
        car2.move(STAND_STILL, 1)

        val cars = Cars(listOf(car1, car2))

        /* when */
        val winners = cars.findWinners()

        /* then */
        assertThat(winners).hasSize(1)
            .extracting(Car::name, Car::position)
            .containsExactly(tuple(car1.name, car1.position))
    }
}