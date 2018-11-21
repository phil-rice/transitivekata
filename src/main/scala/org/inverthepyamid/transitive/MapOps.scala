package org.inverthepyamid.transitive

object MapOps extends MapOps

trait MapOps {

  implicit class MapSetOps[K, V](map: Map[K, Set[V]]) {
    def add(k: K, v: V): Map[K, Set[V]] =
      map + (k -> (map.getOrElse(k, Set()) + v))
  }

  implicit class MapSameSet[T](map: Map[T, Set[T]]) {
    def isChild(parent: T, child: T): Boolean =
      if (map.contains(child)) true else map.getOrElse(parent, Set()).exists(c => isChild(c, child))
  }

}
