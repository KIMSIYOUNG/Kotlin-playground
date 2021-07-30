package lotto.domain

class Lottos(val lottos: Map<LottoType, List<Lotto>>) {

    enum class LottoType(val description: String) {
        AUTO("자동 로또"), MANUAL("수동 로또")
    }

    companion object Factory {
        fun create(
            autoTicketCount: Int,
            manualLottoNumbers: List<String>,
            manualLottoDelimiter: String = ",",
        ): Lottos {

            val lottos = mutableMapOf<LottoType, MutableList<Lotto>>(
                LottoType.AUTO to mutableListOf(),
                LottoType.MANUAL to mutableListOf()
            )

            for (index in 0 until autoTicketCount) {
                lottos[LottoType.AUTO]!! += Lotto.auto()
            }

            for (value in manualLottoNumbers) {
                lottos[LottoType.MANUAL]!! += Lotto.manual(value, manualLottoDelimiter)
            }

            return Lottos(lottos)
        }
    }
}