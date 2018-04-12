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
        df.convert(String.class);
        System.out.println(df.toString());
        df.writeCsv("src/test/resources/test/joinery/order_duplicate.csv");
    }

    @Test
    public void test02() throws IOException {
        // 测试读取Excel
        DataFrame df = DataFrame.readXls("src/test/resources/test/joinery/order.xls");
        df.convert(String.class,String.class,String.class,String.class,String.class,String.class);
        System.out.println(df.toString());
        df.writeXls("src/test/resources/test/joinery/order_duplicate.xls");
    }
}
