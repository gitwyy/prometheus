import com.pay.aphrodite.portal.hql.compoment.SqlFromItem;
import jdk.nashorn.internal.runtime.arrays.IteratorAction;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.commons.collections4.ResettableIterator;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName:TestSorted
 * @Author: yangyang.wang
 * @Date: 2018-04-19 9:39
 * @Version: 1.0
 * @Description: TODO
 **/
public class TestSorted {

    @Test
    public void testLimitAndSkip() {
        List<Person> persons = new ArrayList();
        for (int i = 1; i <= 10000; i++) {
            Person person = new Person(i, "name" + i);
            persons.add(person);
        }
        List<String> personList2 = persons.stream().
                map(Person::getName).limit(10).skip(3).collect(Collectors.toList());
        System.out.println(personList2);
    }


    @Test
    public void testSorted() {
        List<Person> persons = new ArrayList();
        for (int i = 10; i > 0; i--) {

            Person person = new Person(i, "name" + i);

            person.setLeft("name" + (i - 1));
            person.setRight("name" + i);

            persons.add(person);

        }
        List<Person> personList2 = persons.stream().sorted((p1, p2) ->
                p1.getLeft().equals(p2.getRight()) ? 1 : -1
        ).limit(10).collect(Collectors.toList());
        System.out.println(personList2);
    }


    private class Person {
        public int no;
        private String name;

        private String left;

        private String right;

        public Person(int no, String name) {
            this.no = no;
            this.name = name;
        }

        public String getName() {
            System.out.println(name);
            return name;
        }


        public String getLeft() {
            System.out.println("left\t" +left);
            return left;
        }

        public Person setLeft(String left) {
            this.left = left;
            return this;
        }

        public String getRight() {
            System.out.println("right\t" + right);
            return right;
        }

        public Person setRight(String right) {
            this.right = right;
            return this;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", left='" + left + '\'' +
                    ", right='" + right + '\'' +
                    '}';
        }
    }

    @Test
    public void testIterator(){
        ResettableIterator<String> iterator = IteratorUtils.arrayIterator(new String[]{"aaa", "bbb","ccc"});

        iterator.forEachRemaining(System.out::println);

    }


}
