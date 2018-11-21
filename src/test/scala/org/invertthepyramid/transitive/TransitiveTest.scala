package org.invertthepyramid.transitive

import org.inverthepyamid.transitive.MapOps
import org.scalatest.{FlatSpec, Matchers}

class TransitiveTest extends FlatSpec with Matchers with MapOps {


  behavior of "map ops"

  val entityAnimalPrimateHuman = Map("entity" -> Set("animal"), "animal" -> Set("primate"), "primate" -> Set("human"))

  it should "have a 'isChild' method without transitives" in {
    entityAnimalPrimateHuman.isChild("entity", "animal") shouldBe true
    entityAnimalPrimateHuman.isChild("animal", "entity") shouldBe false
    entityAnimalPrimateHuman.isChild("junk", "entity") shouldBe false
    entityAnimalPrimateHuman.isChild("entity", "junk") shouldBe false

  }
  it should "have a 'isChild' method with transitives" in {
    entityAnimalPrimateHuman.isChild("entity", "primate") shouldBe true
    entityAnimalPrimateHuman.isChild("entity", "human") shouldBe true
    entityAnimalPrimateHuman.isChild("animal", "dog") shouldBe false

  }

}
