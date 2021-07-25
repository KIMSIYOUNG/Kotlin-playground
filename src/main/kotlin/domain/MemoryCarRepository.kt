package domain

import java.util.*
import kotlin.reflect.KMutableProperty
import kotlin.reflect.jvm.isAccessible

class MemoryCarRepository : CarRepository {
    private var cars = mutableMapOf<String, Car>()

    override fun save(car: Car): String {
        val uuid = UUID.randomUUID().toString()
        cars[uuid] = car

        car.reflectValue(mapOf("id" to uuid))

        return car.id
    }

    override fun saveAll(cars: Iterable<Car>): List<String> {
        return cars.map { save(it) }
    }

    override fun findById(id: String): Car? {
        return cars[id]
    }

    override fun findAllById(ids: Iterable<String>): List<Car> {
        return cars.filter { it.key in ids }
            .values
            .toList()
    }

    override fun update(id: String, position: Int) {
        val findCar = cars[id] ?: throw IllegalArgumentException("해당하는 ID를 가진 자동차가 없습니다, $id")

        val newCar = Car(findCar.name).apply {
            reflectValue(mapOf("id" to findCar.id, "position" to position))
        }

        cars[id] = newCar
    }

    private fun Car.reflectValue(fieldNameToValue: Map<String, Any>) {
        for ((fieldName, value) in fieldNameToValue) {
            val property = Car::class.members.find { it.name == fieldName }
                ?: throw IllegalArgumentException("${fieldName}에 해당하는 필드는 없습니다.")

            property.isAccessible = true
            if (property is KMutableProperty<*>) {
                property.setter.call(this, value)
            }
        }
    }
}
