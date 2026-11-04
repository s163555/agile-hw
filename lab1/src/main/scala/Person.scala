
class Person(val name: String, val age: Int) {
    def greet(): String = s"Hello, my name is $name and I am $age years old."
}

object PersonApp extends App {
    val name = args(0)
    val age = args(1).toInt
    val p = new Person(name, age)
    println(p.greet())
}