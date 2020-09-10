package amf.benchmark

import org.openjdk.jmh.annotations.{Measurement, Warmup}

@Warmup(iterations = 20, batchSize = 300000)
@Measurement(iterations = 50, batchSize = 300000)
class MediumRepetitionMediumBenchmark extends AbstractHashMapUpdateBenchmark {

  override protected val repetitionFactor: Int = 500
  override protected val fixtureSize: Int = 300000
}
