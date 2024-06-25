import java.util.Scanner;

public class P001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 숫자의 개수 N 입력
        String sNum = sc.next(); // N개의 숫자 공백없이 입력
        char[] cNum = sNum.toCharArray(); // 문자열을 문자 배열로 변경
        int sum = 0;
        for (int i = 0; i < cNum.length; i++){
            sum += cNum[i] - '0'; /* 문자를 숫자로 변경 */
        }
    }
}

/* 문자를 숫자로 변경
문자 '1'과 숫자 1의 아스키코드 값 차이는 48이다.
따라서 문자 '1'을 숫자 1로 변환하려면 '1' - 48 또는 '1' - '0' 연산한다.
*/
