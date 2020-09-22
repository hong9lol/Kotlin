import kotlin.system.exitProcess

fun clientDataInput(): ClientInfo? {
    print("Name(String):")
    val name = readLine()!!
    print("Age(Int):")
    val age = readLine()!!.toIntOrNull() ?: return null
    print("Gender(0: man, 1: woman, others: etc):")
    val gender = readLine()!!.toIntOrNull() ?: return null
    print("Extra data(String, 0 is skip):")
    val etc = readLine()!!.let{
        if (it == "0") "None" else it
    }

    return ClientInfo(name, age, gender, etc)
}

fun operatorInput(): Int {
    print("=================\n " +
            "1. Join a Client\n " +
            "2. Delete a Client\n " +
            "3. Modify a Client Info\n " +
            "4. Show all Clients\n" +
            "=================\n" +
            "Choose option(exit: 0): ")
    val input = readLine()!!.toIntOrNull() ?: return 0
    if (input == 0) {
        println("System will be terminate...")
        Thread.sleep(1000)
        exitProcess(0)
    }
    return input
}