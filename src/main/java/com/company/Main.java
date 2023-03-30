package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int one = sc.nextInt();
        sc.nextLine();
        List<String> listOne = new ArrayList<>();
        for (int i = 0; i < one; i++) {
            listOne.add(sc.nextLine());
        }
        int two = sc.nextInt();
        sc.nextLine();
        List<String> listTwo = new ArrayList<>();
        for (int i = 0; i < two; i++) {
            listTwo.add(sc.nextLine());
        }
        if (one > two) {
            List<String> temp = listOne;
            listOne = listTwo;
            listTwo = temp;
        }
        CompareStringApp compareStringApp = new CompareStringApp();
        compareStringApp.compareString(listOne, listTwo);

    }
}