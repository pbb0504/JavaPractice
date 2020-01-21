class Greet (private val name:String){
    fun greet(){
        println("Hello $name")
    }
}

fun main() {
    Greet("pbb").greet()
    cal()
}

fun cal(){
    println("aaa")
}

