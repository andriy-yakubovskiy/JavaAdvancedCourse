/*
Write a program that will display all the information about a class,
the user himself chooses which class he is interested in.
*/
package task05_02;

//import java.io.*;
//import java.lang.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import static java.lang.System.exit;

public class Main {

    public static String whatIsItClass(Class<?> metadataObj) {
        String itIs = "";

        if (metadataObj.isInterface()) {
            itIs = "Interface";
        } else if (metadataObj.isArray()) {
            itIs = "Array";
        } else if (metadataObj.isPrimitive()) {
            itIs = "Primitive";
        }

        return itIs;
    }

    public static ArrayList<String> getAllFieldsClass(Class<?> metadataObj) {
        ArrayList<String> listFields = new ArrayList<>();

        Field[] fields = metadataObj.getDeclaredFields();
        for (Field field : fields) {
            try {
                Class<?> fieldType = field.getType();
                String testMessage = "---Field (modifier=" + isModifierField(field.getModifiers()) + "): " + System.lineSeparator()
                        + "NAME=" + field.getName() + ",TYPE=" + fieldType.getName();
                listFields.add(testMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return listFields;
    }

    public static ArrayList<String> getAllMethodsClass(Class<?> metadataObj) {
        ArrayList<String> listMethods = new ArrayList<>();

        Method[] methods = metadataObj.getDeclaredMethods();
        for (Method method : methods) {
            try {
                String testMessage = "---Method (modifier=" + isModifierField(method.getModifiers()) + "): " + System.lineSeparator()
                        + "NAME=" + method.getName();
                listMethods.add(testMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return listMethods;
    }

    public static ArrayList<String> getAllConstructorClass(Class<?> metadataObj) {
        ArrayList<String> listConstructor = new ArrayList<>();

        Constructor<?>[] constructors = metadataObj.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            try {
                String testMessage = "---Constructor (modifier=" + isModifierField(constructor.getModifiers()) + "): " + System.lineSeparator()
                        + "NAME=" + constructor.getName();
                listConstructor.add(testMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return listConstructor;
    }

    public static String isModifierField(int thisModifier) {
        String testModifier;

        if (Modifier.isPublic(thisModifier)) { //(thisModifier == Modifier.PUBLIC) {
            testModifier = "PUBLIC";
        } else if (Modifier.isPrivate(thisModifier)) {//(thisModifier == Modifier.PRIVATE) {
            testModifier = "PRIVATE";
        } else if (Modifier.isProtected(thisModifier)) {//(thisModifier == Modifier.PROTECTED) {
            testModifier = "PROTECTED";
        } else {
            testModifier = "DEFAULT";
        }

        return testModifier;
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8), true);
            System.out.println("Select CLASS: ");
            pw.println("0-ESC(exit prog)");
            pw.println("1-House");
            pw.println("2-Road");
            pw.println("3-Vehicle");
            int c = 0;
            while (!((c >= 48) && (c <= 51))) {
                c = br.read();
            }
            char myClass = (char) c;
            pw.println("Your selected #" + myClass);
            if (myClass == '1') {
                Class<?> metadataClass = House.class;
                printInforms(metadataClass, pw);
            } else if (myClass == '2') {
                Class<?> metadataClass = Road.class;
                printInforms(metadataClass, pw);
            } else if (myClass == '3') {
                Class<?> metadataClass = Vehicle.class;
                printInforms(metadataClass, pw);
            } else {
                exit(0);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printInforms(Class<?> metadataClass, PrintWriter pw) {
        String itIs = whatIsItClass(metadataClass);
        ArrayList<String> fieldsClass = getAllFieldsClass(metadataClass);
        ArrayList<String> methodsClass = getAllMethodsClass(metadataClass);
        ArrayList<String> constructorsClass = getAllConstructorClass(metadataClass);

        pw.println("CLASS '" + metadataClass.getName() + "' (" + itIs + ")");
        pw.println("SUPER_CLASS '" + metadataClass.getSuperclass().getName());
        for (String tmp : fieldsClass) {
            pw.println(tmp);
        }
        for (String tmp : constructorsClass) {
            pw.println(tmp);
        }
        for (String tmp : methodsClass) {
            pw.println(tmp);
        }
    }
}