package amf.benchmark

import org.openjdk.jmh.annotations.{Measurement, Warmup}

@Warmup(iterations = 20, batchSize = 1000000)
@Measurement(iterations = 50, batchSize = 1000000)
class NoRepetitionBigBenchmark extends AbstractHashMapUpdateBenchmark {

  override protected val repetitionFactor: Int = 1
  override protected val fixtureSize: Int = 1000000
}
