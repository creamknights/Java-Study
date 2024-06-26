package DataStructure;

import java.util.Scanner;

public class P002 { // 평균 구하기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 과목의 수 입력 받기 ex) 4
        int A[] = new int[N]; // 길이가 N인 배열 A[] 선언
        for (int i = 0; i < N; i++){
            A[i] = sc.nextInt(); // 점수 입력 받기 ex) 1 100 100 100
        }
        long sum = 0; // 점수 총합
        long max = 0; // 점수 최댓값
        for (int i = 0; i < N; i++){
            if(A[i] > max) max = A[i];
            sum += A[i];
        }
        System.out.println(sum * 100.0 / max / N); /* 수식을 간단히 정리한 후 계산 ex)75.25 */

    }
}

/* 최댓값을 M 이라고 할 때, 모든 점수를 점수/M*100으로 고쳐서 새로운 평균을 구해 출력하는 문제이다.
3개 과목의 점수가 A,B,C라고 할 때 평균은 (A/M*100 + B/M*100 + C/M*100)/3 = (A+B+C)*100/M/3 이다. */
