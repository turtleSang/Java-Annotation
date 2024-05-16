import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DemoAnnotation {
    public static void main(String arg[]) throws InvocationTargetException, IllegalAccessException {
        Turtle turtle = new Turtle("Sang turtle");
        Fish fish = new Fish();
        if (fish.getClass().isAnnotationPresent(SimpleAnnotation.class)){
            System.out.println("is mark by annotation");
        }else {
            System.out.println("not mark by annotation");
        }
        int times = 0;

        for (Method method: turtle.getClass().getMethods()){
            if (method.isAnnotationPresent(MethodAnnotation.class)){
                System.out.println(method.getName() + " is mark by " + MethodAnnotation.class.getName());
                MethodAnnotation annotation = method.getAnnotation(MethodAnnotation.class);
                times = annotation.times();
                Class<?>[] parameterTypes = method.getParameterTypes();
                for (int i = 0; i < times; i++) {
                    if (parameterTypes.length == 0){
                        method.invoke(turtle);
                    }else {
                        method.invoke(turtle, "Fish");
                    }
                }
            }
        }

        for (Field field: turtle.getClass().getFields()){
            String name = field.getName();
            if (field.isAnnotationPresent(FieldAnnotation.class)){
                FieldAnnotation annotation = field.getAnnotation(FieldAnnotation.class);
                String tableName = annotation.table();
                Object o = field.get(turtle);
                if (o instanceof String ){
                    String hehe = o.toString();
                    System.out.println(hehe);
                }
            }
        }
    }
}
