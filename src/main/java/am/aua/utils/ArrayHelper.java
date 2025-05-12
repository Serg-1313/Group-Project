package am.aua.utils;

import java.lang.reflect.Array;

public class ArrayHelper {
    public static <T> T[] copyArray(T[] array) {
        T[] copy = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length);

        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }

        return copy;
    }
}
