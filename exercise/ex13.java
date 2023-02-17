package exercise;

public class ex13 {                                                     // 2016  윤년
    public static void main(String[] args) {
        int a = 5;
        int b = 24;
        String answer = "";

        //2016년의 12개월 각날짜 => 31,29,31......
        int[] day = {31,29,31,30,31,30,31,31,30,31,30,31};              //각 달의 일자의 배열을 작성한다.
        String[] date = {"FRI","SAT","SUN","MON","TUE","WED","THU"};    //1월 1일 시작 기점으로 요일을 나열한다.
        int total = 0;                                                  //해당하는 월까지 반복하면서 일자를 더해줄 토탈값 변수를 선언한다.


        for (int i=0; i<a-1; i++){                                      //해당하는 월까지 반복한다.
            total += day[i];                                            //해당하는 월까지 반복하면서 같은 배열 자리에 있는 day배열의 수를 토탈값에 더해준다.
        }


        total = total +b-1;                                             //total 값에 찾는 일을 더해준다. (-1을 해준다 1월 1일 하루가 지난 날이 아니기 때문)
        answer = date[total%7];                                         // 값을 요일수 7을 나눈 나머지를 리턴
        System.out.println(answer);
    }
}
