package exercise;

class ex17 {                                    //문자열 다루기
    public static void main(String[] args) {
        String s = "1db35";
        boolean answer = true;
        int length = s.length();
        if (length != 4 && length != 6)
            System.out.println(!(answer));
        for (int i = 0; i < length; ++i) {
            char c = s.charAt(i);
            if (c < '0' || c > '9')
                System.out.println(!(answer));

        }
        System.out.println(answer);
    }
}



