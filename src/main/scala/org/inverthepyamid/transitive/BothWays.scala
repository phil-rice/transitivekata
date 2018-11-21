package org.inverthepyamid.transitive
import MapOps._
case class BothWays[T](parents: Map[T, Set[T]], children:Map[T, Set[T]]) {
  def isChild(parent: T, child: T)= children.isChild(parent, child)
}
