package exercise;
class ex7 {                                                 // 음양 더하기
    public static void main(String[] args) {
        int[] absolutes = {4, 7, 12};
        boolean[] signs = {true, false, true};
//        int[] absolutes = {4, 7, 12};
//        boolean[] signs = {true, false, true};
//
        int answer = 0;

        for (int i = 0; i < absolutes.length; i++) {        //for문 i값을 absolutes배열 길이만큼 반복수행한다.

            if(signs[i]) {                                  //sign[i]의 불리언 값을 불러온다 맞다면
                answer += absolutes[i] *1;                  //1을 곱해 양수인 값을 answer에 집어넣고
            }else {                                         //아니면
                answer += absolutes[i] *-1;                 //-1을 곱해 음수의 값으로 만들어 answer 값에 집어넣는다.
            }
        }
        System.out.println(answer);
    }
}

//class Solution {
//    public int solution(int[] absolutes, boolean[] signs) {
//        int answer = 0;
//        for (int i=0; i<signs.length; i++)
//            answer += absolutes[i] * (signs[i]? 1: -1);
//        return answer;
//    }
//}