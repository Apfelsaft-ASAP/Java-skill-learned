package exercise;
class ex16 {                                            //문자열 내 p와 y의 개수
    public static void main(String[] args) {
        String s = "pPooooooYy";
        s = s.toUpperCase();

        int p = 0;
        int y = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'P') {
                p++;
            } else if (s.charAt(i) == 'Y') {
                y++;
            }
        }

        if (p == y) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}