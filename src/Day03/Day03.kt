fun main() {
    fun part1(input: List<String>): Int {

        var score = 0
        val scoreMap = mapOf("a" to 1,
            "b" to 2,
            "c" to 3,
            "d" to 4,
            "e" to 5,
            "f" to 6,
            "g" to 7,
            "h" to 8,
            "i" to 9,
            "j" to 10,
            "k" to 11,
            "l" to 12,
            "m" to 13,
            "n" to 14,
            "o" to 15,
            "p" to 16,
            "q" to 17,
            "r" to 18,
            "s" to 19,
            "t" to 20,
            "u" to 21,
            "v" to 22,
            "w" to 23,
            "x" to 24,
            "y" to 25,
            "z" to 26,
            "A" to 27,
            "B" to 28,
            "C" to 29,
            "D" to 30,
            "E" to 31,
            "F" to 32,
            "G" to 33,
            "H" to 34,
            "I" to 35,
            "J" to 36,
            "K" to 37,
            "L" to 38,
            "M" to 39,
            "N" to 40,
            "O" to 41,
            "P" to 42,
            "Q" to 43,
            "R" to 44,
            "S" to 45,
            "T" to 46,
            "U" to 47,
            "V" to 48,
            "W" to 49,
            "X" to 50,
            "Y" to 51,
            "Z" to 52)

        for (backpack in input)
        {
            val compartment1 = backpack.substring(0, backpack.length/2)
            val compartment2 = backpack.substring(backpack.length/2)

            for (item in compartment1.toCharArray().distinct())
            {
                if(compartment2.contains(item))
                {
                    println("Common char is $item")
                    score += scoreMap.getValue(item.toString())
                }
            }

        }
        return score
    }

    fun part2(input: List<String>): Int {
        var score = 0
        val scoreMap = mapOf("a" to 1,
            "b" to 2,
            "c" to 3,
            "d" to 4,
            "e" to 5,
            "f" to 6,
            "g" to 7,
            "h" to 8,
            "i" to 9,
            "j" to 10,
            "k" to 11,
            "l" to 12,
            "m" to 13,
            "n" to 14,
            "o" to 15,
            "p" to 16,
            "q" to 17,
            "r" to 18,
            "s" to 19,
            "t" to 20,
            "u" to 21,
            "v" to 22,
            "w" to 23,
            "x" to 24,
            "y" to 25,
            "z" to 26,
            "A" to 27,
            "B" to 28,
            "C" to 29,
            "D" to 30,
            "E" to 31,
            "F" to 32,
            "G" to 33,
            "H" to 34,
            "I" to 35,
            "J" to 36,
            "K" to 37,
            "L" to 38,
            "M" to 39,
            "N" to 40,
            "O" to 41,
            "P" to 42,
            "Q" to 43,
            "R" to 44,
            "S" to 45,
            "T" to 46,
            "U" to 47,
            "V" to 48,
            "W" to 49,
            "X" to 50,
            "Y" to 51,
            "Z" to 52)

        var count = 0
        var backpack1 =""
        var common =""
        for (backpack in input)
        {
            count++
            if(count == 1)
            {
                backpack1 = backpack
            }
            if(count == 2)
            {
                for (item in backpack1.toCharArray().distinct()) {
                    if (backpack.contains(item)) {
                        common += item
                    }
                }
            }

            if(count == 3)
            {
                count = 0
                for (item in common.toCharArray().distinct()) {
                    if (backpack.contains(item)) {
                        println("Common char is $item")
                        score += scoreMap.getValue(item.toString())
                    }
                }
                common =""
            }
        }
        println("Total score $score")
        return score
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}