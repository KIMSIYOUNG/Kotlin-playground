package lotto.domain

enum class Ranking(
    val description: String,
    private val matchCount: Int,
    private val isMatchBonusNumber: Boolean?,
    private val reward: Long,
) {

    FIRST("1등", 6, null, 2_000_000_000L),
    SECOND("2등", 5, true, 100_000_000L),
    THIRD("3등", 5, false, 1_000_000L),
    FOURTH("4등", 4, null, 100_000L),
    FIFTH("5등", 3, null, 1_000L);

    fun isMatchBonusNumber(other: Boolean): Boolean {
        return this.isMatchBonusNumber?.equals(other) ?: true
    }

    fun multiplyReward(times: Int): Long {
        return reward * times
    }

    companion object {
        fun find(matchCount: Int, containsBonusNumber: Boolean): Ranking? {
            return values().firstOrNull {
                it.matchCount == matchCount
                        && it.isMatchBonusNumber(containsBonusNumber)
            }
        }
    }

}
