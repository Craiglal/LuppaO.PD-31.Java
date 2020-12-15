package com.lab;

import java.io.*;
import java.lang.reflect.Field;

//Second task
@SaveTo(path = "e:\\text.txt")
public class TextContainer {
    @Save
    String text = "";

    public TextContainer(String text){
        this.text = text;
    }

    @Saver
    public void save() throws IOException, IllegalAccessException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(TextContainer.class.getAnnotation(SaveTo.class).path(),false));

        for (Field f : TextContainer.class.getDeclaredFields()){
            if (f.isAnnotationPresent(Save.class)) {
                objectOutputStream.writeObject(f.get(this));
            }
        }

        objectOutputStream.close();
    }

    public void load(){
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(TextContainer.class.getAnnotation(SaveTo.class).path()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            for (Field f : TextContainer.class.getDeclaredFields()) {
                if (f.isAnnotationPresent(Save.class)) {
                        f.set(this, objectInputStream.readObject());
                }
            }
        } catch (IllegalAccessException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        try {
            objectInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
