package algorithm.day20;

import java.io.*;
import java.util.*;

public class Day20 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" "))
                           .mapToInt(Integer::parseInt)
                           .toArray();

        int s = Integer.parseInt(br.readLine());

        for (int i = 0; i < n && s > 0; i++) {
            int maxIdx = i;

            for (int j = i + 1; j < n && j <= i + s; j++) {
                if (nums[j] > nums[maxIdx]) {
                    maxIdx = j;
                }
            }

            for (int idx = maxIdx; idx > i; idx--) {
                int temp = nums[idx];
                nums[idx] = nums[idx - 1];
                nums[idx - 1] = temp;
                s--;
            }
        }

        Arrays.stream(nums).forEach(num -> System.out.print(num + " "));
    }
}
