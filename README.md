Java Experiment
===============
A simple project for experimenting whatever Java stuff I come across.

Setting Paths
-------------
###Mac OS X
You need to have `JAVA_APPLICATION_STUB` path set when compiling. The file **JavaApplicationStub** is needed to start the Java Application (jar file) inside an App Bundle.
Note that directories will or may vary on different systems.

`export JAVA_APPLICATION_STUB="/System/Library/Frameworks/JavaVM.framework/Resources/MacOS/JavaApplicationStub"`

Compiling
---------
We use Maven to compile our source so you need to have it installed first before doing the command below.

In your project root, type:
`mvn clean package -DskipTests`

How to run
----------
###Mac OS X
Just look for **Java Experiment.app** from the **package** folder in your **project root** directory.