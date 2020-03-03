package com.java.tech;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Exam {
    public static void main(String[] args) {
        String myString = "(A||B||C)&&(D||E||F)";
        List<String> operandList = new ArrayList<String>();
        StringTokenizer st = new StringTokenizer(myString, "(&)", true);
        while (st.hasMoreTokens()) {
            String token = st.nextToken();

            if (!("(".contains(token) || ")".contains(token) || "&".contains(token))) {
                operandList.add(token);
            }
        }
        System.out.println("Operands:" + operandList);

        List<String> fResult = new ArrayList<String>();
        StringBuilder result = new StringBuilder("");
        for (int i = 0 ;i < operandList.size()-1; i++) {
            String x = operandList.get(i);
            String y = operandList.get(i + 1);

            List<String> operandList1 = new ArrayList<String>();
            StringTokenizer st1 = new StringTokenizer(x, "|", true);
            while (st1.hasMoreTokens()) {
                String token = st1.nextToken();
                if (!"|".contains(token)) {
                    operandList1.add(token);
                }
            }
            List<String> operandList2 = new ArrayList<String>();
            StringTokenizer st2 = new StringTokenizer(y, "|", true);
            while (st2.hasMoreTokens()) {
                String token = st2.nextToken();
                if (!"|".contains(token)) {
                    operandList2.add(token);
                }
            }
            System.out.println("operandList1:" + operandList1);
            System.out.println("operandList2:" + operandList2);


            for (int j = 0; j < operandList1.size(); j++) {
                for (int k = 0; k < operandList2.size(); k++) {
                    if(!(j ==operandList1.size()-1  && k == operandList2.size()-1)){
                    result.append("(").append(operandList1.get(j)).append("&&").append(operandList2.get(k)).append(")").append("||");}
                    else {
                        result.append("(").append(operandList1.get(j)).append("&&").append(operandList2.get(k)).append(")");
                    }
                }
            }
            System.out.println("Result:" + result);

        }}
}
