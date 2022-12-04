fun main() {
    fun part1(input: List<String>): Int {

        var score = 0

        // A - Rock, B - Paper, C - Scissors
        // X - Rock, Y - Paper, Z - Scissors

        for (item in input) {
            val opponent = item[0].toString()
            val you = item[2].toString()
            when (opponent) {
                "A" -> {
                    when (you) {
                        "Y" -> score += (6 + 2)
                        "Z" -> score += (0 + 3)
                        "X" -> score += (3 + 1)
                    }
                }

                "B" -> {
                    when (you) {
                        "Y" -> score += (3 + 2)
                        "Z" -> score += (6 + 3)
                        "X" -> score += (0 + 1)
                    }
                }

                "C" -> {
                    when (you) {
                        "Y" -> score += (0 + 2)
                        "Z" -> score += (3 + 3)
                        "X" -> score += (6 + 1)
                    }
                }
            }

        }
        return score
    }

    fun part2(input: List<String>): Int {
        var score = 0

        // A - Rock, B - Paper, C - Scissors
        // X - Lose, Y - Draw, Z - Win
        // 1 - Rock, 2 - Paper, 3 - Scissors

        for (item in input) {
            val opponent = item[0].toString()
            val result = item[2].toString()
            when (opponent) {
                "A" -> {
                    when (result) {
                        "Y" -> score += (3 + 1)
                        "Z" -> score += (6 + 2)
                        "X" -> score += (0 + 3)
                    }
                }

                "B" -> {
                    when (result) {
                        "Y" -> score += (3 + 2)
                        "Z" -> score += (6 + 3)
                        "X" -> score += (0 + 1)
                    }
                }

                "C" -> {
                    when (result) {
                        "Y" -> score += (3 + 3)
                        "Z" -> score += (6 + 1)
                        "X" -> score += (0 + 2)
                    }
                }
            }

        }
        return score
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}

