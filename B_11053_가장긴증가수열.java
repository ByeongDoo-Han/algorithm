package com.example.testproject;

import java.util.Arrays;
import java.util.Scanner;

public class B_11053_가장긴증가수열 {

    public static void main(String[] args) {
        solution();
    }
//    문제
//    수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.
//    예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.

//    input
//    6
//    10 20 10 30 20 50

//    output
//    4

    public static void solution(){
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        // 수열 입력
        String[] line = sc.nextLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }

        // dp 배열 생성
        int[] dp = new int[N];
        // dp 배열 1로 채움
        Arrays.fill(dp, 1);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                // 뒤 숫자가 앞 숫자보다 크면
                if(arr[j]< arr[i]){
                    // 기존 dp 배열에 있던 수에 1 더해서 넣는다.
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        // 기존 증가수열 길이는 저장되어 있으므로 n 번째 숫자에서는 n+1이랑만 비교 하면 된다.
        int result=0;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);
    }
}
