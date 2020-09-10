package amf.benchmark

import org.openjdk.jmh.annotations.{Measurement, Warmup}

@Warmup(iterations = 20, batchSize = 30)
@Measurement(iterations = 50, batchSize = 30)
class BigRepetitionSmallBenchmark extends AbstractHashMapUpdateBenchmark {

  override protected val repetitionFactor: Int = 8
  override protected val fixtureSize: Int = 30
}
