package org.inverthepyamid.transitive

import scala.io.Source
import MapOps._

trait FileLoader {
  def add(m: Map[String, Set[String]], s: String): Map[String, Set[String]] =
    s.split(" ").toList match {
      case Nil => m
      case head :: tail => tail.foldLeft(m)((acc, v) => acc.add(head, v));
    }


}
object  FileLoader extends App with FileLoader {


  val x = Source.fromInputStream(getClass.getClassLoader.getResourceAsStream("transitive.txt")).getLines().
    foldLeft(Map[String, Set[String]]())(add)

  println (x.isChild("Human", "Jackal"))
  println (x.isChild("Animal", "Jackal"))
  println (x.isChild("Animal", "Canine"))
  println (x.children("Animal"))
}
