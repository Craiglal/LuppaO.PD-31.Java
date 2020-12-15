package com.lab;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Main {
    public static void main(String[] args) throws IOException, IllegalAccessException {
        //Task 1
        //multiplyFromAnnotation();

        //Task 2
        TextContainer textContainer = new TextContainer("hello there");

        System.out.println(textContainer.text);
        textContainer.save();
        textContainer.text = "There hello";
        textContainer.load();
        System.out.println(textContainer.text);

        textContainer.text = "There hello";
        textContainer.save();
        textContainer.load();
        System.out.println(textContainer.text);
    }

    static void multiplyFromAnnotation(){
        for (Method m : Main.class.getDeclaredMethods()){
            if (m.isAnnotationPresent(TwoIntegerMethod.class)) {
                TwoIntegerMethod an = m.getAnnotation(TwoIntegerMethod.class);
                try {
                    Main main = new Main();
                    m.invoke(main, an.one(), an.two());
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @TwoIntegerMethod(one = 3, two = 10)
    void multiply(int one, int two) {
        System.out.println(one * two);
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface TwoIntegerMethod {
        int one();
        int two();
    }
}


