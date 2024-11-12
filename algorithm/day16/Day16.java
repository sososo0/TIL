package algorithm.day16;

import java.io.*;
import java.util.*;

public class Day16 {

    private static class Word implements Comparable<Word> {
        String word;
        int idx;

        public Word(String word, int idx) {
            this.word = word;
            this.idx = idx;
        }

        @Override
        public int compareTo(Word otherWord) {
            if (this.idx != otherWord.idx) {
                return Integer.compare(this.idx, otherWord.idx);
            }
            return this.word.compareTo(otherWord.word); 
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Word[] words = new Word[n];
        for(int i = 0; i < n; i++) {
            words[i] = new Word(br.readLine().trim(), i);
        }

        Arrays.sort(words);

        int maxL = 0;
        String word1 = null;
        String word2 = null;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int sameCnt = countSameChar(words[i].word, words[j].word);
                if (sameCnt > maxL) {
                    maxL = sameCnt;
                    if (words[i].idx < words[j].idx) {
                        word1 = words[i].word;
                        word2 = words[j].word;
                    } else {
                        word1 = words[j].word;
                        word2 = words[i].word;
                    }
                }
            }
        }

        System.out.println(word1);
        System.out.println(word2);
    }

    private static int countSameChar(String word1, String word2) {
        int result = 0;

        int idx1 = 0;
        int idx2 = 0;

        while (idx1 < word1.length() && idx2 < word2.length()) {
            if (word1.charAt(idx1) == word2.charAt(idx2)) {
                result++;
            } else {
                return result;
            }

            idx1++;
            idx2++;
        }

        return result;
    }
}
