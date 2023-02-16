package exercise;
class ex3 {                                          //
    public static void main(String[] args) {
        String s = "abcde";
        String answer = "";
        int c = s.length() / 2;                     // int 변수 c 값에 s 문자열 길이를 절반으로 나눈다.
        System.out.println();
        if(s.length()%2!=0){                        //if else문 사용
            answer=s.charAt(c)+"";                  //2로 빼서 나머지가 있으면 절반으로 나눈 c값을 바로 가져오고
        }else{                                      //나머지가 없으면 c값에서 앞 쪽 문자열을 -1 로 가져오고 c값을 가져와서 2글자로 만든다.
            answer=s.charAt(c-1)+""+s.charAt(c);
        }
        System.out.println(answer);
    }
}

