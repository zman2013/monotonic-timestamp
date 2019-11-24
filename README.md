[![Travis Build](https://api.travis-ci.org/zman2013/monotonic-timestamp.svg?branch=master)](https://api.travis-ci.org/zman2013/monotonic-timestamp.svg?branch=master)
[![Coverage Status](https://coveralls.io/repos/github/zman2013/monotonic-timestamp/badge.svg?branch=master)](https://coveralls.io/github/zman2013/monotonic-timestamp?branch=master)

# monotonic-timestamp
Monotonically increasing timestamp.  
Since `System.currentTimeMillis` as ms, if you call it twice quickly, it's possible to get two identical time stamps.  
This class fixes the problem!  
  
The Timestamp is so lightweight, you can create one Timestamp instance for each signal source.  
But you only has one signal source, just use the static method `Timestamp.timestamp()` directly.  
  
Timestamp can generate 262144 unique timestamp in one milli-second.  
Max valid timestamp:  Fri Dec 12 20:41:28 CST 3084  

## dependency
### gradle
```groovy
implementation "com.zmannotes:monotonic-timestamp:0.0.6"
```
### maven
```xml
<dependency>
    <groupId>com.zmannotes</groupId>
    <artifactId>monotonic-timestamp</artifactId>
    <version>0.0.5</version>
</dependency>
```
### How to use
```java
import com.zman.monotonic.timestamp.Timestamp;

...

long uniqueTimestamp = Timestamp.uniq();

```