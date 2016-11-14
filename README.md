# Java Fundamentals - Java Memory Model Homework

## Description

Use PhantomReferences to write a finalize() replacement. The user can 
register several cleanup tasks for any object. Your PostCollectionTaskRunner 
starts a thread that runs cleanup tasks in the background. 

## Requirements

### Use garbage collection logging

* Run with ParallelGC (Java8 default)
* Enable detailed GC logging
* Use max heap size 64M
* Make sure your application causes one Full GC. Submit the code for triggering Full GC
* Submit the GC log + following comments:
 * for one minor collection: time since last collection and bytes freed for young gen
 * for one Full GC: bytes freed for young gen, old gen, total heap size

### Code must be efficient

* Phantom references are expensive - use 1 per managed object
* Don’t keep map entries or cleanup task references for dead objects
* Write reasonably efficient code. Common mistakes:
 * don't use Thread#sleep
 * don't scan the entire list/map to find stuff, use suitable map keys
 * don't write busy loops that use 100% CPU
* shutdown() should stop the background thread and clear any data structures

### Misc

* Code must be thread safe: register() and shutdown() will be called concurrently from different threads
* Assume the test application creates several PostCollectionTaskRunner instances and
  register thousands of cleanup tasks for thousands of different objects
* Assume the test application runs for weeks and PostCollectionTaskRunner instances will be
  created and shut down at random times
* Don't trust the cleanup tasks. They can throw exceptions, call register/shutdown etc.
* Don't use System.gc! It is evil and will mess up your app performance.
  Code will be tested with -XX:+DisableExplicitGC

Happy hacking! If you have any questions or the assignment is unclear, feel free to send us
questions before the submission deadline!

## Submitting Homework

Issue a `mvn clean` and then ZIP the folder and send it to jf@zeroturnaround.com
