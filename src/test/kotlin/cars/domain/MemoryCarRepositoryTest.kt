package cars.domain

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

@Suppress("NonAsciiCharacters")
internal class MemoryCarRepositoryTest {
    private val carRepository: CarRepository = MemoryCarRepository()

    @Test
    fun `정상적으로 자동차의 값이 저장되고, 저장된 아이디를 반환한다`() {
        /* given */
        val car = Car("시영")
        val id = carRepository.save(car)

        /* when */
        val findCar = carRepository.findById(id)

        /* then */
        assertThat(findCar).isNotNull
        assertThat(findCar!!.id).isEqualTo(car.id)
        assertThat(findCar.name).isEqualTo(car.name)
        assertThat(findCar.position).isEqualTo(car.position)

    }

    @Test
    fun `해당하는 자동차가 없는 경우 예외를 반환한다`() {
        /* when, then */
        assertThatThrownBy { carRepository.update("NOT_EXIST_ID", 0) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `자동차의 위치 상태값을 수정한다`() {
        /* given */
        val car = Car("시영")
        val id = carRepository.save(car)

        /* when */
        carRepository.update(id, 10)
        val updatedCar = carRepository.findById(id)

        /* then */
        assertThat(updatedCar!!.id).isEqualTo(car.id)
        assertThat(updatedCar.name).isEqualTo(car.name)
        assertThat(car.position).isEqualTo(0)
        assertThat(updatedCar.position).isEqualTo(10)
    }

    @Test
    fun `아이디를 통해 자동차들을 조회할 수 있다`() {
        /* given */
        val ids = carRepository.saveAll(
            listOf(
                Car("시영"), Car("운장"), Car("윤서"),
                Car("범준"), Car("태헌"), Car("재주")
            )
        )

        /* when */
        val findCars = carRepository.findAllById(ids)

        /* then */
        assertThat(findCars).hasSize(6)
            .extracting(Car::name, Car::position, Car::id)
            .containsExactly(
                tuple("시영", 0, ids[0]), tuple("운장", 0, ids[1]), tuple("윤서", 0, ids[2]),
                tuple("범준", 0, ids[3]), tuple("태헌", 0, ids[4]), tuple("재주", 0, ids[5])
            )
    }
}