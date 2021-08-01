package lotto.domain

class Lotto(val numbers: Set<LottoNumber>) {
    init {
        require(numbers.size == 6) { "한 로또는, 6개의 서로 다른 숫자를 포함하고 있습니다" }
    }

    fun compare(others: Lotto): Int {
        return (numbers intersect others.numbers).size
    }

    fun contains(number: LottoNumber): Boolean {
        return number in numbers
    }

    companion object Factory {
        fun auto(): Lotto {
            val lotto = mutableSetOf<LottoNumber>()
            while (lotto.size != 6) {
                lotto.add(LottoNumber.random())
            }
            return Lotto(lotto)
        }

        fun manual(lottoNumberInput: String, delimiter: String): Lotto {
            val lottoNumbers = lottoNumberInput.split(delimiter)
                .mapTo(linkedSetOf()) { LottoNumber.manual(it.trim().toInt()) }

            require(lottoNumbers.size == 6) { "로또는 6개의 수로 이루어져있습니다." }

            return Lotto(lottoNumbers)
        }

        fun manual(numbers: List<Int>): Lotto {
            return Lotto(numbers.mapTo(linkedSetOf()) { LottoNumber.manual(it) })
        }
    }
}