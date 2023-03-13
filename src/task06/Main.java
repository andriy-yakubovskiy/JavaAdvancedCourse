/*
Annotation
Create your own annotation that will contain the parameters for the method and perform the addition of two numbers.
@Math(num1 = 100, num2 = 200)
public void mathSum(int num1, int num2)
Add other mathematical methods.
*/
package task06;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    @Math(num1 = 100, num2 = 200)
    public void mathSum(int num1, int num2) {
        int sum = num1 + num2;
        System.out.println(sum + "=" + num1 + "+" + num2);
    }

    @Math(num1 = 700, num2 = 300)
    public void mathSub(int num1, int num2) {
        int sum = num1 - num2;
        System.out.println(sum + "=" + num1 + "-" + num2);
    }

    @Math(num1 = 400, num2 = 600)
    public void mulSub(int num1, int num2) {
        int sum = num1 * num2;
        System.out.println(sum + "=" + num1 + "*" + num2);
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        Main mainClass = new Main();
        Class<Math> annotationMath = Math.class;
        Method[] methods = Main.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(annotationMath)) {
                Math foundAnnotationMath = method.getAnnotation(annotationMath);
                if (foundAnnotationMath != null)
                    method.invoke(mainClass, foundAnnotationMath.num1(), foundAnnotationMath.num2());
            }
        }
    }

}