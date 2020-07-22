package main

import scala.util.control.Breaks

/**
  * 导入包
  */

//导入多个类
import scala.math.BigDecimal,scala.math.BigInt
import scala.math.{BigInt,BigDecimal}

//导入包下的所有事物
import scala.math._

//别名
import scala.math.{
BigDecimal=>BD,
BigInt=>BI
}



/**
  *
  * @Author: huangtinghai
  * @Date: 2020/7/16 15:28
  *        Email: tinghai.huang@things-matrix.com
  */


/*
  * 1. def是什么，def是scala的关键字，所有用def定义的内容都是函数或者方法
  * 2.这里的main是方法，因为被def定义而具备函数特征
  * 3.main是scala语言中规定scala的应用程序的入口，一个运行的scala的程序
  * 4.args: Array[String]  args是参数名称，Array[String] 是传入参数类型集合
  * 5. :Unit 表明main入口方法的类型是Unit，也就是说执行main方法后返回的Unit类型
  * 6.Unit是什么类型，相当于Java中的void类型
  * 7，=是什么？是表明main方法执行的结果是由谁来赋值，或者是main方法的方法
  * 8，方法体一般有{}来封装，里面可以有很多条语句
  * 9，{}语句块默认的类型是最后一条语句的结果类型就是{}的返回类型
  * 10.跟踪源代码发现Scala的println的IO操作是借助了Java的IO操作，也就是说Scala调用了java
  * 11，如果方法或者函数的类型或者返回类型是Unit的话，可以直接去掉 :Unit ,否则其他情况不能去掉
  * 12，关于println打印内容到控制台，底层借助了Java IO功能，一个实施情况是Scala很多时候使用Java的实现来
  *    缩短开发时间，例如说操作数据源（DB,NoSql等）的JDBC，再例如关于Thread的操作，Scala也往往也会直接使用Java中的Thread
  * 13,按照当今OS的原理，程序的main入口方法都是运行在主线程中的，OS的运行分为Kernel Space和User Space，
  *   应用程序是运行在 User Space中，应用程序Scala所在的进程一般是OS Fork出来的，被Fork出来的应用程序进程默认会有主线程，
  *   而我们的main就是默认在主线程中的。
  */
object HelloWorld {
  def main(args: Array[String]): Unit = {
    val a: Int = 1
    val h = 2
    println(h)
    println(a)

    val b: String = "b"
    println(b)

    val c: Char = 'c'
    println(c)

    /**
      * 包 别名
      */
    val l1=BD.decimal(10)
    val l2=BI.apply(2)
    println(l1)
    println(l2)


    /**
      * 多元变量
      */
    var a1, a2 = 100
    val map = (40, "abc")
    println(map)


    /**
      * 位运算
      */
    println("============================= 位运算 =========================================")

    val A = 60
    val B = 13
    println(A << 2) //左移
    println(A >> 2) //右移
    println(A & B) //与
    println(A | B) //或
    println(A ^ B) //异或
    println(~A) //非


    /**
      * 赋值运算符
      */

    println("============================= 赋值 =========================================")

    var t = 1
    var result = 0
    result += t
    println("result t+=1 :" + result)
    result <<= t
    println("result t<<=1 :" + result)


    /**
      * 条件语句
      */
    println("============================= 条件 =========================================")

    //if  ... else....
    val x = 30
    if (x < 20) {
      println("x<20")
    } else {
      println("x>20")
    }

    //if ....else if....else

    if (x == 10) {
      println("x==10")
    } else if (x == 20) {
      println("x==20")
    } else {
      println("x==other")
    }


    /**
      * 循环语句
      */
      println("============================= 循环 =========================================")
    val numlist = List(1, 2, 3, 4, 5)
    val loop = new Breaks
    var i = 0


    //for循环
    var i1=0
    var i2=0
    var i3=0
    var i4=0
    var num=0
    for(i1 <- 1 to 5){
      println("i1 :"+i1)
    }

    for(i2 <- 1 until 5){
      println("i2 :"+i2)
    }
    println("============================= 循环 多区间  =========================================")

    for(i3 <- 1 to 2 ; i4 <- 1 to 2){
      println("i3 :" + i3)
      println("i4 :" + i4)
    }

    //循环条件过滤
    for(num<-numlist
            if num >2 if num==3 ){
      println("循环条件过滤 num = "+num)
    }

    var num2=0
    //循环返回值 (返回值是集合)
    var reVal=for(num2<-numlist if num2 != 2)yield num2
    println( "循环返回值 num2 = "+reVal)



    println("============================= 循环 中断  =========================================")

    //中断方式1
    loop.breakable {
      for (i <- numlist) {
        println("value a: " + i)
        if (i == 3) {
          loop.break
        }
      }
    }
    println("end 1")

    //中断方式2
    import scala.util.control.Breaks._ //_为通配符，类似java的*
    breakable{
      for (i <- numlist) {
        println("value a: " + i)
        if (i == 2) {
            break
        }
      }
    }
    println("end 2")
  }
}
