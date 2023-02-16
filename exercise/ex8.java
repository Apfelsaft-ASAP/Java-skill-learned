package exercise;
class ex8 {                                     //평균 구하기
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        double answer = 0;
        double sum = 0;
        for (int i = 0; i<arr.length; i++){     //i값을 arr배열 길이만큼 반복한다.
            sum+=arr[i];                        //반복 한만큼 sum값에 더해준다.
        }
        answer = sum/arr.length;                //총합을 arr 배열 길이만큼 나누어서 평균값을 구한다.
        System.out.println(answer);
    }
}