package reflect.states;

import java.lang.reflect.Field;
import java.util.Scanner;

public class Main {
    static class Statistic {
        private int id;
        private String test;

        public void setId(int id) {
            this.id += id;
        }

        public void setTest(String test) {
            this.test = test;
        }

        public int getId() {
            return id;
        }
    }
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Field field = Statistic.class.getDeclaredField("id");
        Statistic statistic = new Statistic();
        field.set(statistic, 5);
        System.out.println(field.get(statistic));
    }
}
