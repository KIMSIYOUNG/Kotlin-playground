package lotto.application

import lotto.application.dto.GameResultRequest
import lotto.application.dto.LottoCreateRequest
import lotto.domain.GameResult
import lotto.domain.Lotto
import lotto.domain.LottoFactory

class LottoService {

    fun createLottos(request: LottoCreateRequest): List<Lotto> {

        return LottoFactory.create(
            autoTicketCount = request.autoLottoCount,
            manualLottoNumbers = request.manualLottoNumbers
        )
    }

    fun createGameResult(request: GameResultRequest): GameResult {
        return GameResult(request.targets, request.winningValue, request.buyingAmount)
    }
}