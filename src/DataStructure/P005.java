package DataStructure;

import java.util.Scanner;

public class P005 { // 나머지 합 구하기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 배열의 원소 개수
        int M = sc.nextInt(); // 나누어떨어져야 하는 수. 구간 합을 M으로 나눈다.
        long[] S = new long[N];
        long[] C = new long[M]; // ex) 3으로 나누면 나머지는 0,1,2로 3개가 존재한다. 따라서 count 배열의 길이는 M이다.
        long answer = 0;

        // 합 배열 만들기
        S[0] = sc.nextInt(); // 합 배열 공식 S[i] = S[i-1] + A[i] 때문에 S[0]은 따로 구한다.
        for (int i = 1; i < N; i++){
            S[i] = S[i-1] + sc.nextInt();
        }

        // 나머지 연산 값 count 하기
        for(int i = 0; i < N; i++){ /* 배열의 수 만큼 반복 (i < N) */
            int remainder = (int) (S[i] % M); // 합 배열을 M으로 나머지 연산한 값 임시 저장
            if (remainder == 0) answer++;
            C[remainder]++; // ex) 나머지가 1이면 C[1]의 값을 1 증가시킨다. (count)
        }
        // 나머지가 같은 구간 합 중에서 2가지를 뽑는 경우의 수를 구해 answer에 더하기
        // nC2 = n * (n-1) / 2 (단, n>1 일 때)
        for (int i = 0; i < M; i++){
            if (C[i] > 1){
                answer = answer + C[i] * (C[i] - 1) / 2;
            }
        }
        System.out.println(answer);
    }
}

/*
원소가 N개인 배열이 주어졌을 때,
연속된 부분의 합이 M으로 나누어떨어지는 구간의 개수를 구하는 문제이다.
 <나머지 합 문제> 풀이의 핵심은
 (1)
 (A+B) % C 가 ( (A%C)+(B%C) ) % C와 같다는 것이다.
 즉 '특정 구간에 해당하는 수 각각을 먼저 나머지 연산(A%C)한 값들의 합(A%C)+(B%C)'을 나머지 연산한 값( (A%C)+(B%C) ) % C과
 구간 합(A+B)의 나머지 연산(A+B) % C한 값은 동일하다.
 => 그래서 합 배열을 나머지 연산한 값을 구하는 것이다.
 (2)
 S[i] % M의 값과 S[j] % M의 값이 같다면 (S[i]-S[j])%M 은 0으로 나누어떨어진다.
 즉 구간 합 배열의 원소를 M으로 나눈 나머지 연산 값이 같으면 구간 J+1에서 i까지의 구간 합이 M으로 나누어 떨어진다는 것이다.
 => 그래서 합 배열을 나머지 연산한 값 별로 개수를 count 하여 조합을 이용해 경우의 수를 구하는 것이다.
 */