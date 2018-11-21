package org.inverthepyamid.transitive

object MapOps extends MapOps
trait MapOps {

  implicit class MapSetOps[K, V](map: Map[K, Set[V]]) {
    def add(k: K, v: V): Map[K, Set[V]] = map + (k -> (map.getOrElse(k, Set()) + v))
  }

  implicit class MapSameSet[T](map: Map[T, Set[T]]) {
    def isChild(parent: T, child: T): Boolean = map.get(parent).fold(false)(children => children.contains(child) || children.exists(isChild(_, child)))
    def children(parent: T): Set[T] = map.get(parent).fold(Set(parent))(c => c.flatMap(children))
  }

}
