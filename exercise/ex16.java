package exercise;
class ex16 {                                            //문자열 내 p와 y의 개수
    public static void main(String[] args) {
        String s = "pPooooooYy";
        s = s.toUpperCase();                            //toUpperCase 함수로 s 를 대문자로 형변환 한다.
                                                        //반대는 toLowerCase 가 있다.
        int p = 0;                                      //p, y값 카운트 변수를 선언했다.
        int y = 0;

        for (int i = 0; i < s.length(); i++) {          //i값은 s의 길이만큼 반복한다.
            if (s.charAt(i) == 'P') {                   //'P'와 같은 글자가 있을때마다 p값이 1씩 증가한다.
                p++;
            } else if (s.charAt(i) == 'Y') {            //'Y'와 같은 글자가 있을때마다 y값이 1씩 증가한다.
                y++;
            }
        }

        if (p == y) {                                   //p와 y값이 같다면 각 두글자가 같은 개수로 들어가 있기에 true가 반환된다.
            System.out.println(true);
        } else {                                        // 아니라면 false가 반환된다.
            System.out.println(false);
        }
    }
}