package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
주어진 N개의 수에서 다른 두 수의 합으로 표현되는 수가 있다면 그 수를 '좋은 수'라고 한다.
N개의 수 중 '좋은 수'가 총 몇 개인지 출력하시오.
 */

public class P008 { // '좋은 수' 구하기
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int Result = 0;
        long A[] = new long[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++){
            A[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(A); // 오름차순 정렬
        for (int k = 0; k < N; k++){
            long find = A[k]; // A[k] 값을 서로 다른 두 원소의 합으로 만들 수 있는지 구하기
            int i  = 0; // 시작 인덱스 초기화
            int j = N - 1; // 끝 인덱스 초기화
            // 투 포인터 알고리즘
            while (i < j){
                if (A[i] + A[j] == find){
                    if (i != k && j != k){ // (*) find는 서로 다른 두 수의 합이어야 함을 체크
                        Result++;
                        break;
                    } else if (i == k ){ // ex) 포인터 i가 k와 같을 때 (find를 가리킬 때)
                        i++;
                    } else if ( j == k ){
                        j--;
                    }
                } else if (A[i] + A[j] < find){
                    i++;
                } else {
                    j--;
                }
            }
        }
        System.out.println(Result);
        bf.close();
    }
}
