package git.group.Builder

import git.group.Comaparator.{Comparator, ComparatorInteger}

object BuilderInteger {
  def getName:String = "Integer"
}

class BuilderInteger extends Builder with Serializable
{
  private val min:Int = 0
  private val max:Int = 100

  override def createObject(): Any =
  {
    var a:Int = scala.util.Random.nextInt(max)
    a += min
    a.asInstanceOf[Any]
  }
  override def parseObject(str: String): Any = str.toInt.asInstanceOf[Any]
  override def getComparator: Comparator = new ComparatorInteger()
  override def getName: String = "Integer"
}
