import joinery.DataFrame;
import org.junit.Test;

import java.io.IOException;

/**
 * @ClassName:TestJoinery
 * @Author: yangyang.wang
 * @Date: 2018-04-04 16:00
 * @Version: 1.0
 * @Description: 测试 Joinery
 **/
public class TestJoinery {

    @Test
    public void test01() throws IOException {
        // 测试读取CSV
        DataFrame df = DataFrame.readCsv("src/test/resources/test/joinery/order.csv");
        System.out.println(df.toString());
    }

    @Test
    public void test02(){
        // 测试读取Excel

    }

    @Test
    public void test03(){
        // 测试写入CSV

    }

    @Test
    public void test04(){
        // 测试写入Excel

    }
}
