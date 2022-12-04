fun main() {
    fun part1(input: List<String>): Int {
        var counter = 0
        for (assignments in input)
        {
            val assignment1Lower = assignments.split(",")[0].split("-")[0].toInt()
            val assignment1Upper = assignments.split(",")[0].split("-")[1].toInt()
            val assignment2Lower = assignments.split(",")[1].split("-")[0].toInt()
            val assignment2Upper = assignments.split(",")[1].split("-")[1].toInt()

            if((assignment1Lower in assignment2Lower..assignment2Upper
                && assignment1Upper in assignment2Lower..assignment2Upper)
                || (assignment2Lower in assignment1Lower..assignment1Upper
                        && assignment2Upper in assignment1Lower..assignment1Upper))
            {
                counter++
            }
        }
        return counter
    }

    fun part2(input: List<String>): Int {
        var counter = 0
        for (assignments in input)
        {
            val assignment1Lower = assignments.split(",")[0].split("-")[0].toInt()
            val assignment1Upper = assignments.split(",")[0].split("-")[1].toInt()
            val assignment2Lower = assignments.split(",")[1].split("-")[0].toInt()
            val assignment2Upper = assignments.split(",")[1].split("-")[1].toInt()

            if((assignment1Lower in assignment2Lower..assignment2Upper
                        || assignment1Upper in assignment2Lower..assignment2Upper)
                || (assignment2Lower in assignment1Lower..assignment1Upper
                        || assignment2Upper in assignment1Lower..assignment1Upper))
            {
                counter++
            }
        }
        return counter
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}