package main
import Array._
import scala.collection.mutable
import scala.collection.mutable.Map

object CollectionsTest {

  def main(args: Array[String]): Unit = {
    /**
      * 数组Array
      */
    println("***************************** Array *******************************")

    //数组定义
    var a:Array[String]=new Array[String](3)
    var b=new Array[String](3)

    //多维数组
    var myMatrix = ofDim[Int](3,3)

    var c=Array("a","b","c")
    var d=Array("d","e")
    var e=concat(c,d)  //合并
    var i=0
    for (i<-e){
      println(i)
    }

    /**
      * 列表List
      */
    println("***************************** List *******************************")

    // 字符串列表
    val site: List[String] = List("Runoob", "Google", "Baidu")
    val site2 = "Runoob" :: ("Google" :: ("Baidu" :: Nil))

    // 整型列表
    var nums = List(1, 2, 3, 4,"c")


    // 空列表
    val empty: List[Nothing] = List()  //或者 Nil
    val em=Nil

    // 二维列表
    val dim: List[List[Int]] =
      List(
        List(1, 0, 0),
        List(0, 1, 0),
        List(0, 0, 1)
      )

    var re1= nums.+:(5) //预添加元素
    var re2=nums.:+(5) //添加元素
    var re3= nums.::(0) //表头添加
    var re4= nums.filter(_!=2) //过滤

    var l=0
    for(l<-re3){
      println("list "+l)
    }
    re4.foreach(println)
    println("drop "+nums.drop(2))  //删除前n个元素
    println("head "+nums.head)      //返回第一个元素
    println("tail "+nums.tail)      //返回除第一个元素的其他元素
    println("isEmpty "+nums.isEmpty)  //是否为空
    println("连接集合 "+List.concat(site,site2))  //连接集合  或者使用 site.:::(site2)


    // 第一个参数接收一个或多个值，代表一维或多维列表

    //第二个参数相当于一个或多个for循环，（）内的参数就是这些for循环最中间对每个for循环的值的计算公式
    val squares = List.tabulate(7)(n => n * n)
    println( "一维 : " + squares  )

    //获取元素
    println(nums.apply(2))


    /**
      * set 默认不可变集合
      */
    println("***************************** Set *******************************")

    //不可变
    val set1 = Set(1,2,"a")
    println(set1)

    //可变set
    import scala.collection.mutable.Set

    val set2 = Set(3,2,1,"a")
    set2.add(4)
    println("mutable add "+set2)
    set2.remove(2)
    println("mutable delete "+set2)

    //head tail isEmpty 同上

    println("连接集合 Set  "+set1.++(set2)) //集合合并
    println("交集 Set  "+set1.&(set2))  //集合交集
    println("差集 Set "+set1.&~(set2))  //集合差集
    println("添加元素 Set "+set1.+(5))  //添加元素
    println("删除元素 Set "+set1.-(5))  //删除元素

    //迭代器
    set1.iterator.foreach(i=> println("迭代器 value = "+i))

    /**
      * Map
      */

    println("***************************** Map *******************************")

    //定义
    var A:Map[Int,Int] = Map()
    var B=Map(1->1,2->2,4->"a","c"->9)

    //可变
    //同时用
    var C=mutable.Map(1->1,2->2)  //或者引入 import scala.collection.mutable.Map   var D=Map(1->1,2->2)


    C.put(3,3)
    println("可变 "+C)

    B+=(3->3)
    A+=(3->3)
    A+=(4->4)
    A+=(5->5)
    println("get  "+B.get("c"))

   println("Option "+B.get("c").filter(_.equals(9)).map(m=>m.toString).get)



    println(B)

    println("keys : "+B.keys)
    println("values : "+B.values)
    println("isEmpty : "+B.isEmpty)

    println("合并"+A.++(B))  //合并 (A++B)
    println("添加 "+A.+(7->7)) //添加
    println("删除单个"+A.-(5))   //删除
    println("删除多个"+A.-(5,4)) //删除多个

    //foreach 方法
    B.keys.foreach{i=>print("Key = "+i)
                      println(" , value = "+B(i))}


    println("***************************** 元组 *******************************")

    //定义
    //目前 Scala 支持的元组最大长度为 22
    val t=new Tuple3(1,3.4,"a") //或者(1,3.4,"a")
    println("元组 "+t)
    println("访问元素 "+t._3)

    val t2=("zzz","vvv")   //Tuple2的方法

    println("swap "+t2.swap)
    t.productIterator.foreach(println)




  }

}
