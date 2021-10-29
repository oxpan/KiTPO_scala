package git.group
package List

class TList[T](limit:Int){
  class Node[T](data1:T){
    var data:T = data1
    var next:Node[T] = null
  }

  private var head:Node[T] = null
  private var tail:Node[T] = null
  private var size:Int = 0
  private var size_limit:Int = limit

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

  def delete(index:Int):Boolean = {
    if (index < 0) {
      return false
    }
    var toDel: Node[T] = null
    var toDelPrev: Node[T] = null

    if (head == null) {
      println("List is empty")
      return false
    }
    else {
      if (head != tail) {
        if (index > 0) {
          toDelPrev = findNode(index - 1)
          toDel = toDelPrev.next
        }
        else toDel = head

        if (toDelPrev != null) {
          toDelPrev.next = toDel.next
          toDel = null
        }
        else {
          head = toDel.next
          toDel = null
        }
      }
      else {
        head = null
        tail = null
      }

    }
    size = size - 1
    true
  }

  private def findNode(id:Int):Node[T] = {
    var res:Node[T] = head
    var n:Int = 0
    while (n < id){
      res = res.next
      n = n + 1
    }
    res
  }

  def find(index:Int):T = {
    var current:Node[T] = head
    var dataNode:T = current.data  /// Назойлевый коостыль найти по этой хрени инфу. Не забудь!
    if (index == 0){
      dataNode = current.data
      return dataNode
    }
    var n:Int = 0
    while (n < index){
      current = current.next
      n = n + 1
    }
    dataNode = current.data
    dataNode
  }

  def finds(obj:T):Int = {
    var current:Node[T] = head
    var index:Int = 0
    if (head == null){
      return -1
    }
    else {
      while (current != null){
        if (current.data == obj){
          return index
        }
        index = index + 1
        current = current.next
      }
    }
    -1
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
//SET       пока я в запутоности от скалы нужныли эти сетеры или нет но пускай пока лежат
  def getSize():Int = {
    size
  }
  def getSizeLimit:Int = size_limit
  def setSizeLimit(limit:Int):Boolean = {
    if(limit <= 0 || limit <= size){
      return false
    }
    size_limit = limit
    true
  }

}
