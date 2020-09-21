import Clients.db

internal object Clients {
    val db: ArrayList<Client>? = arrayListOf()
}

data class Client(val name: String, val age: Int, val gender: Int)  {
    private val number = ++totalNum
    init {
        db?.add(this)
        showAllClients()
    }

    override fun toString(): String {
        val gen = when(gender) {
            0 -> "남자"
            1 -> "여자"
            else -> "기타"
        }
        return "[${this.number}: ${this.name}, ${this.age}, $gen]\n"
    }

    companion object {
        var totalNum: Int = 0
    }
}

fun delClient(c: Client): RESULT {

    println("del client")
    return RESULT.SUCCESS
}

fun modClient(ori_c: Client, dst_c: Client): RESULT {

    println("mod client")
    return RESULT.SUCCESS
}

fun showAllClients() {
    println("====================================")
    println(db)
    println("====================================")
}