class Greeter(private val name: String){
    fun greet(){
        println("Hello $name")
    }
}

fun main() {
    Greeter("Kotlin").greet()
    println(sum(1,2))
    printSum(3,4)
}

fun sum(a:Int, b:Int):Int{
    return a+b
}

fun sum2(a:Int ,b:Int)=a+b

fun printSum(a: Int,b: Int){
    println(a+b)
}
