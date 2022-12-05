
fun main() {
    fun part1(input: List<String>): String {

        val stacks = mutableMapOf<String, MutableList<String>>()

        for (instructions in input) {
            var counter = 1
            if (instructions != "_________" && !instructions.contains("move")) {

                if (stacks.size < instructions.length) {
                    for (i in 1..instructions.length + 1) {
                        stacks[i.toString()] = mutableListOf()
                    }
                }

                for (char in instructions) {
                    if (char.toString() == "\n") {
                        counter = 1
                    } else {
                        if (char.toString() == " ") {
                            counter++
                            continue
                        } else {
                            stacks[counter.toString()]?.add(char.toString())
                            counter++
                        }
                    }
                }
            }
            if(instructions == "_________")
            {
                for (i in 1 .. stacks.size)
                {
                    stacks[i.toString()] = stacks[i.toString()]?.reversed()?.toMutableList()!!
                }
            }
            if (instructions.contains("move")) {

                println(instructions)
                val cleanedInput = instructions.replace("move ", "").replace(" from ", "|").replace(" to ", "|").split("|")

                val amount = cleanedInput[0]
                val from = cleanedInput[1]
                val to = cleanedInput[2]

                for (i in 1 .. amount.toInt()) {
                    var box: String = stacks[from]?.pop().toString()
                    println("$box to be removed from stack $from and added to $to ")

                    stacks[to]?.push(box)
                }
            }
        }

        var output = ""

        for (i in 1 .. stacks.count() step 1) {
            output += stacks[i.toString()]?.last()
        }
        //print(output)

        return output

    }


    fun part2(input: List<String>): String {
        val stacks = mutableMapOf<String, MutableList<String>>()

        for (instructions in input) {
            var counter = 1
            if (instructions != "_________" && !instructions.contains("move")) {

                if (stacks.size < instructions.length) {
                    for (i in 1..instructions.length + 1) {
                        stacks[i.toString()] = mutableListOf()
                    }
                }

                for (char in instructions) {
                    if (char.toString() == "\n") {
                        counter = 1
                    } else {
                        if (char.toString() == " ") {
                            counter++
                            continue
                        } else {
                            stacks[counter.toString()]?.add(char.toString())
                            counter++
                        }
                    }
                }
            }
            if (instructions == "_________") {
                for (i in 1..stacks.size) {
                    stacks[i.toString()] = stacks[i.toString()]?.reversed()?.toMutableList()!!
                }
            }
            if (instructions.contains("move")) {

                println(instructions)
                val cleanedInput =
                    instructions.replace("move ", "").replace(" from ", "|").replace(" to ", "|").split("|")

                val amount = cleanedInput[0]
                val from = cleanedInput[1]
                val to = cleanedInput[2]

                //var box = M
                val boxes = stacks[from]?.takeLast(amount.toInt())

                repeat(amount.toInt()){stacks[from]?.removeLastOrNull()}
                println("$boxes to be removed from stack $from and added to $to ")

                for ( box in boxes!!)
                {
                    stacks[to]?.add(box)
                }
            }
        }

        var output = ""

        for (i in 1 .. stacks.count() step 1) {
            output += stacks[i.toString()]?.last()
        }
        //print(output)

        return output
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day05/Day05_test")
    check(part1(testInput) == "CMZ")
    check(part2(testInput) == "MCD")

    val input = readInput("Day05/Day05")
    println(part1(input))
    println(part2(input))
}
