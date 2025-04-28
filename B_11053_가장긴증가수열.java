package com.example.testproject;

import java.util.Arrays;
import java.util.Scanner;

public class B_11053_가장긴증가수열 {
    /*
    11
    67 154 11 237 200 248 197 44 128 157 161 201 193 171 127 35 211 166 10 197 203 6 243 183 182 92 222 89 163 3
    1  2   1  3
    4 3 4 2 1 1 1 4 3 2 1
     */

    public static void main(String[] args) {
        solution();
    }

    public static void solution(){
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        String[] line = sc.nextLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[j]< arr[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int result=0;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);
    }
}
