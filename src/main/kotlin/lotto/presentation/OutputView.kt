package lotto.presentation

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.Lottos

object OutputView {
    fun printWelcome() {
        print(
            """
        안녕하세요. 로또 게임에 오신 것을 환영합니다. 
    """.trimIndent()
        )
    }

    fun printLottos(lottos: Lottos) {
        println()
        println("구매한 티켓은 아래와 같습니다.")
        println("===================================")

        val auto = lottos.lottos[Lottos.LottoType.AUTO] ?: listOf()
        val manual = lottos.lottos[Lottos.LottoType.MANUAL] ?: listOf()

        auto.forEachIndexed { index, lotto ->
            println("자동 로또  ${index + 1}번째 티켓 번호: [${lotto.spread(", ")}]")
        }

        println("===================================")

        manual.forEachIndexed { index, lotto ->
            println("수동 로또  ${index + 1}번째 티켓 번호: [${lotto.spread(", ")}]")
        }
    }
}

private fun Lotto.spread(delimiter: CharSequence): String {
    return numbers.map(LottoNumber::number)
        .joinToString(separator = delimiter)
}
