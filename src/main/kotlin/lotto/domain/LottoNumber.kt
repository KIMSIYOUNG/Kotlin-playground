package lotto.domain

import kotlin.random.Random

data class LottoNumber(val number: Int) {

    init {
        require(number in (1..45)) { "로또 숫자는 1~45까지 입니다." }
    }

    companion object Factory {
        private val numbers: MutableMap<Int, Int> = mutableMapOf()

        init {
            for (index in 1..45) {
                numbers[index] = index
            }
        }

        fun random(): LottoNumber {
            return LottoNumber(numbers[Random.nextInt(1, 45)]!!)
        }
    }

}

