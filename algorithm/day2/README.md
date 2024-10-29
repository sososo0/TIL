# 오늘의 학습 

- [문제 링크 - 백준 1389](https://www.acmicpc.net/problem/1389)

### 다익스트라 vs 플로이드 와샬

- 주어진 문제는 플로이드 와샬 유형이다. 
  - 문제는 BFS처럼 풀었다.
  - 복습을 위해서 플로이드 와샬에 대해서 다시 알아보고, 자주 비교되는 그래프 알고리즘인 다익스트라와도 함께 비교해보자. 

#### 다익스트라 

- 다익스트라는 **하나의 정점**에서 출발했을 때 다른 모든 정점으로의 최단거리를 구하는 알고리즘 
- **우선 순위 큐**와 **BFS**의 형태를 가지고 있다.  
  - 우선 순위 큐를 사용하여 거리가 작은 순으로 방문하게 된다. 

#### 플로이드 와샬 

- **모든 정점**에서 다른 모든 정점으로의 최단거리를 구하는 알고리즘 
- 플로이드 와샬은 경로의 경유점을 알아야 한다. 
- dp처럼 풀 수 있다. 
- 점화식 
    ```
    Ck(u, v) = Math.min( (Ck-1(u, k)+Ck-1(k, v)), Ck-1(u,v))
    ```

- 플로이드 와샬은 시간 복잡도가 매우 높기 때문에 효율적인 코드 작성이 필요할 때는 가급적 피하는 것이 좋다. (500이상의 node들이 주어졌을 때)

<br>

<details>
<summary>플로이드 와샬로 풀었을 때</summary>
<div markdown="1">

```
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] graph = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
            graph[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE
                            && graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        int minB = Integer.MAX_VALUE;
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            int total = 0;
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] != Integer.MAX_VALUE) {
                    total += graph[i][j];
                }
            }
            if (minB > total) {
                minB = total;
                answer = i;
            }
        }

        System.out.println(answer);

        sc.close();
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

<br>

> [참고 블로그](https://loosie.tistory.com/146) 블로그를 참고하였습니다. 