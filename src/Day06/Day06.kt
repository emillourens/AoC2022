fun main() {
    fun part1(input: List<String>): Int {
        var counter = 0
        var index = 0
        var last4 = ""
        for (dataStreams in input)
        {
            for (streamChar in dataStreams)
            {

                if(last4.contains(streamChar))
                {
                    last4 += streamChar
                    if (last4.length > 4)
                    {
                        last4=last4.drop(1)
                    }
                }
                else
                {
                    if (last4.length == 4)
                    {
                        if(last4.allUnique())
                        {
                            index = counter
                            break
                        }
                        else
                        {
                            last4 += streamChar
                            last4=last4.drop(1)
                        }
                    }
                    else if (last4.length > 4)
                    {
                        last4 += streamChar
                        last4=last4.drop(1)
                    }
                    else
                    {
                        last4 += streamChar
                    }
                }
                counter++
            }
        }
        return index
    }

    fun part2(input: List<String>): Int {
        var counter = 0
        var index = 0
        var last14 = ""
        for (dataStreams in input)
        {
            for (streamChar in dataStreams)
            {
                counter++
                if(last14.contains(streamChar))
                {
                    last14 += streamChar
                    if (last14.length > 14)
                    {
                        last14=last14.drop(1)
                    }
                }
                else
                {
                    if (last14.length == 14)
                    {
                        last14 += streamChar
                        last14=last14.drop(1)
                        if(last14.allUnique())
                        {
                            index = counter
                            break
                        }
                    }
                    else if (last14.length > 14)
                    {
                        last14 += streamChar
                        last14=last14.drop(1)
                    }
                    else
                    {
                        last14 += streamChar
                    }
                }

            }
        }
        return index
    }



    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day06/Day06_test")
    //check(part1(testInput) == 10)
    check(part2(testInput) == 19)

    val input = readInput("Day06/Day06")
    println(part1(input))
    println(part2(input))
}