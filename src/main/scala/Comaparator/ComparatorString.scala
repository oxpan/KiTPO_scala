package git.group.Comaparator

class ComparatorString extends Comparator with Serializable
{
  override def compare(o1: Any, o2: Any): Int =
  {
    if (o1.isInstanceOf[String] && o2.isInstanceOf[String])
    {
      val a = o1.asInstanceOf[String]
      val b = o2.asInstanceOf[String]
      if(a.length < b.length)
        return -1
      else if(a.length > b.length)
        return 1
      else
        return 0
    }
    -2
  }
}
