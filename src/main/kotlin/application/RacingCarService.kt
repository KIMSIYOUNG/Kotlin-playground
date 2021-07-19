package application

import domain.*

class RacingCarService(private val carRepository: CarRepository) {

    fun moves(request: RacingCarRequest): List<String> {
        val cars = request.cars

        cars.move(request.round, request.moveStrategy)

        return carRepository.saveAll(cars.cars)
    }

    fun findSnapshots(ids: List<String>): Map<Int, List<CarMoveSnapshot>> {
        val findCars = carRepository.findAllById(ids)

        val cars = Cars(findCars)

        return cars.getGroupedSnapshots()
    }

    fun findWinners(ids: List<String>): List<Car> {
        val findCars = carRepository.findAllById(ids)

        val cars = Cars(findCars)

        return cars.findWinners()
    }

}