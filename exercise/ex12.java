package exercise;
class ex12 {                                    //부족한 금액 계산하기
    public static void main(String[] args) {
        int price =3;
        int money = 40;
        int count = 4;
        long sum = 0;

        long result = 0;

        for (int i = 0; i < count; i++) {       //count의 횟수만큼 1씩 증가하며 반복한다.
            sum += (long)price * (i+1);         //count가 증가하면서 가격도 배수로 올라간다.

        }
        result = sum-money >0? sum-money : 0;   //삼항 연산자를 사용하여 결과값 출력한다.

        System.out.println(result);

    }
}