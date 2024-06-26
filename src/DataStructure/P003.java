package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P003 { // 구간 합 구하기
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in)); // 표준입력(콘솔)로부터 입력 받음

        StringTokenizer stringTokenizer =
                new StringTokenizer(bufferedReader.readLine()); // 입력의 한 줄을 읽고 ex) 5 3
        int N = Integer.parseInt(stringTokenizer.nextToken()); // 공백으로 구분된 문자열을 토큰으로 분리  N = 5
        int M = Integer.parseInt(stringTokenizer.nextToken()); // M = 3

        long[] S = new long[N + 1]; // S[0] = 0 으로 두고, 1부터 N+1 의 인덱스를 사용하기 위해 길이를 N+1로 설정
        stringTokenizer = new StringTokenizer(bufferedReader.readLine()); // 배열 입력 ex) 5 4 3 2 1
        for (int i = 1; i < N+1; i++){
            S[i] = S[i-1] + Integer.parseInt(stringTokenizer.nextToken()); // stringTokenizer로 배열의 각 숫자를 분리
        }

        for (int q = 0; q < M; q++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine()); // ex) 1 3
            int i = Integer.parseInt(stringTokenizer.nextToken()); // ex) i = 1
            int j = Integer.parseInt(stringTokenizer.nextToken()); // ex) j = 3
            System.out.println(S[j] - S[i-1]); // ex) S[3] - S[0]
        }

    }
}

/* 구간 합 알고리즘
구간 합 알고리즘을 활용하려면 먼저 합 배열을 구해야 한다.
(*) 합 배열 S 정의
 S[i] = A[0] + A[1] + ... + A[i-1] + A[i] // A[0]부터 A[i]까지의 합
(*) 합 배열 S 공식
 S[i] = S[i-1] + A[i]
(*) 구간 합 공식
 S[j] - S[i-1] // i부터 j까지의 구간 합

합 배열을 미리 구해 두면 구간 합은 한 번의 계산으로 구할 수 있다.
 */

/* 입력 예시
5 3 // 배열 수 N = 5개, 구간 합 구하는 횟수 M = 3번
5 4 3 2 1 // 배열
1 3 // 12 = S[3] - S[0]
2 4 // 9 = S[4] - S[1]
5 5 // 1 = S[5] - S[4]
*/

/* BufferedReader는 버퍼를 사용하여 입력을 한 번에 읽어들이기 때문에, Scanner보다 더 빠르게 입력을 처리할 수 있다.
 StringTokenizer는 문자열을 특정 구분자를 기준으로 분리할 때 사용하는 클래스이다.
 */