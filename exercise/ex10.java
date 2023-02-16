package exercise;

import java.util.Arrays;

class ex10 {                                                   //행렬의 덧셈
    public static void main(String[] args) {
        int[][]arr1= {
                {1,2},
                {3,4}
        };
        int[][]arr2= {
                {3,4},
                {5,6}
        };

        int[][] answer = new int[arr1.length][arr1[0].length]; //이중배열 초기화 arr1의 배열길이와 arr1의 0번째 배열의 배열길이에 맞게 초기화

        for(int i = 0; i<arr1.length; i++) {                   //i값은 arr1만큼 반복한다
            for(int j = 0; j<arr1[0].length; j++) {            //j값은 arr1[0]만큼 반복한다
                answer[i][j] = arr1[i][j] + arr2[i][j];        //각각 위치에 행렬을 더해준다
            }
        }

        System.out.println(Arrays.deepToString(answer));
    }
}

