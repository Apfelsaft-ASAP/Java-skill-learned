package exercise;

import java.util.Arrays;

class ex14 {
    public static void main(String[] args) {
        int[] arr = {2, 13, 11, 3};
        int divisor = 5;

        int num = 0;

        for (int i = 0; i < arr.length; i++) {                  //i값을 arr 배열의 길이만큼 반복한다.
            if (arr[i] % divisor == 0) {                        //if문으로 arr배열 위치의 정수가 divisor로 선언된 정수의 배수라면
                num++;                                          //num값이 1씩 증가한다. num값은 뒤에 배열 초기화를 위해 변수 선언을 하였다.
            }else {
                int[] answer = {-1};                            //위 조건에 부합하지 않는다면 answer값에 -1을 반환하고 return으로 돌아간다.
                System.out.println(Arrays.toString(answer));
                return;
            }
        }
        int[] answer = new int[num];                            //num의 배열 길이만큼 answer의 배열을 초기화한다.
        int acount = 0;                                         //answer의 배열에 넣어줄 변수 값을 선언했다.
        for (int j = 0; j < arr.length; j++) {                  //j값은 위 arr 배열 길이만큼 반복한다.
            if (arr[j] % divisor == 0) {                        //j값이 divisor의 배수라면
                answer[acount] += arr[j];                       //answer[acount값의 배열위치] 에다가 arr[j]값을 대입한다.
                acount++;                                       //j값이 반복할때마다 acount의 값이 1씩 증가한다.
            }                                                   //acount값은 answer배열의 숫자를 의미한다고 생각하면 된다.
            }
        System.out.println(Arrays.toString(answer));
        }
    }


