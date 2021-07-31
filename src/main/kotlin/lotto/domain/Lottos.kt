package lotto.domain

object LottoFactory {
    fun create(
        autoTicketCount: Int,
        manualLottoNumbers: List<String>,
        manualLottoDelimiter: String = ",",
    ): List<Lotto> {

        val lottos = mutableListOf<Lotto>()
        for (index in 0 until autoTicketCount) {
            lottos += Lotto.auto()
        }

        for (value in manualLottoNumbers) {
            lottos += Lotto.manual(value, manualLottoDelimiter)
        }

        return lottos
    }
}
