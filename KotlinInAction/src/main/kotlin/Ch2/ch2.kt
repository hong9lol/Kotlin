package Ch2

fun ch2(args: Array<String>) {
    val m = max3(3, 4)
    println(m)

    val v = valTest()
    println(v)

    val p = Person("Jake")
    println(p.name)
    println(p.isJake)
    p.age = 32 - 1 // western age
    println(p.age)

    println(Color.RED.rgb())
    val c = Color.BLUE
    val b = Color.BLUE
    when(setOf(c, b)) {
        setOf(Color.RED, Color.BLUE) -> ""
    }


}

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}
fun max2(a: Int, b: Int): Int = if (a > b) a else b
fun max3(a: Int, b: Int) = if (a > b) a else b

fun valTest(): String {
    val flag = true

    // init or add after declare
    val message: String
    message = if (flag) "These are " else "these are not "
    val languages = arrayListOf("Java")
    languages.add(" Kotlin")

    return message + languages
}


 /* Java
public class Person {
    private final String name;
    public Person(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
 */

class Person(val name: String, var age: Int = 32) {
    val isJake: Boolean
        get() {
            return name == "Jake"
        }
}

enum class Color(
        val r: Int, val g: Int, val b:Int
) {
    RED(255, 0 , 0), GREEN(0, 255, 0), BLUE(0, 0, 255);
    fun rgb() = (r * 1000000) + (g * 1000) + b
}