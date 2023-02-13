class report2_1 {
    public static void main(String[] args) {
        byte b = 10;
        char ch = 'A';
        int i = 100;
        long l = 1000L;
//3-1. 다음 중 형변환을 생략할 수 있는 것은? (모두 고르시오)
        b = (byte) i; // 리퍼럴 값이 아닌 int 값이여서 자동 형변환이 안됨.
        ch = (char) b; // byte는 -128~127까지의 범위 이고 char는 0~6만까지의 범위이다. char는 음수의 값을 가지지 않기 때문에 자동 형변환이 안된다.
        short s = (short) ch;// 같은 크기를 가지고 있지만 short는 +-3만의 범위, char는 +- 6만의 범위라 자동형변환이 안됨.
        float f = (float) l; // float의 범위 크기가 더 커서 자동 형변환 가능
        i = (int) ch; // int의 범위가 더 커서 자동 형변환 가능
    }
}
//
//
//
////3-2. 다음 연산의 결과와 그 이유를 적으세요.
class Exercise3_2{
    public static void main(String[] args){
        int x = 2;
        int y = 5;
        char c = 'A'; // 'A'의 문자코드는 65

        System.out.println(y >= 5 || x < 0 && x > 2); // y값이 5보다 같거나 크다. || 연산자는 하나라도 참이면 True를 반환한다.
        System.out.println(y += 10 - x++); // int y 값인 5와 10을 더한뒤 x 값을 빼면 13 (++후위형으로 더해졌기 때문에 적용 안됨)
        System.out.println(x += 2); // 위에 후위형으로 더해진 x값은 2가 아닌 3이되었다 3+2는 5이다.
        System.out.println(!('A' <= c && c <= 'Z')); //
        System.out.println('C' - c); // C의 아스키코드는 67, A의 아스키 코드는 65 c의 변수 값은 A 따라서 67-65 = 2이다.
        System.out.println('5' - '0'); // 문자열 5의 문자코드는 53, 0의 문자코도는 48 53-48 = 5이다
        System.out.println(c + 1); // c의 값은 'A' A의 문자코드는 65 따라서 65+1은 66이다.
        System.out.println(++c); // c의 값은 'A' A의 문자코드는 65 ++전위형으로 더해져서 프린팅 되는 값은 B 이다.
        System.out.println(c++); // 위에 전위형으로 더해져서 c의 값은 66인 B이다. 이번에는 ++ 후위형으로 더해져서 값 변동이 없다.
        System.out.println(c); // 위에 B에서 후위로 더해진 값인 C로 프린팅 된다.
    }
}
//
//
//
////3-3. 아래는 변수의 num 값 중에서 백의 자리 이하를 버리는 코드이다.
////만일 변수 num의 값이 '456'이라면 '400'이 되고, '111'이라면 '100'이 된다.
////알맞은 코드를 넣으시오.
class Exercise3_3 {
    public static void main(String[] args){
        int num = 456;
        System.out.println((int)(Math.floor((float)num/100))*100);
    }
}
////예상 결과 -> 400
//
//
////3-4. 아래의 코드는 사과를 담는데 필요한 바구니(버켓)의 수를 구하는 코드이다.
////만일 사과의 수가 123개이고 하나의 바구니에는 10개의 사과를 담을 수 있다면, 13개의 바구니가 필요할 것이다.
////알맞은 코드를 넣으시오.
class Exercise3_4{
    public static void main(String[] args){
        int numOfApples = 123; // 사과의 개수
        int sizeOfBucket = 10; // 바구니의 크기(바구니에 담을 수 있는 사과의 개수)
        int numOfBucket = (int)((numOfApples/=sizeOfBucket)+Math.ceil((float)(numOfApples%=sizeOfBucket)/sizeOfBucket)); // 모든 사과를 담는데 필요한 바구니의 수

        System.out.println("필요한 바구니의 수 :"+numOfBucket);
    }
}
////예상 결과 -> 필요한 바구니의 수 :13
//
//
//
////3-5. 아래는 변수 num의 값에 따라 '양수', '음수', '0'을 출력하는 코드이다.
////삼항연산자를 이용해서 빈칸에 알맞은 코드를 넣으시오.
////Hint : 삼항 연산자를 두 번 사용할 것!
class Exercise3_5{
    public static void main(String[] args){
        int num = 10;
        String math = num>0? "양수": (num<0 ? "음수" : "0" );
        System.out.println(math);
    }
}
////예상 결과 : 양수
//
//
//
////3-6. 아래는 화씨(Fahrenheit)를 섭씨(Celcius)로 변환하는 코드이다.
////변환 공식이 'C = 5/9*(F-32)'라고 할 때, 빈 칸에 알맞은 코드를 넣으시오.
//// 단, 변환값은 소수점 셋째자리에서 반올림하며, Math.round() 함수를 사용하지 않고 처리할 것!

////예상 결과 : Fahrenheit:100, Celcius:37.78