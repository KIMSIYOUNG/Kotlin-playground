package domain

import java.util.*

private val random = Random()
private const val CRITERIA = 4

interface NumberStrategy {
    val number: Int
}

enum class MoveStrategy(val description: String): NumberStrategy {
    RANDOM("랜덤하게 가거나, 혹은 가지 않는 전략") {
        override val number: Int
            get() = random.nextInt()
    },
    STAND_STILL("항상 움직이지 않는 전략") {
        override val number: Int
            get() = 4
    },
    ALWAYS_GO("항상 움직이는 전략") {
        override val number: Int
            get() = 5
    };

    fun isMove(): Boolean {
        return number > CRITERIA
    }
}