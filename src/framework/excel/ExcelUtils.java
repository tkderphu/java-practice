package framework.excel;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class ExcelUtils {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Student student = new Student();
        student.setFullName("nguyen quang phu");
        student.setUsername("b22dccn621");
        Subject subject = new Subject();
        subject.setCredit(3);
        subject.setName("Lap trinh huong doi tuong");
        Score score = new Score();
        score.setSubject(subject);

        List<ScoringEachComponent> scoringEachComponents = new ArrayList<>();
        scoringEachComponents.add(new ScoringEachComponent(ScoringType.ATTENDANCE.name(), 10));
        scoringEachComponents.add(new ScoringEachComponent(ScoringType.FINAL.name(), 9));
        scoringEachComponents.add(new ScoringEachComponent(ScoringType.MIDTERM.name(), 7));

        score.setScoringEachComponents(scoringEachComponents);

        student.setScore(score);

        Map<String, String> result = extractColumn(Student.class, student);
        for(Map.Entry entry : result.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    static  Map<String, String> extractColumn(Class clazz, Object t) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Map<String, String> res = new HashMap<>();
        Field[] field = clazz.getDeclaredFields();
        for(Field f : field) {
            ExcelProperties excelProperties = f.getDeclaredAnnotation(ExcelProperties.class);
            String name = Character.toUpperCase(f.getName().charAt(0)) + f.getName().substring(1);
            Method declaredMethod = clazz.getDeclaredMethod("get" + name);
            Object invoke = declaredMethod.invoke(t);
            if(excelProperties != null) {
                if(excelProperties.type() == PropertiesType.LIST) {
                    Map<String, String> vlz = new HashMap<>();
                    List list = new ArrayList((Collection)invoke);
                    for(Object item : list) {
                        Map<String, String> subVlz = extractColumn(excelProperties.isDefined(), item);
                        if(!subVlz.isEmpty()) {
                            subVlz.entrySet().forEach(entry -> {

                            });
                        }
                    }
                }
                else if(!excelProperties.isDefined().equals(Object.class)) {
                    Map<String, String> recursion = extractColumn(excelProperties.isDefined(), invoke);
                    res.putAll(recursion);
                } else {
                    res.put(excelProperties.name(), String.valueOf(invoke));
                }
            }
        }
        return res;
    }



}
