public class exam01 {
    public int solution(int num) {
        int answer = 0;                 //answer 값은 단돈의 카운트 값이다.
        int rtan = 1000;                //르탄이는 1000원을 지불
        int change500, change100, change50, change10;              //거스름돈 10원
        int pay = rtan-num;             //pay 값은 르탄이가 num가격의 구매할때 받아야 하는 돈이다.

//        while(pay >= change500) {       //받아야 하는 돈이 500원보다 많거나 같을때 (500원으로 잔돈을 줄 수 있다)
//            pay -= change500;           //받아야 하는 돈에서 500원 만큼 뺀뒤 answer카운트를 증가 시킨다.
//            answer ++;
//        }while(pay >= change100){       //받아야 하는 돈이 100원보다 많거나 같을때 (100원으로 잔돈을 줄 수 있다)
//            pay -= change100;           //받아야 하는 돈에서 100원 만큼 뺀뒤 answer카운트를 증가 시킨다.
//            answer ++;
//        }while(pay >= change50){        //받아야 하는 돈이 50원보다 많거나 같을때 (50원으로 잔돈을 줄 수 있다)
//            pay -= change50;            //받아야 하는 돈에서 50원 만큼 뺀뒤 answer카운트를 증가 시킨다.
//            answer ++;
//        }while(pay >= change10){        //받아야 하는 돈이 10원보다 많거나 같을때 (10원으로 잔돈을 줄 수 있다)
//            pay -= change10;            //받아야 하는 돈에서 10원 만큼 뺀뒤 answer카운트를 증가 시킨다.
//            answer ++;                  //pay가 0이 되면 거스름돈을 더 안받아도 되니 카운트 종료
//        }

        //동전의 개수 체크하기
        change500 = pay/500;
        pay%=500;
        change100 = pay/100;
        pay%=100;
        change50 = pay/50;
        pay%=50;
        change10 = pay/10;

        final int count = change500 + change100 + change50 + change10;

        answer+=count;

        return answer;
    }

    public static void main(String[] args) {
        exam01 method = new exam01();
        int num1 = 160;
        System.out.println(method.solution(num1));
    }
}