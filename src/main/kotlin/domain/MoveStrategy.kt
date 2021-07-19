package domain

import java.util.*

private val random = Random()
private const val CRITERIA = 4

enum class MoveStrategy(val description: String, private val function: () -> Int) {
    RANDOM("랜덤하게 가거나, 혹은 가지 않는 전략", { random.nextInt() }),
    STAND_STILL("항상 움직이지 않는 전략", { 4 }),
    ALWAYS_GO("항상 움직이는 전략", { 5 });

    fun isMove(): Boolean {
        return function.invoke() > CRITERIA
    }
}