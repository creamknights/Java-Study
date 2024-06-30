package DataStructure;
import java.util.Scanner;
import java.util.Stack;

/* 오름차순 수열
1로 초기화된 자연수 num을 1씩 오름차순으로 증가시킨다. 즉 스택에 오름차순 자연수를 push한다.
이 num과의 비교를 통해 스택에 오름차순으로 자연수를 push하고, 입력 받은 수열과 값을 맞추기 위해(수열 값을 배열에 담은 순서대로 pop) pop한다.
입력 받은 수열 A의 값들이 순차적으로 출력되도록 push와 pop 연산을 수행하는 것이다.
push 연산은 +, pop 연산은 -로 출력하고, 오름차순 수열을 만드는 게 불가능할 때는 NO를 출력한다.
*/

/* 요약하자면 스택에 1부터 자연수를 오름차순으로 쌓으면서(1,2,3,4...)
입력받은 수열 [4,3,6,8,7,5,2,1] 이 그대로 출력되도록 push와 pop을 수행하는 것이다. (++++--++-++-----)
*/

public class P011_Stack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 수열의 개수
        int[] A = new int[N]; // 수열을 저장할 배열
        for (int i = 0; i < N; i++){
            A[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>(); // 스택 생성
        StringBuffer bf = new StringBuffer(); // 결과 문자열 저장을 위한 StringBuffer 객체 생성
        int num = 1; /* 오름차순 자연수 (스택에 추가될 다음 자연수를 의미) */
        boolean result = true; // 수열 생성 가능 확인을 위한 플래그
        for (int i = 0; i< A.length; i++) {
            int su = A[i]; // 현재 수열의 값
            if (su >= num) { // 현재 수열 값 >= 오름차순 자연수: 값이 같아질 때까지 자연수를 오름차순으로 push() 수행 ex) 현재 수열의 값이 4면 num을 오름차순으로 push. 1, 2, 3, 4를 push한다.
                while (su >= num) { // 4까지 push하고 나면 num은 5가 되어 (4>=5) 조건을 더 이상 만족하지 않는다.
                    stack.push(num++);
                    bf.append("+\n"); // push는 +로 출력
                }
                stack.pop(); // 스택의 맨 위(top) 값 4를 pop하여 현재 수열의 값과 맞춘다. 스택에는 1,2,3이 남는다. (3이 top)
                bf.append("-\n"); // pop은 -로 출력
            }
            else { // 현재 수열 값 < 오름차순 자연수: pop()을 수행해 수열의 원소를 변수 n에 저장한다.
                int n = stack.pop();
                // 스택의 가장 위의 값이 현재 수열 값보다 크다면 수열을 재현할 수 없다.
                // 스택에 1,2,3,4,5(top)가 쌓여 있는데 현재 수열 값(su)이 3(3<5)인 경우, 3을 출력해야 하는데 3을 출력하려면 top인 5(n)부터 꺼내야 한다.
                // 따라서 수열을 재현을 할 수 없다.
                if (n > su) { // 수열을 재현할 수 없으므로 NO를 출력하고 문제를 종료한다.
                    System.out.println("NO");
                    result = false;
                    break;
                }
                else { // (n <= su)
                    bf.append("-\n");
                }
            }
        }
        if (result) System.out.println(bf.toString());
    }
}
