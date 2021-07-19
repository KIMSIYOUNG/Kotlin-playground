package domain

interface CarRepository {

    fun save(car: Car): String

    fun findById(id:String): Car?

    fun findAllById(ids: Iterable<String>): List<Car>

    fun update(id: String, position: Int)

    fun saveAll(cars: Iterable<Car>): List<String>
}