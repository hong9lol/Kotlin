val join = fun() {
    println("run join")
}
val del = fun() {
    println("run del")
}
val mod = fun() {
    println("run mod")
}
val show = fun() {
    println("run show")
}

enum class OPERATOR(val idx: Int, val func: () -> Unit) {
    JOIN(1, join), DEL(2, del), MOD(3, mod), SHOW(4, show)
}

fun startManageSystem(db: ArrayList<List<String>>) {
    while(true) {
        print("Enter: ")
        val stringInput = readLine()!!.toInt()
        if (stringInput !in 1..4) continue
       when (stringInput) {
            OPERATOR.JOIN.idx -> OPERATOR.JOIN.func()
            OPERATOR.DEL.idx -> OPERATOR.DEL.func()
            OPERATOR.MOD.idx -> OPERATOR.MOD.func()
            OPERATOR.SHOW.idx -> OPERATOR.SHOW.func()
        }
    }
}

fun main(args: Array<String>) {
    val db: ArrayList<List<String>> = arrayListOf(listOf())
    startManageSystem(db)
}


