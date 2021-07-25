package domain

class Car(val name: String) {
    var id: String? = null
        private set
    var position = 0
        private set
    val snapshots = mutableListOf<CarMoveSnapshot>()

    fun move(moveStrategy: MoveStrategy, round: Int) {
        if (moveStrategy.isMove()) {
            position++
        }

        snapshots += CarMoveSnapshot(
            name = this.name,
            position = this.position,
            round = round
        )
    }
}
