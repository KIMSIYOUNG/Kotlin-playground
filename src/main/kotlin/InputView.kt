import domain.MoveStrategy
import java.util.*

private val scanner = Scanner(System.`in`)

fun getUserInputNames(): List<String> {
    println(
        """
        안녕하세요, 자동차 경주 게임에 오신걸 환영합니다.
        사람의 이름으로 자동차 이름이 결정됩니다. 
        함께 하고자 하는 사람들의 이름을 , 를 기준으로 입력해주세요.
    """.trimIndent()
    )

    val scanner = Scanner(System.`in`)

    val userInputNames = scanner.nextLine()
    return userInputNames.split(",").toList()
}

fun getUserInputMoveStrategy(): String {
    println("자동차가 움직이는 전략을 결정할 수 있습니다. 전략과 설명은 아래와 같습니다.")
    MoveStrategy.values()
        .forEach { value -> println("""전략 이름 : ${value.name} 전략 설명 : ${value.description}""") }

    return scanner.nextLine();
}

fun getUserInputPlayCount(): Int {
    println("몇 경기를 할지 입력해주세요. 숫자로만 입력해주세요.")
    return scanner.nextInt()
}