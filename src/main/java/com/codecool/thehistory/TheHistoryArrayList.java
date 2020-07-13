package com.codecool.thehistory;

import java.util.*;

public class TheHistoryArrayList implements TheHistory {
    /**
     * This implementation should use a String ArrayList so don't change that!
     */
    private List<String> wordsArrayList = new ArrayList<>();

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information
        String[] newWordsArray = text
                .trim()
                .replaceAll(" +", " ")
                .replaceAll("\n", " ")
                .replaceAll("\t", " ")
                .split(" ");

        int fal = wordsArrayList.size();        //determines length of firstArray
        int sal = newWordsArray.length;   //determines length of secondArray
        String[] result = new String[fal + sal];  //resultant array of size first array and second array
        System.arraycopy(wordsArrayList.toArray(), 0, result, 0, fal);
        System.arraycopy(newWordsArray, 0, result, fal, sal);

        wordsArrayList = Arrays.asList(result);
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information
        List<String> res = new ArrayList<>();
        for (int i = 0; i < wordsArrayList.size(); i++) {
            if (!wordsArrayList.get(i).equals(wordToBeRemoved)){
                res.add(wordsArrayList.get(i));
            }
        }
        wordsArrayList = res;
    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return wordsArrayList.size();
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
       wordsArrayList = new ArrayList<>();
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
        for (int i = 0; i < wordsArrayList.size(); i++) {
            if (wordsArrayList.get(i).equals(from))
                wordsArrayList.set(i,to);
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
        String switchString = String.join(" ", fromWords);
        String toString = String.join(" ", toWords);
        String[] wordsArray = new String[0];
        wordsArray = wordsArrayList.toArray(wordsArray);
        String start = String.join(" ", wordsArray);
        String stringFinal = start.replaceAll("\\b" + switchString + "\\b", toString);
        wordsArrayList = Arrays.asList(stringFinal.split(" "));


    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArrayList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}
