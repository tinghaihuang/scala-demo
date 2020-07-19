package main
import Array._

object CollectionsTest {

  def main(args: Array[String]): Unit = {
    /**
      * 数组
      */
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
      * 列表
      */
    // 字符串列表
    val site: List[String] = List("Runoob", "Google", "Baidu")
    val site2 = "Runoob" :: ("Google" :: ("Baidu" :: Nil))

    // 整型列表
    var nums: List[Int] = List(1, 2, 3, 4)


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

    //获取元素
    println(nums.apply(2))


  }

}
