package exercise;
class ex9 {                                                //핸드폰 번호 가리기
    public static void main(String[] args) {
        String phone_number = "01033334444";
        String answer = "";
        for(int i = 0; i < phone_number.length(); i++){     //phone_number 배열의 길이만큼 반복한다
            if(i < phone_number.length()-4){                //i값이 배열 길이의 -4만큼의 앞쪽 배열에는 *값을 넣는다.
                answer += "*";                              //나머지 값은 숫자 그대로 집어넣는다.
            }
            else{
                answer += phone_number.charAt(i);
            }
        }
        System.out.println(answer);
    }
}