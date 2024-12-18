# 오늘의 학습 

- [문제 링크 - 백준 4485](https://www.acmicpc.net/problem/4485)

### 다익스트라 

- 주어진 문제는 다익스트라이다. 
  - 처음에 문제를 보았을 때 이차원 DP로 푸는 방식이 떠올라, DP로 풀려고 했다가 문제가 잘 풀리지 않아 다른 방법을 생각했다. 
  - 문제를 다시 보니 다익스트라 유형의 문제였다. 
  - 우선순위 큐 + BFS 형식으로 문제를 풀었다. 

#### 다익스트라 

- 다익스트라에 대해 복습해보자. 

<br>

- 다익스트라는 **매번 가장 적은 비용을 가진 노드**를 하나씩 꺼낸 다음 그 노드를 거쳐가는 비용, 즉 가장 적은 비용을 하나씩 선택하는 로직이다. 
- **단일 시작점 최단 경로 알고리즘**이다. 
- 시작 정점에서부터 다른 정점들까지의 최단 거리를 계산한다. 
- 다익스트라는 **BFS와 유사한 형태를 가진 알고리즘**으로, BFS처럼 시작점에서 가까운 순서대로 정점을 방문한다. 
- 매번 가장 적은 비용을 가진 노드를 선택해야 하기 때문에 BFS와 달리 **우선 순위 큐**를 사용한다. 

<br>

### 오늘의 회고
  - 어떤 문제가 있었고, 나는 어떤 시도를 했는지 
    - 다익스트라와 관련한 문제를 풀었다. 
    - 처음에는 dp 문제 풀이 방식으로 풀었다가, 문제를 다시 파악하고 다익스트라 형태로 풀었다. 
  - 어떻게 해결했는지 
    - bfs와 우선 순위 큐를 사용하여 문제를 풀었다. 
  - 무엇을 새롭게 알았는지
    - 한달 전에 풀었을 때는 다익스트라인 줄 모르고 dp 형식으로만 풀려다가 실패를 해서 못 풀었다. 
    - 지난 주에 플로이드 와샬을 공부하면서 다익스트라도 함께 공부한 것이 도움이 되어, 이번에는 잘 풀 수 있었다. 

> [다음의 블로그를 참고하였습니다.](https://loosie.tistory.com/146)
