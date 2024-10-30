# 오늘의 학습 

- [문제 링크 - 백준 2660](https://www.acmicpc.net/problem/2660)

### 플로이드 와샬

- 주어진 문제는 플로이드 와샬 유형이다. 
  - 문제는 BFS처럼 풀었다.
  - Day2에서 풀었던 방식과 유사하다. 
  - 문제에서 유의할 점 2가지다.
    - 각 회원의 점수는 해당 회원이 가질 수 있는 점수 중 가장 큰 점수라는 것
    - 회장은 점수가 **가장 작은 사람**이 선발되는 것 

<br>

<details>
<summary>플로이드 와샬로 풀었을 때</summary>
<div markdown="1">

```
import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[][] graph;
    static int[] members;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], 51);
            graph[i][i] = 0;
        }

        while (true) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            if (n1 == -1 && n2 == -1) {
                break;
            }

            graph[n1][n2] = 1;
            graph[n2][n1] = 1;
        }

        members = new int[n + 1];

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        int minScore = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int maxDist = 0;
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] <= 50) {
                    maxDist = Math.max(maxDist, graph[i][j]);
                }
            }
            members[i] = maxDist;
            minScore = Math.min(minScore, maxDist);
        }

        int minCnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (members[i] == minScore) {
                sb.append(i);
                sb.append(" ");
                minCnt += 1;
            }
        }

        System.out.println(minScore + " " + minCnt);
        System.out.println(sb.toString());
    }
}
```

</div>
</details>

<br>

### 오늘의 회고
  - 어떤 문제가 있었고, 나는 어떤 시도를 했는지 
    - 플로이드 와샬과 관련한 문제를 풀었다. 
    - 플로이드 와샬로 풀어야 한다는 것을 알았지만, BFS 방식으로 문제를 풀었다. 
  - 어떻게 해결했는지 
    - 방문을 확인하는 배열과 Deque를 활용하여 BFS 방식으로 문제를 풀었다. 
  - 무엇을 새롭게 알았는지
    - 플로이드 와샬말고도 다른 방법으로 풀 수 있었다. 
