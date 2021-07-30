package lotto.presentation

import lotto.application.LottoCreateRequest
import lotto.application.LottoService

private val lottoService: LottoService = LottoService()

fun main() {
    OutputView.printWelcome()

    val amount = InputView.amount()
    val manualLottoCount = InputView.manualLottoCount()
    val manualLottoNumbers = InputView.manualLottoNumbers(manualLottoCount)

    val lottos = lottoService.createLottos(LottoCreateRequest(amount, manualLottoCount, manualLottoNumbers))

    OutputView.printLottos(lottos)


//    val winningNumbers = userInputWinningNumbers()?:throw IllegalArgumentException()
//    val bonusNumber = userInputBonusNumber()?:throw IllegalArgumentException()


    // 당첨번호 입력

    // 보너스 번호 입력

    // 통계 출력
}
