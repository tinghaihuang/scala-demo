package main
import java.io.FileReader
import java.io.{FileNotFoundException, FileReader, IOException}

import scala.util.matching.Regex

object FunctionTest {

  //Unit 无返回值类型 使用时可以不写 : Unit=
  def myPrint(mess:String) : Unit={
    println(mess)
  }


  //有返回值时 也可以将返回类型省略掉，scala会根据返回值推演返回类型
  def add(name:String,title:String) : String={
    return "name = "+name+", title = "+title
  }

  //可变参数
  def longPrint(mess:String*) ={
    var i=0
    var me=""
    for (me<-mess){
      println("mess "+i+" :"+me)
      i+=1
    }
  }

  //默认参数
  def printName(name : String="huang")={
    println("参数（默认huang） :"+ name)
  }

  //嵌套函数
  def subtract(b:Int , c:Int):Int={
    def subtractInt(b:Int,c:Int):Int={
       b-c
    }
     subtractInt(b,c)
  }

  //匿名函数
  var inc=(x:Int) => x+1

  //高阶函数


  //函数柯基化
  def subString(s1:String)(s2:String): String ={
    s1+s2
  }

  //闭包
  var factor=3
  val multilier=(i:Int)=>i*factor


  //模式匹配 类似java的switch case
 //case的值也可以是对象
  def matchTest1(x:Any):Any = x match {
    case 1 => "one"
    case 2 => "two"
    case 0 | "" => false    //在0或空字符串的情况下,返回false
    case  4 | 6 | 8 | 10 => "偶数"     //在10及以下的偶数,返回"偶数"
    case m if m == 5 || m == 7 => "5 company, 7 crowd"    //在模式匹配中使用if
    case y:Int=> "other Int"
    case _ => "other Obj"
  }






  def main(args: Array[String]){
    myPrint("hello , scala !")

    //指定参数调用
    println(add(title = "lll",name = "hh"))

    //多参数
    longPrint("hello","scala")

    //默认参数
    printName()
    printName("ting")

    //嵌套函数
    println("嵌套函数  "+subtract(5,3))

    //匿名函数
    println("匿名函数  "+inc(4))

    //偏应用函数 参数使用下划线(_)替换缺失的参数列表，并把这个新的函数值的索引的赋给变量。

    val a=5
    val newSub=subtract(a,_:Int)
    println("偏应用函数 "+newSub(3))


    //函数柯基化
    println("函数柯基化 "+subString("hello ")("scala"))


    //闭包
    println("闭包 "+multilier(2))


    //模式匹配
    println("模式匹配 "+matchTest1(3))
    println("模式匹配 "+matchTest1("s"))
    println("模式匹配 "+ matchTest1(5))
    println("模式匹配 "+matchTest1(4))



    //正则表达 继承了java的正则表达规则
    val pattern=new Regex("(S|s)cala")  //或者 "Scala".r 使用String 类的r()方法构造regex对象
    val str ="Scala is scalable and cool"
    println("正则表达"+ (pattern findFirstIn str))
    println("正则表达"+ (pattern findAllIn  str).mkString(","))  //mkString 连接匹配结果
    println("正则表达"+ (pattern replaceAllIn(str,"java"))) //替换




    //异常处理
    try {
    //  val f = FileReader("1.txt")
    }catch {
      case ex: FileNotFoundException =>
        println("file not found")
      case ex: IOException => {
        println("IO Exception")
      }
    }



  }

}
