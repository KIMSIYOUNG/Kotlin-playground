package application

import domain.Car
import domain.Cars
import domain.MoveStrategy

class RacingCarRequest(cars: List<String>, moveStrategy: String, val round: Int) {
    val cars: Cars = Cars.create(cars)
    val moveStrategy: MoveStrategy = MoveStrategy.valueOf(moveStrategy)

}