# 오늘의 학습 

- [문제 링크 - 프로그래머스 표현 가능한 이진트리](https://school.programmers.co.kr/learn/courses/30/lessons/150367)

### 트리 탐색 

- 주어진 문제는 트리에 관련한 문제이다. 

### 오늘의 회고
  - 어떤 문제가 있었고, 나는 어떤 시도를 했는지 
    - 트리 탐색와 관련한 문제를 풀었다.
    - 어떤 경우에 이진트리로 표현 가능한지를 재귀 함수를 통해 풀었다. 

  - 어떻게 해결했는지 
    - 주어진 수를 이진수로 변환한다. 
    - 이진 트리로 표현 가능한 지를 파악하기 위해서는 이진 트리의 depth를 알아야 한다. 
      - 특정 depth에 이진트리를 만들기 위해서 필요한 노드 수는 정해져있기 때문이다. 
    - depth를 가지고, 부족한 자리 수 만큼 앞을 0으로 채워준다. 
    - 이진트리가 가능한 지의 여부는 root 노드부터 탐색을 시작한다. 
      - root 노드는 이진수의 중간에 위치하므로, 중간에서부터 탐색을 시작한다. 
      - root 노드를 기준으로, 왼쪽과 오른쪽의 경우를 나누어 탐색을 한다. (dfs 처럼 풀면된다.)
      - 이진 트리가 되지 못하는 경우는 부모 노드가 0인데 자식이 0이 아닌 경우이다. (만들어 질 수 없는 경우)
    
  - 무엇을 새롭게 알았는지 
    - 이진 트리 여부를 확인하기 위해 트리 구성과 트리 탐색 방법에 대해서 알게 되었다.