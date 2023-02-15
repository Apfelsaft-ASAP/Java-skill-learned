package exercise;

import java.util.Scanner;


//문제 설명
//이 문제에는 표준 입력으로 두 개의 정수 n과 m이 주어집니다.
//별(*)문자를 이용해 가로의 길이가 n,세로의 길이가 m인 직사각형 형태를 출력해보세요.
//
//제한조건 = n과 m은 각각 1000 이하인 자연수 입니다.
class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        for (int i = 0; i<b; i++) {         //중첩 for문 사용
            for (int j = 0; j<a; j++) {     //안쪽 for문먼저 작동한다.
                System.out.print("*");      //1. j가 0일때 후위 ++증가 한다. 2. "*"을 프린팅 한다.
                System.out.println();       //j 값이 a값과 같아질때까지 반복한다.
            }                               //안쪽 for문이 종료되면 "*" 반복한 횟수 만큼 찍혀있다. // print하여 \n 이되어 프린트 되지 않게 한다.
                                            //바깥쪽 for문이 작동한다. i값이 b값과 같아 질 때까지 안쪽 for문을 반복한다.
                                            //반복한 횟수만큼 찍힌 "*"을 세로로 프린팅 한다.
        }
    }
}