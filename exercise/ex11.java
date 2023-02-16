package exercise;
class ex11 {                                    //x만큼 간격이 있는 n개의 숫자
    public static void main(String[] args) {
        long[] answer = new long[3];
        long temp = 4;                          //x값을 선언해준다. (문제에서는 임의의 값이지만 인텔리제이는 그냥 넣음)

        for(int i=0; i<3; i++) {                //i의 값은 n만큼 1씩 증가하며 반복한다
            answer[i] += temp * (i+1);          //i가 1씩 증가하면서 temp의 배수를 반복하면서 answer값에 대입한다.

        }
    }
}