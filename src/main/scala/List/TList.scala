package git.group
package List

import git.group.Builder.Builder
import git.group.Comaparator.Comparator
import git.group.List.DoIt

class TList(var builder:Builder) extends Serializable
{
  class Node(data1:Any) extends Serializable
  {
    var data:Any = data1
    var next:Node = null
  }

  private var head:Node = null
  private var tail:Node = null
  private var size:Int = 0
  private var comparator:Comparator = builder.getComparator

  def getBuilder:Builder = builder

  def setBuilder(builder: Builder):Boolean = {
    if (size == 0){
      this.builder = builder
      this.comparator = builder.getComparator
      return true
    }
    false
  }

  def pushFront(data:Any):Boolean =
  {
    var nNode:Node = new Node(data)

    if (head == null)
    {
      head = nNode
      tail = nNode
    }
    else
    {
      val tmp:Node = head


      head = nNode
      head.next = tmp
    }
    size = size + 1

    true
  }

  def pushEnd(data:Any):Boolean =
  {
      val nNode:Node = new Node(data)

      if (head == null){
        head = nNode
        tail = nNode
      }
      else {
        tail.next = nNode
        tail = nNode
      }
      size = size + 1
      true
  }

  private def pushEndd(toInsert: TList): Unit = {
    if (toInsert != null) {
      tail.next = toInsert.head.asInstanceOf[Node]
      tail = toInsert.tail.asInstanceOf[Node]
      size += toInsert.size
    }
  }

  def add(data:Any, index:Int):Boolean =
  {
    if (index == 0){
      return pushFront(data)
    }
      val nNode:Node = new Node(data)

    if (head == null) {
      head = nNode
      tail = nNode
    }
    else {
      var tmp: Node = head
      var current: Node = null
      var n: Int = 0
      while (n < index) {
        current = tmp
        tmp = tmp.next
        n = n + 1
      }
        current.next = nNode
        nNode.next = tmp
      }
      size = size + 1
      true
  }

  def delete(index:Int):Boolean = {
    if (index < 0) {
      return false
    }
    var toDel: Node = null
    var toDelPrev: Node = null

    if (head == null) {
      println("List is empty")
      return false
    }
    else {
      if (head != tail) {
        if (index > 0) {
          toDelPrev = findNode(index-1)//-1?
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

  private def findNode(id:Int):Node = {
    var res:Node = head
    var n:Int = 0
    while (n < id){
      res = res.next
      n = n + 1
    }
    res
  }

  def find(index:Int):Any = {
    var current:Node = head
    var dataNode:Any = current.data
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

  def finds(obj:Any):Int = {
    var current:Node = head
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

  def find_quantity(obj:Any):Int = {
    var current:Node = head
    var quantity:Int = 0
    if (head == null){
      return -1
    }
    else {
      while (current != null){
        if (current.data == obj){
          quantity = quantity+1
        }
        current = current.next
      }
      return quantity
    }

    -1
  }

  def sort():Boolean=
  {
    var r:TList = quickSort(this)
    head=r.head.asInstanceOf[Node]
    tail=r.tail.asInstanceOf[Node]
    true
  }

  private def swap (q:Int, z:Int):Boolean=
  {
    //q должно быть обязательно меньше z
    //Если это условие нарушается, то делаем обмен индексов
    var qq:Int = q
    var zz:Int = z
    if(q==z)
      return false
    else if(q>z)
    {
      qq = z
      zz = q
    }
    var nqPrev:Node = head;
    var nq:Node = head;
    //Ищем ноду z
    var nzPrev:Node = findNode(z-1)
    var nz:Node = nzPrev.next;
    //Ищем ноду q
    if(qq>0)
    {
      nqPrev=findNode(q-1)
      nq = nqPrev.next
      nqPrev.next=nz
    }
    else
      nq=findNode(q)
    var buf:Node = head;
    if(zz-qq == 1)
      buf=nq
    else
      buf=nq.next
    nq.next = nz.next
    nz.next = buf
    if(zz-qq > 1)
      nzPrev.next = nq
    //Если переставляли первый или последний элементы
    if(qq==0)
      head = nz
    if(zz==size-1)
      tail=nq

    true
  }

  private def quickSort(low:Int, high:Int):Boolean=
  {
    if(size==0)
      return false;
    if(low >= high)
      return false;

    //Средний элемент
    var middle:Int = low + (high-low)/2;
    var opora = find(middle)

    //Деление СД на 2 подмножества
    var i:Int = low
    var j:Int = high
    while(i<=j)
    {
      while(comparator.compare(find(i),opora)== -1)
        i=i+1

      while(comparator.compare(find(j),opora)== 1)
        j=j-1

      if(i<=j)
      {
        swap(i,j)
        i+=1
        j-=1
      }
    }
    //Рекурсивная сортировка левого и правого подмножеств
    if(low<j)
      quickSort(low,j);
    if(high>i)
      quickSort(i,high)
    true;
  }

  private def quickSort(list:TList):TList=
  {
    if(list== null)
      return list;
    var head_ = list.head
    var it = head_.next
    if(it==null)
      return list;
    var lesser:TList = null
    var greater:TList = null
    while (it !=null)
    {
      var comp:Int = comparator.compare(it.data,head_.data)
      if(comp<0 || comp==0)
      {
        if(lesser==null)
          lesser = new TList(builder)
        lesser.pushEnd(it.data)
      }
      else
      {
        if(greater==null)
          greater = new TList(builder)
        greater.pushEnd(it.data)
      }
      it = it.next
    }

    lesser = quickSort(lesser)
    greater = quickSort(greater)

    var buf:TList = new TList(builder)
    buf.pushEnd(head_.data)
    buf.pushEndd(greater)
    if(lesser==null)
      return buf
    lesser.pushEndd(buf)
    lesser
  }

  def forEach(vall:DoIt) = {
    var i:Int = 0
    var cur:Node = head
    while (i < size)
    {
      vall.doIt(cur.data)
      cur = cur.next
      i += 1
    }
  }

  def getSize:Int = size

  def clear():Boolean=
  {
    if (head == null)
      return false

    while (head != null) delete(0)
    true
  }
}
