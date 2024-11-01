# 오늘의 학습 

- [문제 링크 - 백준 2457](https://www.acmicpc.net/problem/2457)

### 정렬과 그리디 

- 주어진 문제는 정렬과 그리디이다. 
  - 문제를 보자마자 떠올린 것은 이전에 풀어보았던 프로그래머스의 [운영체제](https://school.programmers.co.kr/learn/courses/15008/lessons/121686) 문제였다.
    - 비슷하게 풀면 되겠다라는 생각을 하였다. 
  - 문제를 푸는 핵심은 정렬과 순차적으로 탐색을 하면서 날짜를 선택하는 조건에 있다. 
    - 나의 경우는 **피는 날짜를 기준으로 정렬**을 하였다. 
    - 또한, 날짜 선택 시 기준을 충족하는 꽃 중에서 지는 날짜가 가장 늦은 꽃으로 기준을 갱신하였다. 
      - 이때의 기준은 **처음에는 3월 1일에 꽃이 피어 있는지를 확인**하는 것이었고, 
      - 이후에는 **다음 꽃이 피는 시점과 이전 꽃이 지는 시점이 연속적**으로 연결될 수 있는지를 판단하는 것

#### 정렬 방법 

```
    flowers = new int[n][2];
    for (int i = 0; i < n; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        flowers[i][0] = Integer.parseInt(st.nextToken())*100+Integer.parseInt(st.nextToken());
        flowers[i][1] = Integer.parseInt(st.nextToken())*100+Integer.parseInt(st.nextToken());
    }

    Arrays.sort(flowers, (o1, o2) -> {
        if (o1[0] != o2[0]) return Integer.compare(o1[0], o2[0]);
        return Integer.compare(o1[1], o2[1]);
    });
```

- 처음 문제를 풀때는 2차원 배열을 구현하여, 첫번째 원소에는 피는 날짜를 넣고 두번째 원소에는 지는 날짜를 넣었다. 
- 이때 정렬은 이차원 배열을 정렬하는 방법으로 **람다식을 활용하여 정렬**을 하였다. 

<br>

```
    Flower[] flowers = new Flower[n];

    for (int i = 0; i < n; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken())*100 + Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken())*100 + Integer.parseInt(st.nextToken());

        flowers[i] = new Flower(start, end);
    }

    Arrays.sort(flowers);
```

- 시간을 두고 문제를 다시 풀었을 때는 Flower라는 클래스를 구현하고, 이 클래스에서 Comparable을 implements 받아 compareTo를 오버라이딩하는 것이다. 
- 이렇게 구현을 하면 Arrays.sort()만 하면 원하는데로 정렬이 되게 된다. 
  - 여기서 **왜 Arrays.sort() 인가?** 라는 궁금증이 들 수도 있을 것이다. 
  - 그 이유는 **배열을 정렬**하기 때문이다. 만약, List로 선언했다면, Collections을 사용했을 것이다. 

<br>

### 오늘의 회고
  - 어떤 문제가 있었고, 나는 어떤 시도를 했는지 
    - 정렬과 그리디와 관련한 문제를 풀었다. 
    - 연관된 비슷한 문제를 푼 경험을 되살려 풀었다. 
  - 어떻게 해결했는지 
    - 정렬을 먼저 수행하고 내가 세운 기준에 맞는 원소들을 골랐다. 
  - 무엇을 새롭게 알았는지
    - 정렬 방법에 대해 다시 회고해 볼 수 있었다. 
