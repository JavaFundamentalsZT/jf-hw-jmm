package org.zeroturnaround.jf.hw;

public class Application {

  public static void main(String[] args) throws Exception {
    PostCollectionTaskRunner runner = new PostCollectionTaskRunnerImpl();
    try {
      Object soonToBeGarbage = new Object();
      runner.register(soonToBeGarbage, () -> System.out.println("task1 executed"));
      runner.register(soonToBeGarbage, () -> System.out.println("task2 executed"));
      soonToBeGarbage = null;
      causeGarbageCollection();
    } finally {
      runner.shutdown();
    }
  }

  private static void causeGarbageCollection() {
    // TODO
  }
}
