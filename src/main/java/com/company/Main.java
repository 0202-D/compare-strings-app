package com.company;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<String> listOne = new ArrayList<>();
        List<String> listTwo = new ArrayList<>();
        try {
            String fileName = "/IdeaProjects//compare-strings-app/input.txt";
            Path patn = Paths.get(fileName);
            Scanner sc = new Scanner(patn);
            sc.useDelimiter(System.getProperty("line.separator"));
            while (sc.hasNext()) {
                int one = sc.nextInt();
                sc.nextLine();

                for (int i = 0; i < one; i++) {
                    listOne.add(sc.nextLine());
                }
                int two = sc.nextInt();
                sc.nextLine();

                for (int i = 0; i < two; i++) {
                    listTwo.add(sc.nextLine());
                }
                if (one > two) {
                    List<String> temp = listOne;
                    listOne = listTwo;
                    listTwo = temp;
                }

            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        CompareStringApp compareStringApp = new CompareStringApp();
        compareStringApp.compareString(listOne, listTwo);

    }
}