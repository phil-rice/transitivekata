package org.inverthepyamid.transitive

import scala.io.Source
import MapOps._

object  FileLoader extends App{


  def add(m: Map[String, Set[String]], s: String) = {
    s.split(" ").toList match {
      case Nil => m
      case head :: tail => tail.foldLeft(m)((m, v) => m.add(head, v));
    }
  }

  val x = Source.fromInputStream(getClass.getClassLoader.getResourceAsStream("transitive.txt")).getLines().foldLeft(Map[String, Set[String]]())(add)

  println (x.isChild("Human", "Jackel"))
  println (x.isChild("Animal", "Jackel"))
  println (x.isChild("Animal", "Canine"))
}
