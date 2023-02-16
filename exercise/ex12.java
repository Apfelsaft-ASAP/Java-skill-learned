package exercise;
class ex12 {                                    //부족한 금액 계산하기
    public static void main(String[] args) {
        int price =3;
        int money = 40;
        int count = 4;
        long sum = 0;

        long result = 0;

        for (int i = 0; i < count; i++) {
            sum += (long)price * (i+1);

        }
        result = sum-money >0? sum-money : 0;

        System.out.println(result);

    }
}