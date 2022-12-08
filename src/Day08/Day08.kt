fun main() {
    fun part1(input: List<String>): Int {

        var forest = Array<Array<Int>[input.size]>[input.size]
        var counter = 0
        for line in input
        {
            forest[counter] = line.toCharArray()
        }

        var counter = 0
        for i in forest.indices
        {
            var largest = forest[i][0]
            for j in forest[i].indices
            {
                if(largest > forest[i][j])
                {
                    counter++
                    largest = tree
                }
            }
        }
        for i in forest.indices
        {
            var largest = forest[0][i]
            for j in forest[i].indices
            {
                if(largest > forest[j][i])
                {
                    counter++
                    largest = tree
                }
            }
        }
        for i in forest.indices.reversed()
        {
            var largest = forest[i][0]
            for j in forest[i].indices
            {
                if(largest > forest[i][j])
                {
                    counter++
                    largest = tree
                }
            }
        }
        for i in forest.indices.reversed()
        {
            var largest = forest[0][i]
            for j in forest[i].indices.reversed()
            {
                if(largest > forest[j][i])
                {
                    counter++
                    largest = tree
                }
            }
        }

        return counter
    }

    fun part2(input: List<String>): Int {
        return input.size
    }


    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 1)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}