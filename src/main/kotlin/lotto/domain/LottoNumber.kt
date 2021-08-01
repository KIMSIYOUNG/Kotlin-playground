package lotto.domain

import kotlin.random.Random

@JvmInline
value class LottoNumber private constructor(val number: Int) {

    init {
        require(number in (1..45)) { "로또 숫자는 1~45까지 입니다." }
    }

    companion object Factory {
        private val numbers: MutableMap<Int, Int> = initialize()

        private fun initialize(): MutableMap<Int, Int> {
            val initMap = mutableMapOf<Int, Int>()
            for (index in 1..45) {
                initMap[index] = index
            }
            return initMap
        }

        fun random(): LottoNumber {
            return LottoNumber(numbers[Random.nextInt(1, 45)]!!)
        }

        fun manual(number: Int): LottoNumber {
            return LottoNumber(number)
        }
    }

}

