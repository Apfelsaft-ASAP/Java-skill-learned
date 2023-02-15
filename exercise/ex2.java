class Solution {
    public String solution(int num) {
        String answer = "";
        return num%2==0? "Even":"Odd";      // 삼항연산자 사용
    }                                       // 조건식 2의 배수 ? 참 "Even" : 거짓 "Odd"
}