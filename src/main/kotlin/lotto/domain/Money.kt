package lotto.domain

data class Money(val amount: Long) {
    constructor(amount: Int): this(amount.toLong())

    fun divide(other: Int): Money {
        return Money(amount / other)
    }
}