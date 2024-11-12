# 오늘의 학습 

- [문제 링크 - 백준 비슷한 단어](https://www.acmicpc.net/problem/2179)

### 정렬

- 주어진 문제는 정렬과 관련한 문제이다. 
  - 정렬을 잘 이용하면 문제를 풀 수 있다. 

### Comparator vs. Comparable 

- Comparator와 Comparable은 모두 interface이다. 
- 객체는 본질적으로 사용자가 기준을 정해주지 않으면 우선순위를 판단할 수 없다. 
- 이러한 문제 때문에 객체를 비교할 수 있도록 하는 Comparator와 Comparable이 사용된다. 
- Comparator와 Comparable은 비교 대상이 다르다. 

#### Comparator (비교자)

- 여러 메소드 중에 **compare(T o1, T o2)** 하나만 재정의해주면 된다. 
  - default 메서드 : 인터페이스에서 구현채를 가지는 메서드. 필요에 따라 오버라이드한다.
  - static 메서드 : 인터페이스 내에서도 정적 메서드를 정의할 수 있으며, 오버라이드 할 수 없다.

- 파라미터로 들어오는 두 객체를 비교한다. 
- util 패키지에 있기 때문에 import 가 필요하다. 
- 익명 객체를 사용할 수 있다. (람다 사용가능)
    - 정수 정렬할 때 
    ```
    Collections.sort(students, (s1, s2) -> Integer.compare(s1.score, s2.score));
    ```
    - 문자열을 정렬할 때 
    ```
    Collections.sort(words, (s1, s2) -> s1.compareTo(s2));
    ```

#### Comparable (스스로가 비교될 수 있는)

- **compareTo(T o)** 메소드 하나가 선언되어있는데, 이것만 재정의해주면 된다. 
- 자기자신과 매개변수 객체를 비교한다. 
- lang 패키지에 있기 때문에 import 해줄 필요가 없다. 
- 익명 객체를 사용할 수 없다. (람다 불가능)

<br>

### 오늘의 회고
  - 어떤 문제가 있었고, 나는 어떤 시도를 했는지 
    - 정렬과 관련한 문제를 풀었다. 

  - 어떻게 해결했는지 
    - Word 클래스를 만들고, String 타입의 word와 int 타입의 idx를 필드로 주었다. 
    - Word가 Comparable을 implements 받아 compareTo를 재정의하였다. 
    - 재정의한 compareTo를 통해 정렬을 한다. 
    - 반복문을 통해 가장 비슷한 두단어를 구한다. 
      - 이때, idx 필드를 통해 어떤게 앞 순서로 와야하는지 정한다. 

  - 무엇을 새롭게 알았는지 
    - Comparator와 Comparable의 차이를 알게 되었다. 

> [참고 블로그](https://st-lab.tistory.com/243) 를 참고하였습니다. 