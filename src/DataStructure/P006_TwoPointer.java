package DataStructure;
import java.util.Scanner;

/*
자연수 N을 몇 개의 연속된 자연수의 합으로 나타내는 가짓수를 구하는 문제이다.
N = 10일 때, 10을 연속된 자연수의 합으로 나타내는 방법은 10, 1+2+3+4이다.
*/

/* 시작 인덱스, 종료 인덱스를 투 포인터로 지정한 후 문제에 접근한다.
시작 인덱스를 오른쪽으로 한 칸 이동하는 것은 연속된 자연수에서 왼쪽 값(작은 값)을 삭제하는 것과 같다.
종료 인덱스를 오른쪽으로 한 칸 이동하는 것은 연속된 자연수의 범위를 한 칸 더 확장하는 것이다. 즉 더할 숫자를 한 개 더 늘리는 것이다.
합이 N과 같다면 count를 1 증가시키고 종료 인덱슬르 오른쪽으로 이동시킨다.
*/

/* 투 포인터 이동 원칙
sum > N: sum = sum - start_index; start_index++; // N을 초과하므로 왼쪽의 범위를 줄인다.
sum < N: end_index++; sum = sum + end_index; // N보다 작으므로 오른쪽의 범위를 늘린다.
sum == N: end_index++; sum = sum + end_index; count++;
end_index가 N이 될 때까지 반복
*/

public class P006_TwoPointer { // 연속된 자연수의 합 구하기 (시간 복잡도 O(n))
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 1; // ex) N = 10일 때, 10인 경우를 count에 미리 포함한다.
        int start_index = 1;
        int end_index = 1;
        int sum = 1;
        while (end_index != N){ // N인 경우는 이미 초기화할 때 count했으므로 end_index가 N이 아닌 동안 반복한다.
            if (sum == N){
                count++; end_index++; sum = sum + end_index;
            } else if (sum > N){ // sum이 N을 초과하면
                sum = sum - start_index; start_index++; // 왼쪽의 범위를 줄여준다.
            } else { // sum이 N보다 작은 경우
                end_index++; // 오른쪽 범위를 늘려준다.
                sum = sum + end_index;
            }
        }
        System.out.println(count);
    }
}

/* 시간 복잡도 O(N^2)
public class P006_TwoPointer { // 연속된 자연수의 합 구하기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 합으로 나타낼 자연수 N
        int count = 0; // 가짓수
        for (int i = 1; i<=N; i++){
            int sum = 0;
            for (int j = i; j<=N; j++){
                sum += j;
                if (sum == N) {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
*/