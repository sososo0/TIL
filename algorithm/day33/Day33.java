package algorithm.day33;

import java.io.*;

public class Day33 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine()); // 첫 줄에서 입력받는 테스트 케이스 수

        for (int i = 0; i < n; i++) {
            String word = br.readLine(); // 각 테스트 케이스 단어 입력
            System.out.println(compareCheck(word, 0, word.length() - 1));
        }

        br.close();
    }
    public static boolean firstCheck(String word, int l, int r) {
        while (l < r) {
            if (word.charAt(l) == word.charAt(r)) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static int compareCheck(String word, int l, int r) {
        while (l < r) {
            if (word.charAt(l) == word.charAt(r)) {
                l++;
                r--;
            } else {
                if (firstCheck(word, l + 1, r) || firstCheck(word, l, r - 1)) {
                    return 1;
                }
                return 2;
            }
        }
        return 0;
    }
}

