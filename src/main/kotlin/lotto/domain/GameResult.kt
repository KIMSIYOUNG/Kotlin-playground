package lotto.domain

class GameResult(
    targets: List<Lotto>,
    private val winningValue: WinningValue,
    private val buyingAmount: Int,
) {

    val results: Map<Ranking, Int> = targets
        .mapNotNull { it.convert(winningValue) }
        .sorted()
        .groupingBy { it }
        .eachCount()

    val profit: Double
        get() {
            val totalReward = results.map { (key, value) -> key.multiplyReward(value) }
                .sum()

            return totalReward.toDouble() / buyingAmount
        }
}

private fun Lotto.convert(winningValue: WinningValue): Ranking? {
    val matchCount = compare(winningValue.winningLotto)
    val containsBonusNumber = contains(winningValue.bonusNumber)

    return Ranking.find(matchCount, containsBonusNumber)
}