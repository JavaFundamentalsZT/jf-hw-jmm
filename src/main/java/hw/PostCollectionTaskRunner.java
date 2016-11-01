package hw;

public interface PostCollectionTaskRunner {

  void register(Object o, Runnable task);

  void shutdown() throws Exception;
}