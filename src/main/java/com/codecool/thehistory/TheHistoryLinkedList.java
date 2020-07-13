package com.codecool.thehistory;

import java.util.*;

public class TheHistoryLinkedList implements TheHistory {
    /**
     * This implementation should use a String LinkedList so don't change that!
     */
    private List<String> wordsLinkedList = new LinkedList<>();

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information
        String[] newWordsArray = text
                .trim()
                .replaceAll(" +", " ")
                .replaceAll("\n", " ")
                .replaceAll("\t", " ")
                .split(" ");

        int fal = wordsLinkedList.size();        //determines length of firstArray
        int sal = newWordsArray.length;   //determines length of secondArray
        String[] result = new String[fal + sal];  //resultant array of size first array and second array
        System.arraycopy(wordsLinkedList.toArray(), 0, result, 0, fal);
        System.arraycopy(newWordsArray, 0, result, fal, sal);

        wordsLinkedList = Arrays.asList(result);
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information
        List<String> res = new ArrayList<>();
        for (int i = 0; i < wordsLinkedList.size(); i++) {
            if (!wordsLinkedList.get(i).equals(wordToBeRemoved)){
                res.add(wordsLinkedList.get(i));
            }
        }
        wordsLinkedList = res;
    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return wordsLinkedList.size();
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        wordsLinkedList = new LinkedList<>();
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
        for (int i = 0; i < wordsLinkedList.size(); i++) {
            if (wordsLinkedList.get(i).equals(from))
                wordsLinkedList.set(i,to);
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
        /*String switchString = "";
        String toString = "";
        String start = "";
        for (int i = 0; i < fromWords.length; i++) {
            if (i != fromWords.length - 1){
                switchString += fromWords[i] + " ";
            }else{
                switchString += fromWords[i];
            }
        }
        for (int i = 0; i < toWords.length; i++) {
            if (i != toWords.length - 1){
                toString += toWords[i] + " ";
            }else{
                toString += toWords[i];
            }
        }
        for (int i = 0; i < wordsLinkedList.size(); i++) {
            if (i != wordsLinkedList.size() - 1){
                start += wordsLinkedList.get(i) + " ";
            }else{
                start += wordsLinkedList.get(i);
            }
        }
        String stringFinal = start.replaceAll("\\b" + switchString + "\\b", toString);
        int forEnd = wordsLinkedList.size();

        StringBuilder oneWord = new StringBuilder();
        char[] words =  stringFinal.toCharArray();
        for (char w : words){
            if (w != ' '){
                oneWord += w;
            }
        }
        wordsLinkedList = Arrays.asList(stringFinal.split(" "));*/
        String switchString = String.join(" ", fromWords);
        String toString = String.join(" ", toWords);
        String[] wordsArray = new String[0];
        wordsArray = wordsLinkedList.toArray(wordsArray);
        String start = String.join(" ", wordsArray);
        String stringFinal = start.replaceAll("\\b" + switchString + "\\b", toString);
        wordsLinkedList = Arrays.asList(stringFinal.split(" "));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsLinkedList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}
