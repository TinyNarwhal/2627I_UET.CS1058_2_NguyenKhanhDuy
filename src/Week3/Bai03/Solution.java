package Week3.Bai03;

import java.io.*;
import java.util.*;

public class Solution {

    static class UndoAction {
        int type;
        String data;

        public UndoAction(int type, String data) {
            this.type = type;
            this.data = data;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Stack<UndoAction> stack = new Stack<>();

        for (int i = 0; i < q; i++) {
            String[] input = br.readLine().split(" ");
            int type = Integer.parseInt(input[0]);

            if (type == 1) {
                String w = input[1];
                stack.push(new UndoAction(1, String.valueOf(w.length())));
                sb.append(w);

            } else if (type == 2) {
                int k = Integer.parseInt(input[1]);
                String deletedStr = sb.substring(sb.length() - k);
                stack.push(new UndoAction(2, deletedStr));
                sb.delete(sb.length() - k, sb.length());

            } else if (type == 3) {
                int k = Integer.parseInt(input[1]);
                System.out.println(sb.charAt(k - 1));

            } else if (type == 4) {
                UndoAction action = stack.pop();

                if (action.type == 1) {
                    int len = Integer.parseInt(action.data);
                    sb.delete(sb.length() - len, sb.length());

                } else if (action.type == 2) {
                    sb.append(action.data);
                }
            }
        }
    }
}
