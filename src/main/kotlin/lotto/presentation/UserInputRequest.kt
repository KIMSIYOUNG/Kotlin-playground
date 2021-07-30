package lotto.presentation

class UserInputRequest {
    val amount: Int

    constructor(userInputAmount: Int?) {
        this.amount = userInputAmount?: throw IllegalArgumentException()
    }


}