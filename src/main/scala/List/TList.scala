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

  def pushEnd(data:T):Boolean = {
    if (size < size_limit){
      var nNode:Node[T] = new Node[T](data)

      if (head == null){
        head = nNode
        tail = nNode
      }
      else {
        tail.next = nNode
        tail = nNode
      }
      size = size + 1
      return true
    }

    false
  }

  def add(data:T, index:Int):Boolean = {
    if (size < size_limit){
      var nNode:Node[T] = new Node[T](data)

      if (head == null){
        head = nNode
        tail = nNode
      }
      else {
        var tmp:Node[T] = head
        var current:Node[T] = null
        var n:Int = 0
        while (n < index){
          current = tmp
          tmp = tmp.next
          n = n + 1
        }

        current.next = nNode
        nNode.next = tmp
      }
      size = size + 1
      return true
    }
    false
  }


  //временный метод служащий для тестов списка на начальных этапах
  def print():Boolean = {
    var current:Node[T] = head

    if(head == null){
      println("list pust")
      return false
    }

    while (current != null){
//      println(current.data + " ")
      printf(current.data + " ")
      current = current.next

    }
    true
  }







//GET
//SET
  def getSize():Int = {
    size
  }

}
