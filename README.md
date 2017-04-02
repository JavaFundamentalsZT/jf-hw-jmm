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
 * Use file: gclog.log for the gc log
 * Use file: gcomments.txt for the comments about the garbage collection

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
* **Don't use System.gc**! It is evil and will mess up your app performance.
  Code will be tested with -XX:+DisableExplicitGC

Happy hacking! If you have any questions or the assignment is unclear, feel free to send us
questions before the submission deadline!

Submitting your assignment
--------------------------

When you have gotten the test passing and the build to succeed, you can submit your assignment by first running the following command in the homework root folder:

```shell
./mvnw clean deploy
```

It will ask you for your **full name**, **Student Code** (also known as *matrikli number*) and a **comment** *(optional)*.

Example:

```shell
./mvnw clean deploy

#...skipping building, testing and packaging output from Maven...

[INFO] --- maven-antrun-plugin:1.7:run (package homework ZIP) ---
[INFO] Executing tasks

main:
Your full name (e.g. John Smith):
Jane Smith
Your Student Code (matrikli number, e.g. ABCD012345):
ABCD012345
Comment:
Java IO
      [zip] Building zip: /Users/lanza/Projects/java/jf/jf-homeworkX/target/jf-howeworkX-ABCD012345.zip
   [delete] Deleting: /Users/lanza/Projects/java/jf/jf-homeworkX/homework.properties
[INFO] Executed tasks
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 45.028s
[INFO] Finished at: Thu Aug 28 15:36:19 EEST 2014
[INFO] Final Memory: 17M/99M
[INFO] ------------------------------------------------------------------------
```

After Maven has finished and the build was successful, you can find a **ZIP file** at **target/jf-homeworkX-ABCD012345.zip** *(the name of the zip file contains the homework number and your Student Code/matrikli number)*.

This ZIP file contains all the files that we need to check your homework.
The only thing left to do now is to send the ZIP file as an attachment to an e-mail with subject **"Homework X - *your Student Code/maktrikli number*"** to *jf@zeroturnaround.com*.