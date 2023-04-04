package com.company;

import org.apache.commons.lang3.StringUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Dm.Petrov
 * DATE: 30.03.2023
 */
public class CompareStringApp {
    public void compareString(List<String> listOne, List<String> listTwo) {
        Map<String, String> resultMap = new HashMap<>();
        double max = 0;
        int ind = 0;
        for (String s : listOne) {
            for (int j = 0; j < listTwo.size(); j++) {
                if (findSimilarity(s, listTwo.get(j)) > max) {
                    max = findSimilarity(s, listTwo.get(j));
                    ind = j;
                }
            }
            resultMap.put(s, listTwo.get(ind));
            listTwo.remove(listTwo.get(ind));
            max = 0.0;
            ind = 0;
        }

        for (String s : listTwo) {
            resultMap.put(s, " ?");
        }

        for (Map.Entry entry : resultMap.entrySet()
        ) {
            try (FileWriter writer = new FileWriter("output.txt", true)) {
                writer.write(entry.getKey() + " : " + entry.getValue());
                writer.append('\n');
                writer.flush();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static double findSimilarity(String x, String y) {
        if (x == null && y == null) {
            return 1.0;
        }
        if (x == null || y == null) {
            return 0.0;
        }
        return StringUtils.getJaroWinklerDistance(x, y);
    }
}

