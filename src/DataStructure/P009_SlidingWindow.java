package DataStructure;
/* Sliding Window
부분 문자열의 길이 P인 윈도우를 배열 S의 시작점에 놓는다.
윈도우를 오른쪽으로 밀면서 윈도우에 잡힌 값들이 조건에 맞는지 탐색한다.
배열 S의 길이만큼만 탐색하므로 시간 복잡도는 O(n)이다.
*/

/* 윈도우를 한 칸씩 오른쪽으로 밀면서 현재 상태 배열을 업데이트한다.
업데이트 후에는 비밀번호 체크 배열과 비교하여 비밀번호 유효성을 판단한다. (checkSecret)
(***) 현재 상태 배열을 업데이트할 때는 빠지는 문자열, 신규 문자열만 보고 업데이트한다. (별도 함수)
기존 검사 결과에 새로 들어온 문자열, 제거되는 문자열만 반영하여 확인하는 것이 핵심이다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P009_SlidingWindow { // DNA 비밀번호
    static int checkArr[]; // 비밀번호 체크 배열
    static int myArr[]; // 현재 상태 배열
    static int checkSecret; // 개수 충족 개수 (유효성 검사를 위함)

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int S = Integer.parseInt(st.nextToken()); // 입력 받는 문자열의 크기
        int P = Integer.parseInt(st.nextToken()); // 부분 문자열의 크기
        int Result = 0;
        char A[] = new char[S]; // 입력 받는 문자 담는 변수
        checkArr = new int[4]; // A,C,G,T 4개 문자 (문제에 제시된 조건)
        myArr = new int[4];
        checkSecret = 0;
        A = bf.readLine().toCharArray(); // 문자열을 문자 배열로 변경
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < 4; i++) { // 윈도우에 포함되어야 하는 A,C,G,T 최소 개수 지정
            checkArr[i] = Integer.parseInt(st.nextToken());
            if (checkArr[i] == 0){
                checkSecret++; // 최소 개수가 0이면 조건 중촉하므로
            }
        }
        for (int i = 0; i < P; i++){ // 초기 P 부분 문자열 처리 부분
            Add(A[i]);
        }
        if (checkSecret == 4){
            Result++;
        }
        // 슬라이딩 윈도우 처리 부분
        for (int i = P; i < S; i++){
            int j = i - P; // 윈도우가 한 칸 밀리면서 빠지는 제일 앞 인덱스
            Add(A[i]); // 새로 들어온 문자 개수 업데이트
            Remove(A[j]); // 빠지게 된 문자 개수 업데이트
            if (checkSecret == 4){ // 유효성 검사 (최소 개수 조건 4개가 모두 충족될 때)
                Result++;
            }
        }
        System.out.println(Result);
        bf.close();
    }

    // 새로 들어온 문자를 처리하는 함수
    private static void Add(char c){
        switch (c) {
            case 'A':
                myArr[0]++; // A의 인덱스가 0이므로
                if (myArr[0] == checkArr[0]){ // 최소 개수 충족 여부 검사
                    checkSecret++; // 충족하면 유효성 검사용 변수를 1 증가시킴
                }
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1]){
                    checkSecret++;
                }
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2]){
                    checkSecret++;
                }
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3]){
                    checkSecret++;
                }
                break;
        }
    }

    private static void Remove(char c){
        switch (c) {
            case 'A':
                if (myArr[0] == checkArr[0]){
                    checkSecret--;
                }
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == checkArr[1]){
                    checkSecret--;
                }
                myArr[1]--;
                break;
            case 'G':
                if (myArr[2] == checkArr[2]){
                    checkSecret--;
                }
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArr[3]){
                    checkSecret--;
                }
                myArr[3]--;
                break;
        }
    }
}
