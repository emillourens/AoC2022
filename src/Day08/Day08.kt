fun main() {
    fun part1(input: List<String>): Int {

        var forest: MutableList<MutableList<Int>> = ArrayList()//Array(input.size) { IntArray(input.size) }

        var counter = 0

        for (line in input)
        {
            var tempList: MutableList<Int> = ArrayList()
            for ( j in line.indices)
                tempList.add(line[j].digitToInt())
            forest.add(tempList)
        }

        var forestTranspose: MutableList<MutableList<Int>> = ArrayList()
        for (i in forest.indices) {
            var tempList: MutableList<Int> = ArrayList()
            for (j in forest[i].indices) {
                tempList.add(forest[j][i])
            }
            forestTranspose.add(tempList)
        }

        for (row in forest.indices)
        {
            for (column in forest[row].indices)
            {
                var tree = forest[row][column]
                var left = forest[row].subList(0, column)
                var right = forest[row].subList(column + 1, forest.size)
                var up = forestTranspose[column].subList(0, row)
                var down = forestTranspose[column].subList(row + 1, forest.size)

                if( right.all   {  x -> x < tree  }
                    || left.all {  x -> x < tree  }
                    || up.all   {  x -> x < tree  }
                    || down.all {  x -> x < tree  })
                    counter++

            }
            //println("Visible tree $largest")
        }
        println(counter)
        return counter
    }

    fun ViewDistance(tree: Int, view: MutableList<Int>): Int
    {
        var view_length = 0
        for (v in view) {
            view_length += 1
            if (v >= tree)
                break
        }
        return view_length
    }

    fun part2(input: List<String>): Int {

        var forest: MutableList<MutableList<Int>> = ArrayList()//Array(input.size) { IntArray(input.size) }

        var BigScore = 0

        for (line in input)
        {
            var tempList: MutableList<Int> = ArrayList()
            for ( j in line.indices)
                tempList.add(line[j].digitToInt())
            forest.add(tempList)
        }

        var forestTranspose: MutableList<MutableList<Int>> = ArrayList()
        for (i in forest.indices) {
            var tempList: MutableList<Int> = ArrayList()
            for (j in forest[i].indices) {
                tempList.add(forest[j][i])
            }
            forestTranspose.add(tempList)
        }

        for (row in forest.indices)
        {
            for (column in forest[row].indices)
            {
                var score = 0
                var tree = forest[row][column]
                var left = forest[row].subList(0, column).reversed().toMutableList()
                var right = forest[row].subList(column + 1, forest.size)
                var up = forestTranspose[column].subList(0, row).reversed().toMutableList()
                var down = forestTranspose[column].subList(row + 1, forest.size)

                var s1 =  ViewDistance(tree, left)
                var s2 =  ViewDistance(tree, right)
                var s3 =  ViewDistance(tree, up)
                var s4 =  ViewDistance(tree, down)

                score = s1 * s2 * s3 * s4
                if (score > BigScore)
                    BigScore = score

            }
            //println("Visible tree $largest")
        }
        println(BigScore)
        return BigScore
    }




    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day08/Day08_test")
    check(part1(testInput) == 21)

    val testInput2 = readInput("Day08/Day08_test2")
    check(part1(testInput2) == 22)

    check(part2(testInput) == 8)

    val input = readInput("Day08/Day08")
    println(part1(input))
    println(part2(input))
}