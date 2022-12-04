fun main() {


    fun part1(input: List<String>): Int {
        var calories = 0
        var counter = 1
        var elfWithTheLargestCal = 0
        var prevLargest = 0

        for (item in input)
       {

           if(item == "")
           {
               counter++
               calories = 0
               continue
           }

           calories += item.toInt()
           if(prevLargest < calories)
           {
               prevLargest = calories
               elfWithTheLargestCal = calories
           }
       }
        return elfWithTheLargestCal
    }

    fun part2(input: List<String>): Int {
        var calories = 0
        val total: Int
        val num = mutableListOf<Int>()

        for (item in input)
        {
            if(input.last() == item)
            {
                num.add(item.toInt())
            }

            if(item == "")
            {
                num.add(calories)
                calories = 0
                continue
            }


            calories += item.toInt()

        }
        num.sort()


        total = num.takeLast(3).sum()


        return total
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
