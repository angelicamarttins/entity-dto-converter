package com.examples.entitydtoconverter;

import com.examples.entitydtoconverter.converters.UserMapper;
import com.examples.entitydtoconverter.dto.UserDtoBuilder;
import com.examples.entitydtoconverter.model.UserEntity;
import java.util.concurrent.TimeUnit;
import org.mapstruct.factory.Mappers;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

@State(Scope.Thread)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class Bench {

  private UserDtoBuilder userDtoBuilder;

  private UserMapper userMapper;

  private UserEntity userEntity;

  @Setup(Level.Iteration)
  public void setup() {
    userDtoBuilder = new UserDtoBuilder();
    userMapper = Mappers.getMapper(UserMapper.class);
    userEntity = new UserEntity("Angélica", 33);
  }

  @Benchmark
  public void benchmarkBuilderDtoBatch(Blackhole blackhole) {
    for (int i = 0; i < 1000; i++) {
      blackhole.consume(userDtoBuilder.toDto(userEntity));
    }
  }

  @Benchmark
  public void benchmarkMapstructDtoBatch(Blackhole blackhole) {
    for (int i = 0; i < 1000; i++) {
      blackhole.consume(userMapper.toDto(userEntity));
    }
  }

  public static void main(String[] args) throws RunnerException {
    Options opt = new OptionsBuilder()
      .include(Bench.class.getSimpleName())
      .forks(2)
      .warmupIterations(10)
      .measurementIterations(10)
      .warmupTime(TimeValue.seconds(1))
      .measurementTime(TimeValue.seconds(1))
      .build();

    new Runner(opt).run();
  }

}
