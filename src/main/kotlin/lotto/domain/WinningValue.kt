package lotto.domain

class WinningValue(winningNumbers: List<Int>, bonusNumber: Int) {
    val winningLotto: Lotto = Lotto.manual(winningNumbers)
    val bonusNumber: LottoNumber = LottoNumber.manual(bonusNumber)
}