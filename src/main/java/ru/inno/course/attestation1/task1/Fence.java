package ru.inno.course.attestation1.task1;

import java.util.Scanner;

public class Fence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите длину вашего забора в сантиметрах: ");
        int userFenceLength = scanner.nextInt();
        String result = checkUserFence(userFenceLength);
        System.out.println(result);
    }

    public static String checkUserFence(int userFenceLength) {

        int loveLetterLength = 15 / 3 * 62 + 12 * 3; //346 см - длина текста у мальчика, 15 букв и три пробела
        if (userFenceLength <= 0) {
            return "Таких заборов не бывает, попробуйте еще раз";
        } else {
            if (userFenceLength >= loveLetterLength) {
                return "Признанение поместиться на вашем заборе";
            } else {
                return "Забор слишком короткий";
            }
        }
    }
}
