package lotto.application.dto

import lotto.domain.Lotto
import lotto.domain.WinningValue

class GameResultRequest(
    val buyingAmount: Int,
    val targets: List<Lotto>,
    private val winningNumbers: List<Int>,
    private val bonusNumber: Int,
) {

    val winningValue: WinningValue
        get() {
            return WinningValue(winningNumbers, bonusNumber)
        }

}