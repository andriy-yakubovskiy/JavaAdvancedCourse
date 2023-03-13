package task05;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Cat {
    public Animal animal;

    public Cat(String type, int age, String name, String nickname) {
        animal = new Animal(type, age, name, nickname);

        //Class metadataObj = Animal.class;
        ChangeModifierAccessToTrue(animal);
    }

    public void ChangeModifierAccessToTrue(Object sameObj) {

        Class<?> metadataObj = sameObj.getClass();

        Field[] fields = metadataObj.getDeclaredFields();
        for (Field field : fields) {
            int fieldModifier = field.getModifiers();
            if (fieldModifier != Modifier.PUBLIC) {

                // ON Access
                field.setAccessible(true);

                try {
                    // NEW value (for string)
                    Class<?> fieldType = field.getType();
                    if (fieldType.getName().equals("java.lang.String")) {
                        String oldValue = (String) field.get(sameObj);
                        String newValue = "no";

                        field.set(sameObj, newValue);

                        System.out.println("---Field (modifier=" + isModifierField(fieldModifier) + "): " + System.lineSeparator() +
                                "NAME=" + field.getName() + ",TYPE=" + fieldType.getName() + '\n' +
                                "OLD VALUE=" + oldValue + ",NEW VALUE=" + (String) field.get(sameObj));
                    }

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String isModifierField(int thisModifier) {
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
}