package git.group
package List

class TList[T]{
  class Node[T](data1:T)
  {
    var data:T = data1
    var next:Node[T] = null
  }

  private var head:Node[T] = null
  private var size:Int = 0
  private var size_limit:Int = 200





//GET
//SET
  def getSize():Int = {
    size
  }

}
