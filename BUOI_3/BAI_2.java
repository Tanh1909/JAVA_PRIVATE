import java.util.Scanner;

public class BAI_2 {
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
		boolean ok = true;
		for (int i = 0; i < n - 1; i++) {
			if (a[i + 1] - a[i] != 1) {
				ok = false;
				int res = a[i + 1] - a[i];
				int t = a[i];
				while (res != 1) {
					System.out.print((++t) + " ");
					res--;
				}
			}
		}
		if (ok == true) {
			System.out.println("YES");
		}
	}
}
