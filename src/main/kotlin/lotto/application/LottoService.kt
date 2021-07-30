package lotto.application

import lotto.domain.Lottos

class LottoService {

    fun createLottos(request: LottoCreateRequest): Lottos {

        return Lottos.create(
            autoTicketCount = request.autoLottoCount,
            manualLottoNumbers = request.manualLottoNumbers
        )
    }
}