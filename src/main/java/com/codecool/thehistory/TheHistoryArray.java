package com.codecool.thehistory;


import java.util.*;

public class TheHistoryArray implements TheHistory {

    /**
     * This implementation should use a String array so don't change that!
     */
    private String[] wordsArray = new String[0];

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information
        String[] newWordsArray = text
                .trim()
                .replaceAll(" +", " ")
                .replaceAll("\n", " ")
                .replaceAll("\t", " ")
                .split(" ");

        int fal = wordsArray.length;        //determines length of firstArray
        int sal = newWordsArray.length;   //determines length of secondArray
        String[] result = new String[fal + sal];  //resultant array of size first array and second array
        System.arraycopy(wordsArray, 0, result, 0, fal);
        System.arraycopy(newWordsArray, 0, result, fal, sal);

        wordsArray = result;
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information
        List<String> res = new ArrayList<>();
        for (String s : wordsArray) {
            if (!s.equals(wordToBeRemoved)) {
                res.add(s);
            }
        }
        wordsArray = res.toArray(new String[res.size()]);
    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return wordsArray.length;
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        Arrays.fill(wordsArray, "");
        wordsArray = new String[1];
        wordsArray[0] = "";
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information

        for (int i = 0; i < wordsArray.length; i++) {
            if (wordsArray[i].equals(from))
                wordsArray[i] = to;
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
        for (int i = 0; i < wordsArray.length; i++) {
            if (i != wordsArray.length - 1){
                start += wordsArray[i] + " ";
            }else{
                start += wordsArray[i];
            }
        }
        String stringFinal = start.replaceAll("\\b" + switchString + "\\b", toString);
        int forEnd = wordsArray.length;
        Arrays.fill(wordsArray, null);
        StringBuilder oneWord = new StringBuilder();
        char[] words =  stringFinal.toCharArray();
        for (char w : words){
            if (w != ' '){
                oneWord += w;
            }
        }*/
        String switchString = String.join(" ", fromWords);
        String toString = String.join(" ", toWords);
        String start = String.join(" ", wordsArray);
        String stringFinal = start.replaceAll("\\b" + switchString + "\\b", toString);
        wordsArray = stringFinal.split(" ");


    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArray) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}
