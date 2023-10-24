package ua.nalezhytyi.moduleFirst;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class ModuleFirstTheFirstTask {
    //11 Найти количество различных элементов массива. Пример:
    // для 1 4 5 1 1 3 ответ 4. *Создать метод, который
    // принимает массив и возвращает количество  различных  элементов.
    public static void main(String[] args) {
        int[] array = new int[3];
        fillArray(array);
        int calcUniqueNum = calcUniqueNumbers(array);
        System.out.println(Arrays.toString(array));
        System.out.println("Унікальних цифр : " + calcUniqueNum);
    }

    public static int calcUniqueNumbers(int[] array) {
        int calcUniqueNum = 1;
        int numbersOfArrayForCycle = array[0];
        if(array.length == 0) return 0;
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            boolean isUniqueNumInArray = true;
            for (int j = 0; j < i; j++) {
                if(current == array[j]){
                    isUniqueNumInArray = false;
                    continue;
                }
            }
            if(isUniqueNumInArray){
                calcUniqueNum++;
            }
        }
        return calcUniqueNum;
    }

    public static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(1, 10);
        }
    }
}
