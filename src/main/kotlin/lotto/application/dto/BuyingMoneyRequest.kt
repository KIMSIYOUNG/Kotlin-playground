package lotto.application.dto

class BuyingMoneyRequest(val money: Long) {

    init {
        require(money >= 0 && money % 1000 == 0L) { "금액은 0이상의 양수여야 하며, 1000원단위만 가능합니다. (거스름돈을 못 주는 프로그램입니다ㅋㅅㅋ)" }
    }
}