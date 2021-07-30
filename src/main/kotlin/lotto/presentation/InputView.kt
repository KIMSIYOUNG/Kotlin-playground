package lotto.presentation

object InputView {
    fun amount(): Int {
        println("구입하고자 하는 금액을 입력해주세요.")

        return readLine()?.toInt()?:throw IllegalArgumentException("금액은 필수입니다.")
    }

    fun manualLottoCount():Int {
        println("수동으로 구매하고자 하는 로또의 개수를 입력해주세요.")

        return readLine()?.toInt()?:throw IllegalArgumentException("수동으로 구매하려는 개수는 필수입니다. 없으면 0을 적어주세요.")
    }

    fun manualLottoNumbers(manualLottoCount: Int):List<String> {
        println("수동 로또 ${manualLottoCount}개를 입력해주세요.")
        val userInputLottos = mutableListOf<String>()
        repeat(manualLottoCount) { index ->
            print("${index + 1}번째 번호(, 기준으로 숫자를 구분합니다) : ")
            userInputLottos.add(lottoNumbers())
        }

        return userInputLottos
    }

    private fun lottoNumbers(): String {
        return readLine() ?:throw IllegalArgumentException("수동 로또의 번호를 입력해주세요.")
    }

}
