package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 갑옷은 2개의 재료로 만든다. 2가지 재료의 고유 번호를 합쳐 M이 되면 갑옷이 만들어진다.
주어진 재료들로 갑옷을 몇 개 만들 수 있는지 구하는 문제이다.
입력 받는 재료 배열을 오름차순 정렬하여 Two Pointer를 이용해 count한다.
 */
public class P007 { // 주몽의 명령 (연속되지 않은 두 자연수의 합)
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // 재료의 개수 (재료 배열의 길이)
        int M = Integer.parseInt(bf.readLine()); // 갑옷을 만들 수 있는 수 (2개 재료 번호의 합)
        int A[] = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++){ // 재료를 배열에 넣기
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A); // 배열 A를 오름차순 정렬
        int count = 0;
        int i = 0; // 왼쪽 인덱스
        int j = N -1 ; // 오른쪽 인덱스 (제일 끝 인덱스로 초기화)
        while (i < j){ // i와 j가 만날 때까지 반복
            if(A[i] + A[j] < M){ // 합이 M보다 작은 경우는 왼쪽 인덱스를 증가시킨다.
                i++;
            } else if (A[i] + A[j] > M){
                j--;
            } else { // 합이 M과 일치하는 경우
                count++;
                i++; // 양쪽 인덱스를 변경하는 이유는 ex) M = 9일 때, 오름차순 정렬된 [1,2,3,4,5,7] 배열에서
                j--; // 2+7=9로 count++한 후에는 i 인덱스의 값은 커지고 j 인덱스의 값은 작아져야 또 M이 가능하기 때문이다.
            }
        }
        System.out.println(count);
        bf.close();
    }
}