package exercise;
class ex7 { // 음양 더하기
    public static void main(String[] args) {
        int[] absolutes = {4, 7, 12};
        boolean[] signs = {true, false, true};
//        int[] absolutes = {4, 7, 12};
//        boolean[] signs = {true, false, true};
//
        int answer = 0;

        for (int i = 0; i < absolutes.length; i++) {

            if(signs[i]) {
                answer += absolutes[i] *1;
            }else {
                answer += absolutes[i] *-1;
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