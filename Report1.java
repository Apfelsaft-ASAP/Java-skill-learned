/* 2-4. 다음 중 변수를 잘못 초기화 한 것은? */
class Test_1 {
    public static void main(String[] args) {
        byte b = 256; //byte의 최소값은 -2^7 (128) 최대값은 2^7-1 (127), 때문에 잘못되었다.
        char c = '';// ''홑 따음표 안에 문자 하나가 지정이 되어야 하는데 공백으로 되어있다. 때문에 잘못되었다.
        char answer = 'no'; // ''홑 따음표  안에 문자 2개가 들어가 있다. 1개만 들어가 있어야 함으로 잘못되었다.
        float f = 3.14 // 뒤에 소수를 알리기 위한 f를 붙여 줘야하고 끝에 세미콜론 ;을 붙여 문자열 마무리를 해야 한다.
        double d = 1.4e3f; // 문제 없이 변수 초기화 되었다.
    }
}

//2-7. 다음 문장들의 출력 결과를 적으세요. 오류가 있는 문장의 경우, '오류'라고 적으세요.
class Test_2 {
    public static void main(String[] args) {

    System.out.println("1"+"2"); // 12 숫자가 아닌 문자열임
    System.out.println(true+""); // true
    System.out.println('A'+'B'); // 131  아스키코드 A : 65, B : 66, A + B = 131
    System.out.println('1'+ 2); // 51 아스키코드 1 : 49, '1' + 2 = 51
    System.out.println('1'+'2');// 99 아스키코드 1 : 49, 2 : 50, '1'+'2'=99
    System.out.println('J'+"ava");//Java
    System.out.println(true+null);// 오류

    }
}

/* 2-8. 아래는 변수 x, y, z의 값을 서로 바꾸는 예제이다. 결과와 같이 출력되도록 코드를 넣으세요.*/
class Exercise2_8{
    public static void main(String[] args) {
        int x = 1;
        int y = 2;
        int z = 3;

        int temp = x;

        x=y;
        y=z;
        z=temp;

        System.out.println("x= "+ x);
        System.out.println("y= "+ y);
        System.out.println("z= "+ z);
    }
}
// 예샹 결과 : x = 2, y = 3, z = 1