package lotto.application

class LottoCreateRequest(val amount: Int, val manualCount: Int, val manualLottoNumbers: List<String>) {
    val autoLottoCount: Int
        get() {
            return (amount / 1000) - manualCount
        }

    init {
        require(amount >= 0 && amount % 1000 == 0) { "금액은 0이상의 양수여야 하며, 1000원단위만 가능합니다. (거스름돈을 못 주는 프로그램입니다ㅋㅅㅋ)" }
        require(manualCount == manualLottoNumbers.size) { "수동 로또의 개수와 입력한 로또의 갯수가 다릅니다.수동 로또 갯수 : ${manualCount}입력한 로또 갯수 : ${manualLottoNumbers.size}" }
        require((amount / 1000) >= manualCount) { "총 ${amount / 1000} 장을 구매하셨는데, 수동로또로 입력한 갯수는 ${manualCount}입니다." }
    }

}