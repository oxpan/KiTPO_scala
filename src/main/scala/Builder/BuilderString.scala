package git.group.Builder

import git.group.Comaparator.{Comparator, ComparatorString}

object BuilderString  {
  def getName:String = "String"
}

class BuilderString extends Builder with Serializable
{
  private val maxLength:Int = 100
  private val minCode:Int = 97
  private val maxCode:Int = 122
  private val diap:Int = maxCode - minCode

  override def createObject(): Any =
  {
    val sz:Int = scala.util.Random.nextInt(maxLength-1)+1
    var buffer:StringBuilder = new StringBuilder
    var i:Int = 0
    while(i<sz)
    {
      var code = scala.util.Random.nextInt(diap)
      code += minCode
      buffer += code.toChar
      i+=1
    }
    buffer.toString().asInstanceOf[Any]
  }

  override def parseObject(str: String): Any = str.asInstanceOf[Any]
  override def getComparator: Comparator = new ComparatorString
  override def getName: String = "String"
}
