package presentation

import application.RacingCarRequest

class RacingCarRequestDto(
    private val names: List<String>,
    private val moveStrategy: String,
    private val round: Int
) {

    fun toApplicationDto(): RacingCarRequest {
        return RacingCarRequest(
            cars = names,
            moveStrategy = moveStrategy,
            round = round
        )
    }
}