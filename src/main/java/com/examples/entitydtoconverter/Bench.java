package com.examples.entitydtoconverter;

import com.examples.entitydtoconverter.dto.UserDtoBuilder;
import com.examples.entitydtoconverter.model.UserEntity;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import lombok.AllArgsConstructor;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@State(Scope.Thread)
public class Bench {

  private UserDtoBuilder userDtoBuilder;

  @Setup
  public void setup() {
    userDtoBuilder = new UserDtoBuilder();
  }

  @Benchmark
  @BenchmarkMode(Mode.AverageTime)
  @OutputTimeUnit(TimeUnit.MICROSECONDS)
  public void testingBenchmark() {
    UserEntity userEntity = new UserEntity("Angélica", 33);
    userDtoBuilder.toDto(userEntity);
  }

  public static void main(String[] args) throws RunnerException {
    Options opt = new OptionsBuilder()
      .include(Bench.class.getSimpleName())
      .forks(1)
      .build();

    new Runner(opt).run();
  }

}
