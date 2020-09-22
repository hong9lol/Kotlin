val join = fun(): RESULT {
    println("* Join a Client *")
    val c = clientDataInput() ?: return RESULT.FAIL
    return joinClient(c)
}

val del = fun(): RESULT {
    println("* Delete a Client *")
    val c = clientDataInput() ?: return RESULT.FAIL
    return delClient(c)
}

val mod = fun(): RESULT {
    println("* Modify a Client Information *")
    val oriClient = clientDataInput() ?: return RESULT.FAIL
    val dstClient = clientDataInput() ?: return RESULT.FAIL
    return modClient(oriClient, dstClient)
}

val show = fun(): RESULT {
    showAllClients()
    return RESULT.SUCCESS
}

sealed class Operator {
   abstract fun doOperate()

    object Join : Operator() {
        override fun doOperate() {
            if (join() == RESULT.FAIL) println("Join a client fail... try again")
            else println("Join a client success")
        }
    }

    object Del : Operator() {
        override fun doOperate() {
            if (del() == RESULT.FAIL) println("Delete a client fail... try again")
            else println("Delete a client success")
        }
    }

    object Mod : Operator() {
        override fun doOperate() {
            if (mod() == RESULT.FAIL) println("Modify fail... try again")
            else println("Modify success")
        }
    }

    object Show : Operator() {
        override fun doOperate() {
            show()
        }
    }
}

fun doOperate(o:Operator): Unit =
        when(o) {
            is Operator.Join -> o.doOperate()
            is Operator.Del -> o.doOperate()
            is Operator.Mod -> o.doOperate()
            is Operator.Show -> o.doOperate()
        }


enum class OPERATOR(val idx: Int, val func: () -> RESULT) {
    JOIN(1, join), DEL(2, del), MOD(3, mod), SHOW(4, show)
}

fun startManageSystem() {
    while(true) {
        val oper = operatorInput()
        when (oper) {
            OPERATOR.JOIN.idx ->  doOperate(Operator.Join)
            OPERATOR.DEL.idx ->  doOperate(Operator.Del)
            OPERATOR.MOD.idx ->  doOperate(Operator.Mod)
            OPERATOR.SHOW.idx ->  doOperate(Operator.Show)
        }
        showAllClients()
    }
}

fun main(args: Array<String>) {
    startManageSystem()
}


