package main

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
    val a :Int= 1
    val h=2
    println(h)
    println(a)

    val b :String ="b"
    println(b)

    val c :Char ='c'
    println(c)


    /**
      * 多元变量
      */
    var a1,a2=100
    val map=(40,"abc")
    println(map)
  }
}
