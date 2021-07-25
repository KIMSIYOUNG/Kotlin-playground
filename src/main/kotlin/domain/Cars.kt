package domain

class Cars(val cars: List<Car>) {

    companion object CarFactory {
        fun create(carNames: List<String>): Cars {
            return Cars(carNames.map(::Car))
        }
    }

    fun move(raceCount: Int, moveStrategy: MoveStrategy) {
        repeat(raceCount) { moveEachCars(it, moveStrategy) }
    }

    fun findWinners(): List<Car> {
        val max = cars.maxOfOrNull(Car::position) ?: 0

        return cars.filter { car -> car.position == max }
    }

    fun getGroupedSnapshots(): Map<Int, List<CarMoveSnapshot>> {
        return cars.flatMap { car -> car.snapshots }
            .groupBy { it.round }
    }

    private fun moveEachCars(round: Int, moveStrategy: MoveStrategy) {
        cars.forEach { car -> car.move(moveStrategy, round) }
    }
}