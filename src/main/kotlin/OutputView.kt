import domain.Car
import domain.CarMoveSnapshot
import java.lang.StringBuilder

fun printSnapShots(snapshots: Map<Int, List<CarMoveSnapshot>>) {
    println("===============라운드별 경기 결과=================")
    for (snapshot in snapshots) {
        println("============ ${snapshot.key} 경기 =================")
        for (carSnapshot in snapshot.value) {
            println("${carSnapshot.name} : ${carSnapshot.position.spread("-")}")
        }
    }
    println("================================================")
}

fun printWinners(winners: List<Car>) {
    println("축하합니다. 최종 우승자는 ${winners.joinToString(", ") { it.name }} 입니다!")
}

private fun Int.spread(type: String): String {
    val builder = StringBuilder()
    repeat((this)) { builder.append(type) }
    return builder.toString()
}
