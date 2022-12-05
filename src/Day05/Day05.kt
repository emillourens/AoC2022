
fun main() {
    fun part1(input: List<String>): String {

        var counter = 0

        var stacks = mutableListOf(mutableListOf<String>())

        for (i in 0..7) {
            stacks.add(mutableListOf())
        }

        var stacksstring = "  J  B T\n" +
                "  ML QLR\n" +
                "  GQ WSBL\n" +
                "D DT MGVP\n" +
                "T NNNDJGN\n" +
                "WHHSCNRWD\n" +
                "NPPWHHBNG\n" +
                "LCWCPTMZW"
        for (char in stacksstring) {
            if (char.toString() == "\n") {
                counter = 0
            } else {
                if (char.toString() == " ") {
                    counter++
                    continue
                } else {
                    stacks[counter].add(char.toString())
                    counter++
                }
            }
        }

        var reversedStacks = mutableListOf<MutableList<String>>()

        for (stack in stacks) {
            reversedStacks.add(stack.reversed().toMutableList())
        }


        //var stacks = mutableListOf(mutableListOf("Z", "N"), mutableListOf("M", "C", "C"), mutableListOf("P"))

        for (instructions in input) {
            println(instructions)
            var cleanedInput = instructions.replace("move ", "").replace(" from ", "").replace(" to ", "")

            var amount = cleanedInput[0].toString()
            var from = cleanedInput[1].toString()
            var to = cleanedInput[2].toString()

            //var sequence = mutableListOf<String>()

            for (i in 0 until amount.toInt() step 1) {
                var box = ""
                when (from) {
                    "1" -> {

                        box += reversedStacks[0].removeLast()
                        println("Box to be removed from stack 1 $box")
                        //sequence.add(box)
                    }

                    "2" -> {
                        //var box = ""
                        box += reversedStacks[1].removeLast()
                        println("Box to be removed from stack 2 $box")
                        //sequence.add(box)
                    }

                    "3" -> {
                        //var box = ""
                        box += reversedStacks[2].removeLast()
                        println("Box to be removed from stack 3 $box")
                        //sequence.add(box)
                    }
                }

                when (to) {
                    "1" -> {
                        //var box = ""
                        //box += sequence.removeFirst()
                        println("Box to be added to stack 1 $box")
                        reversedStacks[0].add(box)
                    }

                    "2" -> {
                        //var box = ""
                        //box += sequence.removeFirst()
                        println("Box to be added to stack 2 $box")
                        reversedStacks[1].add(box)
                    }

                    "3" -> {
                        //var box = ""
                        //box += sequence.removeFirst()
                        println("Box to be added to stack 3 $box")
                        reversedStacks[2].add(box)
                    }
                }
            }
        }

        var output = ""

        for (stack in reversedStacks) {
            output += stack.removeLast()
        }
        print(output)


        return output

    }


    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day05/Day05_test")
    //check(part1(testInput) == "CMZ")

    val input = readInput("Day05/Day05")
    println(part1(input))
    //println(part2(input))
}
