package git.group
package List

class TList{
  class Node(data1:Int)
  {
    var data = data1
    var next:Node = null
  }

  private var head:Node = null
  private var size:Int = 0
  private var size_limit:Int = 200



  def getSize():Int = {
    size
  }

}
