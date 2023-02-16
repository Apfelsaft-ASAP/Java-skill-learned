package exercise;
class ex15 {                                    //내적
    public static void main(String[] args) {
        int[]a = {1,2,3,4};
        int[]b = {-3,-1,0,2};
        int answer = 0;

        for(int i = 0; i<a.length; i++) {       //i값은 a의 배열의 길이만큼 반복한다.
            answer += a[i]*b[i];                //i값은 배열의 위치를 의미하며 각 a,b의 i배열위치의 값을 곱하여 answer에 대입한 후 반환 한다.
        }
        System.out.println(answer);
    }
}