fun main() {
    fun part1(input: List<String>): Int {

        var forest: MutableList<MutableList<Int>> = ArrayList()//Array(input.size) { IntArray(input.size) }

        var counter = 0

        for ((i, line) in input.withIndex())
        {
            var tempList: MutableList<Int> = ArrayList()
            for ( j in line.indices)
                tempList.add(line[j].digitToInt())

            forest.add(tempList)
        }

        var forestTranspose = forest
        for (i in forest.indices) {
            for (j in forest[i].indices) {
                forestTranspose[j][i] = forest[i][j]
            }
        }
        ///var forest2 = forest.zip()

        for (row in forest.indices)
        {
            for (column in forest[row].indices)
            {
                var tree = forest[row][column]
                var right = forest[row].subList(0, column)
                var left = forest[row].subList(column + 1, forest.size)
                var leftT = forestTranspose[column].subList(0, row)
                var rightT = forestTranspose[column].subList(row + 1, forest.size)

                if( right.all { x -> x < tree } || left.all {  x -> x < tree  } || leftT.all {  x -> x < tree  } || rightT.all {  x -> x < tree  })
                    counter++

            }
            //println("Visible tree $largest")
        }
        println(counter)
        return counter
    }

    fun part2(input: List<String>): Int {
        return input.size
    }


    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day08/Day08_test")
    check(part1(testInput) == 21)

    val input = readInput("Day08/Day08")
    println(part1(input))
    //println(part2(input))
}