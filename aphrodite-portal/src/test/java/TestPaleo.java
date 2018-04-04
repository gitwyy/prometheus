import ch.netzwerg.paleo.*;
import ch.netzwerg.paleo.io.Parser;
import io.vavr.collection.IndexedSeq;
import io.vavr.collection.Set;
import org.junit.Test;

import java.io.StringReader;
import java.util.stream.DoubleStream;

/**
 * @ClassName:TestPaleo
 * @Author: yangyang.wang
 * @Date: 2018-04-04 14:08
 * @Version: 1.0
 * @Description: 测试类
 **/
public class TestPaleo {
    @Test
    public void test01() {
        // Type-safe column identifiers
        final ColumnIds.StringColumnId NAME = ColumnIds.StringColumnId.of("Name");
        final ColumnIds.CategoryColumnId COLOR = ColumnIds.CategoryColumnId.of("Color");
        final ColumnIds.DoubleColumnId SERVING_SIZE = ColumnIds.DoubleColumnId.of("Serving Size (g)");

        // Convenient column creation
        StringColumn nameColumn = StringColumn.ofAll(NAME, "Banana", "Blueberry", "Lemon", "Apple");
        CategoryColumn colorColumn = CategoryColumn.ofAll(COLOR, "Yellow", "Blue", "Yellow", "Green");
        DoubleColumn servingSizeColumn = DoubleColumn.ofAll(SERVING_SIZE, 118, 148, 83, 182);

        // Grouping columns into a data frame
        DataFrame dataFrame = DataFrame.ofAll(nameColumn, colorColumn, servingSizeColumn);

        // Typed random access to individual values (based on rowIndex / columnId)
        String lemon = dataFrame.getValueAt(2, NAME);
        double appleServingSize = dataFrame.getValueAt(3, SERVING_SIZE);

        // Typed stream-based access to all values
        DoubleStream servingSizes = servingSizeColumn.valueStream();
        double maxServingSize = servingSizes.summaryStatistics().getMax();
        // Smart column implementations
        Set<String> colors = colorColumn.getCategories();
    }

    @Test
    public void test02(){
            final String EXAMPLE =
                "Name\tColor\tServing Size (g)\n" +
                        "String\tCategory\tDouble\n" +
                        "Banana\tYellow\t118\n" +
                        "Blueberry\tBlue\t148\n" +
                        "Lemon\tYellow\t83\n" +
                        "Apple\tGreen\t182";

        DataFrame dataFrame = Parser.tsv(new StringReader(EXAMPLE));
        System.out.println(dataFrame);
    }


    @Test
    public void test03(){
        final String EXAMPLE =
                "Name\tColor\tServing Size (g)\n" +
                        "String\tCategory\tDouble\n" +
                        "Banana\tYellow\t118\n" +
                        "Blueberry\tBlue\t148\n" +
                        "Lemon\tYellow\t83\n" +
                        "Apple\tGreen\t182";

        DataFrame dataFrame = Parser.tsv(new StringReader(EXAMPLE));

        // Lookup typed identifiers by column index
        final ColumnIds.StringColumnId NAME = dataFrame.getColumnId(0, ColumnType.STRING);
        final ColumnIds.CategoryColumnId COLOR = dataFrame.getColumnId(1, ColumnType.CATEGORY);
        final ColumnIds.DoubleColumnId SERVING_SIZE = dataFrame.getColumnId(2, ColumnType.DOUBLE);

        // Use identifier to access columns & values
        StringColumn nameColumn = dataFrame.getColumn(NAME);
        IndexedSeq<String> nameValues = nameColumn.getValues();

        // ... or access individual values via row index / column id
        String yellow = dataFrame.getValueAt(2, COLOR);
    }

    @Test
    public void test04(){

    }
}
