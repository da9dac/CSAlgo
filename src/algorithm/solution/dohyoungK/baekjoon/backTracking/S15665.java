package algorithm.solution.dohyoungK.baekjoon.backTracking;

import algorithm.problem.baekjoon.backTracking.P15665;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class S15665 implements P15665 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int M;
    static int[] nums;
    static Deque<String> sequence = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        findSequence();

        bw.flush();
        bw.close();
    }

    // before 변수를 사용해 for문 내에서
    // 중복되는 수의 재귀를 체크, 중단
    private static void findSequence() throws IOException {
        if (sequence.size() == M) {
            bw.write(String.join(" ", sequence) + "\n");
            return;
        }

        int before = 0;
        for (int i = 0; i < nums.length; i++) {
            if (before == nums[i]) continue;

            before = nums[i];
            sequence.add(String.valueOf(nums[i]));
            findSequence();
            sequence.pollLast();
        }
    }
}
