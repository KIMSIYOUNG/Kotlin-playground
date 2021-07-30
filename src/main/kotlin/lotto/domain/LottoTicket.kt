package lotto.domain

class LottoTicket(val count: Long) {

    constructor(money: Money) : this(money.divide(1000).amount)

    init {
        require(count >= 0) { "티켓은 0이상의 정수여야 합니다." }
    }
}