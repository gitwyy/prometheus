import com.pay.aphrodite.portal.hql.processor.SqlProcessContext;
import com.pay.aphrodite.portal.hql.processor.SqlProcessor;
import com.pay.aphrodite.portal.hql.processor.builder.SqlProcessBuilder;
import com.pay.aphrodite.portal.hql.processor.builder.SqlProcessContextBuilder;
import com.pay.aphrodite.portal.hql.processor.impl.MySelectProcessor;
import org.junit.Test;

/**
 * @ClassName:TestMySelectProcessor
 * @Author: yangyang.wang
 * @Date: 2018-04-16 19:47
 * @Version: 1.0
 * @Description: 测试MySelectProcessor
 **/
public class TestMySelectProcessor {

    @Test
    public void testMySelectProcessor(){
        SqlProcessContext processContext = SqlProcessContextBuilder.builder();

        SqlProcessor processor = SqlProcessBuilder.builder(SqlProcessBuilder.SELECT);

        processContext.setSqlProcessor(processor);

        String sql = processor.process(processContext);
        System.out.println(sql);
    }
}
