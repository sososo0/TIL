package algorithm.day10;

import java.io.*;
import java.util.*;

public class Day10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int answer = 0;
        for (int i = 0; i < n; i++) {

            int left = 0;
            int right = n-1;
            while (left < right) {
                if (left == i) {
                    left ++; 
                    continue;
                } else if (right == i) {
                    right --;
                    continue; 
                }

                if (nums[left] + nums[right] > nums[i]) {
                    right -= 1;
                } else if (nums[left] + nums[right] < nums[i]) {
                    left += 1;
                } else {
                    answer += 1;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
