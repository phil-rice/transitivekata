package org.invertthepyramid.transitive

import org.inverthepyamid.transitive.MapOps
import org.scalatest.{FlatSpec, Matchers}

class TransitiveTest extends FlatSpec with Matchers with MapOps {


  behavior of "map ops"

  val ontology = Map(
    "entity" -> Set("animal"),
    "animal" -> Set("primate", "feline"),
    "feline"-> Set("cat"),
    "primate" -> Set("human", "monkey"))

  it should "have a 'isChild' method without transitives" in {
    ontology.isChild("entity", "animal") shouldBe true
    ontology.isChild("animal", "entity") shouldBe false
    ontology.isChild("junk", "entity") shouldBe false
    ontology.isChild("entity", "junk") shouldBe false
  }
  it should "have a 'isChild' method with transitives" in {
    ontology.isChild("entity", "primate") shouldBe true
    ontology.isChild("entity", "human") shouldBe true
    ontology.isChild("animal", "dog") shouldBe false
  }

  it should "have " in {
    ontology.children("primate") shouldBe Set("human", "monkey")
    ontology.children("feline") shouldBe Set( "cat")
  }

}
