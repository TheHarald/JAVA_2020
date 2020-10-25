package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Changer {
    private final String[] rules;
    private final String text;
    private int countRules;

    public Changer() {
        Scanner scanner = new Scanner(System.in);
        countRules = Integer.parseInt(scanner.nextLine());
        rules = new String[countRules];

        for (int i = 0; i < countRules; i++) {
            rules[i]=scanner.nextLine();
        }

        text=scanner.next();
    }


    public void withRegex(){
        String tempText=this.text;
        Pattern pattern = Pattern.compile("(?<first>\\w+) (?<second>\\w+)");
        Matcher matcher;

        for (int i = 0; i < rules.length; i++) {
            matcher = pattern.matcher(rules[i]);
            if (matcher.find()) {
                tempText = tempText.replaceAll(matcher.group("first"), " " + matcher.group("second") + " ");
            }

        }

        System.out.println(" WithRegex : " + tempText.replace(" ", ""));
    }

    public void withoutRegex(){

        class Rules{
            private String first,second;

            public Rules(String first, String second) {
                this.first = first;
                this.second = second;
            }
        }

        String tempText=text;
        ArrayList<Rules> rules = new ArrayList<>();
        for (int i = 0; i < countRules; i++){
            rules.add(new Rules(this.rules[i].split(" ")[0],this.rules[i].split(" ")[1]));

            if(tempText.indexOf(rules.get(i).first)!= -1){
                tempText=tempText.replaceAll(rules.get(i).first," "+rules.get(i).second+" ");
            }
        }
        System.out.println(" WithoutRegex : " + tempText.replace(" ",""));
    }
}
