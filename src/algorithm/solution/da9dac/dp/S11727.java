package algorithm.solution.da9dac.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import algorithm.problem.baekjoon.dp.P11727;

public class S11727 implements P11727 {
	// https://da9dac.tistory.com/271

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		if (n == 1) {
			System.out.println(1);
			return;
		}

		int[] dp = new int[n + 1];

		dp[1] = 1;
		dp[2] = 3;

		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i-1] + dp[i-2] + dp[i-2]) % 10007;
		}

		System.out.println(dp[n]);
	}
}
