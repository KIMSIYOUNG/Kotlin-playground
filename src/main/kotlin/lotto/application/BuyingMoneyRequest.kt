package lotto.application

import lotto.domain.LottoTicket
import lotto.domain.Money

class BuyingMoneyRequest(val money: Money) {

    constructor(amount: Int) : this(Money(amount)) {
        require(amount >= 0 && amount % 1000 == 0) { "금액은 0이상의 양수여야 하며, 1000원단위만 가능합니다. (거스름돈을 못 주는 프로그램입니다ㅋㅅㅋ)" }
    }

    fun toLottoTicket(): LottoTicket {
        return LottoTicket(money)
    }
}