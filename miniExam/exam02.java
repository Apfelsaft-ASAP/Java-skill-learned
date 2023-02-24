package miniExam;

public class exam02 {
    public int solution(String s) {
        int answer = 0;                         // 점수값
        int count = 0;                          //'O'의 횟수 초기화 값

        for (char c : s.toCharArray()){         //향상된 for문 사용
            if ( c == 'O'){                     //'O'와 일치한다면
                count ++;                       //count값이 증가하고
                answer += count;                //answer값에 증가한 값을 더해준다.
            }else {
                count =0;                       //아니라면 count값을 0으로 초기화 해준다.
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        exam02 method = new exam02();
        String s = "OXOOOXXXOXOOXOOOOOXO";
        System.out.println(method.solution(s));
    }
}

