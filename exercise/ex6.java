class Solution {
    public int solution(int[] numbers) {        // 0~9까지 정수가 담긴 배열이 있다. 사이 사이에 숫자가 제외 되어있을수 있다.
        int answer = 45;                        // 제외 된 숫자의 합을 구하는 함수이다.
                                                // 0~9까지 정수의 총합을 선언해준다 // 45;
        for(int i=0; i<numbers.length; i++){    // i값으로 nubers의 배열 길이를 반복 수행하고 i값을 1씩 증가 시켜준다.
            answer -= numbers[i];               // i값을 반복 수행할때 배열 안의 숫자와 일치하는 값이 있다면 45에서 그 수를 빼준다.
        }                                       // 남아 있는 answer값은 배열에 없던 수의 총합이다.
        return answer;
    }
}