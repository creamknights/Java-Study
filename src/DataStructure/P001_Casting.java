package DataStructure;

public class P001_Casting {
    public static void main(String[] args) {
        // 자바에서의 형 변환
        // String -> 숫자형(int, double, float, long, short)
        String sNum = "1234";

        int i1 = Integer.parseInt(sNum); // 기본형 int 반환 (메모리 사용 최소화)
        int i2 = Integer.valueOf(sNum); // 객체 형태의 Integer 반환
        double d1 = Double.parseDouble(sNum);
        double d2 = Double.valueOf(sNum);
        float f1 = Float.parseFloat(sNum);
        float f2 = Float.valueOf(sNum);
        long l1 = Long.parseLong(sNum);
        long l2 = Long.valueOf(sNum);
        short s1 = Short.parseShort(sNum);
        short s2 = Short.valueOf(sNum);

        // 숫자형(int, double, float, long, short) -> String
        int i = 1234;
        String si1 = Integer.toString(i); /* Integer 클래스의 toString 메서드 사용 */
        String si2 = String.valueOf(i); /* 인수 i를 String 문자열로 변환 */
        double d = 1.23;
        String sd1 = Double.toString(d);
        String sd2 = String.valueOf(d);
        float f = (float) 1.23;
        String sf1 = Float.toString(f);
        String sf2 = String.valueOf(f);
        long l = 1234;
        String sl1 = Long.toString(l);
        String sl2 = String.valueOf(l);
        short s = 1234;
        String ss1 = Short.toString(s);
        String ss2 = String.valueOf(s);

    }
}

/* Integer 클래스는 정수형 데이터를 처리하기 위한 메서드를 제공한다.
   Integer.toString(i)은 정수를 문자열로 변환하는 메서드이다. */

/* String.valueOf(i)는 Integer.toString(i) 보다 더 다양한 타입의 값을 문자열로 변환하는 다목적 메서드이다.
   int, long, float, double, char, boolean, 객체 타입을 문자열로 변환 가능하다. (코드 유연성) */

