package amf.benchmark

import java.util.UUID

object TestHelper {

  case class TestFixture(key: String, value: Any)

  def createTestFixtures(size: Int, repetitionFactor: Int) = {
    val keys = (1 to size/repetitionFactor).map(_ => UUID.randomUUID().toString)
    println(s"Distinct keys generated: ${keys.toSet.size}")
    (1 to size).map(i => TestFixture(keys(i % keys.size), UUID.randomUUID()))
  }
}
