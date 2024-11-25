package coding_interview.data_structure.array_and_string.question1;

// 문자열이 주어질 때, 이 문자열에 같은 문자가 중복되어 등장하는지 확인하는 알고리즘 작성 
// 자료 구조 추가 사용 안하고 풀 수 있는지도 고민해보기 

public class Question1 {

    // 시간 복잡도 - O(n^2) | 공간 복잡도 - O(1)
    public boolean answer1(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i+1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    // 소문자만 사용이 가능한 경우 (a ~ z) - 비트 체커 사용 
    // 시간 복잡도 - O(n) | 공간 복잡도 - O(1)
    public boolean answer2(String str) {

        int checker = 0;

        for (int i = 0; i < str.length(); i++) {
            int bitIdx = str.charAt(i) - 'a';
            
            if ((checker & (1 << bitIdx)) > 0) {
                return false;
            }

            checker |= (1 << bitIdx);
        }

        return true;
    }
}

// 생각 흐름 
// 1. ASCII 문자인가? 유니코드 문자인가? 
// 2. 소문자로 이루어져있는가? 