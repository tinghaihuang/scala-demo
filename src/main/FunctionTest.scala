package main

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
  def matchTest1(x:Any):String = x match {
    case 1 => "one"
    case 2 => "two"
    case _ => "other"
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
    println("模式匹配 "+matchTest(3))
  }

}
