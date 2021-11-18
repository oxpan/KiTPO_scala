package git.group.Builder

import git.group.Comaparator.Comparator

trait Builder
{
  def createObject():Any
  // чтение из потока
  def parseObject(str: String):Any
  def getComparator: Comparator
  def getName: String
}
