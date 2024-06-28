package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P004 { // 구간 합 구하기2 (49p 참고)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int A[][] = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int D[][] = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                // 구간 합 구하기
                D[i][j] = D[i][j - 1] + D[i - 1][j] - D[i - 1][j - 1] + A[i][j];
            }
        }
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            // 구간 합 배열로 답 구하기
            int result = D[x2][y2] - D[x1 - 1][y2] - D[x2][y1 - 1] + D[x1 - 1][y1 - 1];
            System.out.println(result);
        }
    }
}



/* 2차원 배열 D[i][j] 구간 합 (합 배열)
 D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i]]j]
*/

/* 입력이 2 2 3 4 이면 (2,2)에서 (3,4)까지의 구간 합을 구하는 것이다.
(3,4) 구간 합에서 (1,4) 구간 합, (3,1) 구간 합을 뺀 다음 중복으로 뺀 (1,1) 구간합을 더하면 된다. */

/* 입력 예제
 4 3 // 2차원 배열의 크기, 구간 합 구하는 횟수
 1 2 3 4 // 입력 배열 1번째 줄  ex. (1,1)이 1, (1,2)가 2
 2 3 4 5 // 입력 배열 2번째 줄
 3 4 5 6 // 입력 배열 3번째 줄
 4 5 6 7 // 입력 배열 4번째 줄
 2 2 3 4 // (2,2), (3,4) 구간 합 (결과: 27)
*/