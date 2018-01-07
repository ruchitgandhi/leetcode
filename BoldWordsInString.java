package com.practice.leetcode;

/**
 * Created by Ruchit on 06-01-2018.
 */
public class BoldWordsInString {
    public static void main(String[] args) {
        String[] words = {"ab", "bc"};
        String s = "aabcd";
        System.out.println(boldWords(words, s));
    }

    private static String boldWords(String[] words, String S) {
        boolean marker[] = new boolean[S.length()];
        int index;
        for (String word : words) {
            index = S.indexOf(word);
            while (index != -1) {
                for (int i = index; i < index + word.length(); i++) {
                    marker[i] = true;
                }
                index = S.indexOf(word, index + 1);
            }
        }

        boolean previous = false;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < marker.length; i++) {
            if (marker[i] && !previous) {
                str.append("<b>");
            } else if (!marker[i] && previous) {
                str.append("</b>");
            }

            previous = marker[i];
            str.append(S.charAt(i));
        }

        if (previous) {
            str.append("</b>");
        }

        return str.toString();
    }
}
