package main.domain

/**
  *
  * @Author: huangtinghai
  * @Date: 2020/7/20 15:34
  *        Email: tinghai.huang@things-matrix.com
  */
class People(val h : Int,val w : Int) {
  var high : Int=h
  var wight : Int= w

  def add(a :Int , b:Int): Unit ={
    high +=a
    wight +=b

    println("high = "+ high)
    println("wight = "+wight)
  }

  override def toString: String = getClass.getName+" :"

  private def myPrint(name:String): Unit ={
    println("People private method "+name)
  }

}

//重写父类的字段 要用 override val
class Man(override val h : Int,override val w : Int,val hairL:Int) extends People(h,w) {
  var hairLength:Int=hairL

  def add(a :Int , b:Int ,c:Int): Unit ={
    high +=a
    wight +=b
    hairLength +=c

    println("high = "+ high)
    println("wight = "+wight)
    println("hairLength = "+hairLength)
  }

  override def toString: String = super.toString +" Man"
}

//Scala 中使用单例模式时，除了定义的类之外，还要定义一个同名的 object 对象，它和类的区别是，object对象不能带参数。
//当单例对象与某个类共享同一个名称时，他被称作是这个类的伴生对象，这个类是单例对象的伴生类
//伴生对象和伴生类是可以相互访问私有成员的
object People{
  def main(args: Array[String]): Unit = {
    var man =new Man(10,30,20)
    var people = new People(1,2)
    people.myPrint("yang")  //访问私有方法
    println(man.toString)
  }

}

