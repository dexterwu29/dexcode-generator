package com.yupi.acm;

import java.util.Scanner;

/**
* ACM ����ģ�壨����֮�ͣ�
*
* @author dex111
*/
public class MainTemplate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            // ��ȡ����Ԫ�ظ���
            int n = scanner.nextInt();

            // ��ȡ����
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            }

            // ���������߼���������Ҫ�������
            // ʾ������������Ԫ�صĺ�
            int sum = 0;
            for (int num : arr) {
                sum += num;
            }

            System.out.println("today's output: " + sum);
        }
        scanner.close();
    }
}
