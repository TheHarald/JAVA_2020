package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Changer {

    private final String text;
    private int countRules;

    ArrayList<Rules> rules = new ArrayList<>();

    class Rules{
        String first,second;
        public Rules(String first, String second) {
            this.first = first;
            this.second = second;
        }
    }

    public Changer() {
        Scanner scanner = new Scanner(System.in);
        countRules = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < countRules; i++) {
            rules.add(new Rules(scanner.next(),scanner.next()));
        }
        text = scanner.next();
    }


    public void withRegex() {
        String tempText = text;
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < rules.size(); i++) {
            stringBuilder.append(rules.get(i).first);
            if(i!= rules.size() -1)
                stringBuilder.append("|");
        }

        HashMap<String, String> replaceMap = new HashMap<String, String>();

        for (int i = 0; i < rules.size(); i++)
            replaceMap.put(rules.get(i).first,rules.get(i).second);


        Pattern pattern = Pattern.compile(stringBuilder.toString());
        Matcher matcher = pattern.matcher(tempText);
        tempText= matcher.replaceAll(x -> replaceMap.get(x.group()));
        System.out.println(" WithRegex : " + tempText);
    }


    public void withoutRegex() {
        String tempText = text;
            for (int i = 0; i < tempText.length(); i++) {
                for (int j = 0; j < rules.size(); j++) {
                    if (i + rules.get(j).first.length() <tempText.length() &&
                            tempText.substring(i, i + rules.get(j).first.length()).equals(rules.get(j).first)) {
                        tempText = tempText.replace(rules.get(j).first,rules.get(j).second + " ");
                        i += rules.get(j).second.length();
                        break;
                    }
                }
            }
            System.out.println(" WithoutRegex : " + tempText.replaceAll(" ", ""));
        }
}