package main.domain

/**
  *
  * @Author: huangtinghai
  * @Date: 2020/7/20 17:34
  *        Email: tinghai.huang@things-matrix.com
  */
trait Equal {
  def isEqual(x:Any):Boolean
  def isNotEqual(x:Any):Boolean = !isEqual(x)

}

trait Num{
  def isNumber(ob:Any):Boolean
}

//使用with 实现多继承
class Point(a:Int,b:Int) extends Equal with Num {
  var x:Int=a
  var y:Int=b
  def isEqual(ob: Any) =
     ob.isInstanceOf[Point] && ob.asInstanceOf[Point].x==x   //x是否是point 且 x=x
  def isNumber(ob: Any) = ob.isInstanceOf[Int]
}

object Test{

  def main(args: Array[String]): Unit = {
    val p1=new Point(1,1)
    val p2=new Point(1,6)
    println(p1.isEqual(p2))
    println(p1.isNumber(p1.x))
  }
}
