package git.group
package List

class TList[T]{
  class Node[T](data1:T){
    var data:T = data1
    var next:Node[T] = null
  }

  private var head:Node[T] = null
  private var tail:Node[T] = null
  private var size:Int = 0
  private var size_limit:Int = 200

  def pushFront(data:T):Boolean = {
    if (size < size_limit){
      var nNode:Node[T] = new Node[T](data)

      if (head == null){
        head = nNode
        tail = nNode
      }
      else {
        var tmp:Node[T] = head
        head = nNode
        head.next = tmp
      }
      size = size + 1
        return true
    }

    false
  }







//GET
//SET
  def getSize():Int = {
    size
  }

}
