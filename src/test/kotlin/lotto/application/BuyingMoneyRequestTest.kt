package lotto.application

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Money

class BuyingMoneyRequestTest : DescribeSpec({
    describe("생성") {
        context("0보다 작은 수를 넣으면") {
            val number = -1
            it("생성되지 않는다") {
                shouldThrow<IllegalArgumentException> { BuyingMoneyRequest(number) }
            }
        }
        context("1000으로 나눠지지 않는 수를 넣으면") {
            val number = 1001
            it("생성되지 않는다") {
                shouldThrow<IllegalArgumentException> { BuyingMoneyRequest(number) }
            }
        }
        context("정확한 수를 넣으면") {
            val number = 1000
            it("생성된다") {
                BuyingMoneyRequest(number).money shouldBe Money(1000)
            }
        }
    }
})