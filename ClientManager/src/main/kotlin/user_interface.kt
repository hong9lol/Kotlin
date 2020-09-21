import kotlin.system.exitProcess

fun clientDataInput(): List<Any>? {
    print("Name(String):")
    val name = readLine()!!
    print("Age(Int):")
    val age = readLine()!!.toIntOrNull() ?: return null
    print("Gender(0: man, 1: woman, others: etc):")
    val gender = readLine()!!.toIntOrNull() ?: return null

    return listOf(name, age, gender)
}

fun operatorInput(): Int {
    print("Choose option(exit: 0): ")
    val input = readLine()!!.toIntOrNull() ?: return 0
    if (input == 0) {
        println("System will be terminate...")
        Thread.sleep(1000)
        exitProcess(0)
    }
    return input
}