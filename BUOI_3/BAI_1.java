
import java.util.Arrays;
import java.util.Scanner;

public class BAI_1 {
	static int[] m = new int[1000000];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		do {
			System.out.println("NHAP N: ");
			n = sc.nextInt();
		} while (n < 2);
		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			System.out.print("NHAP A[" + i + "]: ");
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		for (int i = 0; i < n;) {
			int cnt = 1;
			int m = i;
			while ((m + 1) < n && a[m] == a[++m]) {
				cnt++;
			}
			System.out.println(a[i] + " : " + cnt);
			i += cnt;
		}

	}
}
