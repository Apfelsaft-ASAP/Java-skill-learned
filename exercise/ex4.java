class ex4 {
    public long solution(int a, int b) {    //a값과 b값을 입력하면 ex) 4, 8  4,8과 그사이 값의 전체 총합을 구하는 함수
        long answer = 0;                    //
        int temp = a-b;                     //a-b값으로 변수를 선언한다.// a, b의 대소관계를 구분짓기 위함이다.

        if(temp<0){                         //temp값이 0보다 작다는 것은 a값보다 b값이 크다는 뜻이다.
            for(int i=a; i<=b; i++){        //i 값을 a로 잡아주고 i값이 b값과 동일 해질때까지 answer 값에 i를 더해준다.
                answer +=i;
            }
        }else if(temp>0){                   //temp값이 0보다 크다는 것은 a값이 b값보다 크다는 뜻이다.
            for(int i=b; i<=a; i++){        //i 값을 b로 잡아주고 i값이 a값과 동일 해질때까지 answer 값에 i를 더해준다.
                answer +=i;
            }
        }else{                              //위 2가지의 조건에도 해당하지 않는다면 a와 b값은 동일 하므로 a값을 answer에 대입한다.
            answer = a;
        }

        return answer;
    }
}