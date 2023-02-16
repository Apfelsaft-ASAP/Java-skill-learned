package exercise;
class ex11 {                                    //x만큼 간격이 있는 n개의 숫자
    public static void main(String[] args) {
        long[] answer = new long[3];
        long temp = 4;

        for(int i=0; i<3; i++) {
            answer[i] += temp * (i+1);

        }
    }
}