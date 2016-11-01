Java Fundamentals - Java Memory Model Homework
===========

Description
----------

Use PhantomReferences to write a finalize() replacement. The user can 
register several cleanup tasks for any object. Your PostCollectionTaskRunner 
starts a thread that runs cleanup tasks in the background. 

Keep in mind
----------

* Run with ParallelGC (Java8 default). 
* Enable detailed GC logging. Cause a Full GC.  
* Submit the GC log + following comments: 
 * for one minor collection: time since last collection and bytes freed for young gen
 * for one Full GC: bytes freed for young gen, old gen, total heap size
* Use max heap size 64M
* Also submit code for triggering Full GC
* Phantom references are expensive - use 1 per managed object
* Don’t keep stuff for dead objects
* Write reasonably efficient code: no Thread#sleep, crazy list iterations, etc.
* shutdown() -> stop thread, clear data

Happy hacking!

Submitting Homework
-------------------

Issue a `mvn clean` and then ZIP the folder and send it to jf@zeroturnaround.com
