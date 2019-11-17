package com.zman.monotonic.timestamp;

/**
 * Monotonically increasing timestamp.
 * Since System.currentTimeMillis as ms, if you call it twice quickly, it's possible to get two identical time stamps.
 * This class fixes the problem!
 *
 * The Timestamp is so lightweight, you can create one Timestamp instance for each signal source.
 * But you only has one signal source, just use the static method {@link #timestamp()} directly.
 *
 * Timestamp can generate 262144 unique timestamp in one milli-second.
 * Max valid timestamp:  Fri Dec 12 20:41:28 CST 3084
 */
public class Timestamp {

    private final static Timestamp instance = new Timestamp();

    private int count;

    private long lastTimestamp;

    /**
     * generate a unique timestamp which is the real timestamp shifts left 18 bits plussing a counter.
     * @return unique adjusted timestamp
     */
    public long unique(){

        long timestamp = System.currentTimeMillis();
        long adjustTimestamp = timestamp << 18;

        if( timestamp == lastTimestamp ){

            adjustTimestamp += ++count;

        }else{
            count = 0;                  // reset the counter since timestamp changes
            lastTimestamp = timestamp;  // record the new timestamp
        }

        return adjustTimestamp;
    }

    /**
     * If your project just has one signal source, just use this static method directly.
     * This method is not thread-safe.
     * If you have multiple signal sources used by crossing threads, create one Timestamp instance for each signal source.
     * @return unique adjusted timestamp
     */
    public static long timestamp(){
        return instance.unique();
    }

    /**
     * convert the unique timestamp to real timestamp
     * @param uniqueTimestamp   adjusted timestamp
     * @return real timestamp
     */
    public static long realTimestamp(long uniqueTimestamp){
        return uniqueTimestamp >> 18;
    }

}
