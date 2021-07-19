import application.RacingCarService
import domain.MemoryCarRepository
import presentation.RacingCarRequestDto

private val racingCarService: RacingCarService = RacingCarService(MemoryCarRepository())

fun main() {

    val userInputRequestDto = RacingCarRequestDto(
        names = getUserInputNames(),
        moveStrategy = getUserInputMoveStrategy(),
        round = getUserInputPlayCount()
    )

    val ids = racingCarService.moves(userInputRequestDto.toApplicationDto())
    val snapshots = racingCarService.findSnapshots(ids)
    val winners = racingCarService.findWinners(ids)

    printSnapShots(snapshots)
    printWinners(winners)

}