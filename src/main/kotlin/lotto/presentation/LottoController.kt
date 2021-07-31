package lotto.presentation

import lotto.application.LottoService
import lotto.application.dto.GameResultRequest
import lotto.application.dto.LottoCreateRequest

private val lottoService: LottoService = LottoService()

fun main() {
    OutputView.printWelcome()

    val amount = InputView.amount()
    val manualLottoCount = InputView.manualLottoCount()
    val manualLottoNumbers = InputView.manualLottoNumbers(manualLottoCount)
    val lottos = lottoService.createLottos(LottoCreateRequest(amount, manualLottoCount, manualLottoNumbers))
    OutputView.printLottos(lottos)

    val gameResult = lottoService.createGameResult(GameResultRequest(
        buyingAmount = amount,
        targets = lottos,
        winningNumbers = InputView.winningNumbers(),
        bonusNumber = InputView.bonusNumber())
    )
    OutputView.printResult(gameResult)
}

