package DataStructure;
import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

/* 백준 온라인 저지 11003번 최솟값 찾기 (73~76p)
정렬 알고리즘을 사용하지 않고도 슬라이딩 윈도우와 덱을 이용해 정렬 효과를 보는 것이 이 문제의 핵심이다.
*/

public class P010 { // 슬라이딩 윈도우 안에서 최솟값 찾기
    public static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력을 버퍼에 넣고 한 번에 출력하기 위해 BufferedWriter 사용
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 데이터 개수
        int L = Integer.parseInt(st.nextToken()); // 최솟값을 구하는 범위
        st = new StringTokenizer(br.readLine());
        Deque<Node> mydeque = new LinkedList<>(); // 데이터를 담을 덱 자료구조
        for (int i = 0; i < N; i++){
            int now = Integer.parseInt(st.nextToken());
            // 새로운 값이 들어올 때마다 정렬 대신 현재 수(now)보다 큰 값을 덱에서 제거해 시간 복잡도를 줄임

            while (!mydeque.isEmpty() && mydeque.getLast().value > now) {
                mydeque.removeLast();
            }
            mydeque.addLast(new Node(now, i));
            // 범위(슬라이딩 윈도우 크기)에서 벗어난 값은 덱에서 제거
            if (mydeque.getFirst().index <= i - L){
                mydeque.removeFirst();
            }
            bw.write(mydeque.getFirst().value +  " ");
        }
        bw.flush();
        bw.close();
    }

    static class Node {
        public int value;
        public  int index;

        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
