import java.util.Scanner;

public class BAI_3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.println("NHAP N: ");
		n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.print("NHAP A[" + i + "]: ");
			a[i] = sc.nextInt();
		}
		int cnt = 1;
		int max = cnt;
		for (int i = 0; i < n - 1; i++) {
			if (a[i] <= a[i + 1]) {
				cnt++;
			} else {
				max = Math.max(max, cnt);
				cnt = 1;
			}
		}
		max = Math.max(cnt, max);
		System.out.println(max);
	}
}
