import com.zman.monotonic.timestamp.Timestamp;
import org.junit.Test;

import java.util.Date;

public class TimestampTest {

    @Test
    public void timestamp(){
        System.out.println( "max time: " + new Date(Long.MAX_VALUE >> 18) );
        System.out.println( "max produce number in 1 millisecond:" + (1 << 18) );

        System.out.println(System.currentTimeMillis());

        long prev = 0;
        for(int i =0; i < 1_000_000; i ++ ){
            long timestamp = Timestamp.uniq();
            if( prev >= timestamp ){

                System.out.println(Timestamp.decode(prev));
                System.out.println(Timestamp.decode(timestamp));

                System.out.println(prev);
                System.out.println(timestamp);

                System.out.println(i);

                throw new RuntimeException("fail");
            }
            prev = timestamp;
        }

        Timestamp.decode(prev);
    }

}
