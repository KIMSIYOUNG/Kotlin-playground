package lotto.presentation

import lotto.domain.GameResult
import lotto.domain.Lotto
import lotto.domain.LottoNumber

object OutputView {
    fun printWelcome() {
        print(
            """
        안녕하세요. 로또 게임에 오신 것을 환영합니다. 
    """.trimIndent()
        )
    }

    fun printLottos(lottos: List<Lotto>) {
        println()
        println("구매한 티켓은 아래와 같습니다.")
        println("===================================")

        lottos.forEachIndexed { index, lotto ->
            println("${index + 1}번째 티켓 번호: [${lotto.spread(", ")}]")
        }
    }

    fun printResult(gameResult: GameResult) {
        println("당첨 결과를 공개하겠습니다ㅋㄷㅋㄷ")

        gameResult.results.forEach { (key, value) -> println("${key.description} : ${value}개")}

        println("수익률은 ${gameResult.profit}입니다. 또 이용해지건")
    }
}

private fun Lotto.spread(delimiter: CharSequence): String {
    return numbers.map(LottoNumber::number)
        .joinToString(separator = delimiter)
}
