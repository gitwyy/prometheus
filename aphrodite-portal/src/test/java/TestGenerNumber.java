import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import java.util.UUID;

/**
 * @ClassName:TestGenerNumber
 * @Author: yangyang.wang
 * @Date: 2018-04-20 17:12
 * @Version: 1.0
 * @Description: TODO
 **/
public class TestGenerNumber {

    @Test
    public void testGenerNumber(){
        System.out.println(UUID.randomUUID().toString());
        System.out.println(UUID.randomUUID().getLeastSignificantBits());
        System.out.println(UUID.randomUUID().getMostSignificantBits());
        System.out.println(RandomUtils.nextLong());
    }
}
