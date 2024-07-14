package com.mr3nz1.productManagementSystem.utils;

import java.lang.reflect.Field;

public class NullChecker {
    public static boolean check(Object object) {
        if (object == null) {
            return true;
        }

        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (field.getName().equals("id")) {
                    System.out.println("Equals the id");
                    continue;
                }
                if (field.get(object) == null) {
                    System.out.println(field.getName());
                    return true;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
