package git.group.Builder

import git.group.Comaparator.Comparator

trait Builder
{
  def createObject():Any
  def parseObject(str: String):Any
  def getComparator: Comparator
  def getName: String
}
