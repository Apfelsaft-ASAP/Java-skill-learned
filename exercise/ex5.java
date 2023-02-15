class Solution {
    public int solution(String s) {
        int answer = 0;

        char p = '+';                                           //+, - 변수 선언한다.
        char m = '-';

        char[] ch = s.toCharArray();                            //String s값을 ch[]값으로 형변환 한다,


        for (int num = 0; num < ch.length; num++) {             //for문의 변수 num으로 ch[]리스트 수만큼 반복작업을 수행한다.
            if (ch[0] == p || ch[0] == m) {                     //ch[]의 0번째에 + || - 가 들어 있다면
                for (int i = 1; i < ch.length; i++){            //i 값은 1번째 인덱스부터 배열 끝까지 반복문을 수행한다.
                    answer = (answer * 10) + ch[(int) i] - '0'; //

                }
                break;
            } else {
                for (int j = 0; j < ch.length; j++)             //0번째 인덱스에 + , -가 없다면
                    answer = (answer * 10) + ch[(int) j] - '0'; //j 값은 0번째 인덱스부터 반복분을 수행한다.

                break;
            }

        }
        if (ch[0] == p) {
            int result = +answer;
            return result;
        }else if (ch[0]==m) {
            int result = -answer;
            return result;
        }else {
            return answer;
        }

    }

}