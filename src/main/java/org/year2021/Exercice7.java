package org.year2021;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Exercice7 {
    private static final Log log = LogFactory.getLog(Exercice7.class);

    public static void main(String[] args) throws IOException {

        List<Integer> listPosition = parseFile("src/main/resources/year2021/Exercice7");
        int position = 0;

        if (listPosition.size() % 2 == 0){
            int min = listPosition.get(listPosition.size() / 2);
            int max = listPosition.get(listPosition.size() / 2 + 1);
            position = (min + max) / 2;
        }
        else {
            position = listPosition.get(listPosition.size() / 2);
        }

        int count = 0;
        int test = 0;
        for (Integer integer : listPosition) {
            test = test + consFuel(integer, position);
            if (integer >= position) {
                count = count + (integer - position);
            } else {
                count = count + (position - integer);
            }
        }
        log.info("Résultat = " + count);
        log.info("Résultat Fuel = " + test);
    }

    public static int consFuel(int value, int position) {
        int fuel = 0;
        int step = 1;
        if (value >= position) {
            for (int i = 0; i < value - position; i++){
                fuel = fuel + step;
                step++;
            }
        } else {
            for (int i = 0; i < position - value; i++){
                fuel = fuel + step;
                step++;
            }
        }
        log.info("Value : " + value + " position : " + position + "FUEL : " + fuel);
        return fuel;
    }

    public static List<Integer> parseFile(String filePath) throws IOException {
        List<String> list;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        list = List.of(bufferedReader.readLine().split(","));
        return list.stream().map(Integer::parseInt).sorted().collect(Collectors.toList());
    }
}
