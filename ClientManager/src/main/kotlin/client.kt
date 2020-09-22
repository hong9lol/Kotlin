import Clients.db

internal object Clients {
    val db: ArrayList<ClientInfo>? = arrayListOf()
}
data class ClientInfo(val name: String, val age: Int, val gender: Int, val etc: String) {
    private val number = ++totalNum

    override fun equals(other: Any?)
            = (other is ClientInfo)
            && name == other.name
            && age == other.age
            && gender == other.gender

    override fun toString(): String {
        val gen = when(this.gender) {
            0 -> "남자"
            1 -> "여자"
            else -> "기타(${this.gender})"
        }
        return "[${this.number}: ${this.name}, ${this.age}, $gen, ${this.etc}]\n"
    }

    companion object {
        var totalNum: Int = 0
    }
}

fun joinClient(ci: ClientInfo): RESULT {
    db?.forEach {
        if (it == ci) {
            println("Already signed out, please check client information")
            return RESULT.FAIL
        }
    }
    db?.add(ci)
    return RESULT.SUCCESS
}

fun delClient(ci: ClientInfo): RESULT {
    findClient(ci).let {
        return when(it) {
            -1 -> {
                println("Fail to delete a client from db, No matches, return: $it")
                RESULT.FAIL
            }
            -2 -> {
                println("Fail to delete a client from db, founded more than two matches, put extra data, return: $it")
                RESULT.FAIL
            }
            else -> {
                db?.removeAt(it)
                println("Success to delete a client from db")
                RESULT.SUCCESS
            }
        }
    }
}

fun modClient(ori_ci: ClientInfo, dst_ci: ClientInfo): RESULT {
    findClient(ori_ci).let {
        return when(it) {
            -1 -> {
                println("Fail to modify a client information, No matches, return: $it")
                RESULT.FAIL
            }
            -2 -> {
                println("Fail to modify a client information, founded more than two matches, put extra data, return: $it")
                RESULT.FAIL
            }
            else -> {
                db?.removeAt(it)
                joinClient(dst_ci)
                println("Success to modify a client from db")
                RESULT.SUCCESS
            }
        }
    }
}

fun showAllClients() {
    println("\n====================================")
    println(db)
    println("====================================\n\n")
}

fun findClient(ci: ClientInfo): Int {
    val isEqual = {_ci:ClientInfo -> _ci.name == ci.name && _ci.age == ci.age && _ci.gender == ci.gender}
    val isEqualWithEtc = {_ci:ClientInfo -> _ci.name == ci.name && _ci.age == ci.age && _ci.gender == ci.gender && _ci.etc == ci.etc}
    return when(db?.count(isEqual)) {
        1 -> db.indexOf(ci)
        0 -> -1
        else -> if (db?.count(isEqualWithEtc) == 1) db.indexOf(ci) else -2
    }
}