package amf.benchmark

import java.util.concurrent.TimeUnit

import amf.benchmark.TestHelper._
import org.openjdk.jmh.annotations._
import org.openjdk.jmh.infra.Blackhole

import scala.collection.mutable
import scala.util.Random

@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.SECONDS)
@BenchmarkMode(Array(Mode.SingleShotTime))
@Fork(3)
abstract class AbstractHashMapUpdateBenchmark {

  private var testData = List[TestFixture]()
  private var testIterator = Iterator[TestFixture]()
  private val linkedHashMap = mutable.LinkedHashMap[String, Any]()
  private val normalHashMap = mutable.HashMap[String, Any]()
  protected val repetitionFactor: Int
  protected val fixtureSize: Int

  @Benchmark
  def measureHashMap(blackhole: Blackhole): Unit = {
    runTest(linkedHashMap, blackhole)
  }

  @Benchmark
  def measureLinkedHashMap(blackhole: Blackhole): Unit = {
    runTest(normalHashMap, blackhole)
  }

  private def runTest(map: mutable.Map[String, Any], blackhole: Blackhole): Unit = {
    val fixture = testIterator.next()
    blackhole.consume(map.put(fixture.key, fixture.value))
  }

  @Setup(Level.Iteration)
  def setup(): Unit = {
    if (testData.isEmpty) testData = Random.shuffle(createTestFixtures(fixtureSize, repetitionFactor = repetitionFactor)).toList
    testIterator = testData.iterator
  }

  @TearDown(Level.Iteration)
  def tearDown(): Unit = {
//    print(s"Linked HashMap Size: ${linkedHashMap.size}")
    linkedHashMap.clear()
//    print(s"Normal HashMap Size: ${normalHashMap.size}")
    normalHashMap.clear()
  }
}