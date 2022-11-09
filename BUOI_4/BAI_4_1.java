import java.util.Scanner;

public class BAI_4_1 {
	static int[] cnt = new int[256];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("NHAP CHUOI: ");
		String s = sc.nextLine();
		for (int i = 0; i < s.length(); i++) {
			cnt[s.charAt(i)]++;
		}
		for (int i = 0; i < s.length(); i++) {
			if (cnt[s.charAt(i)] != 0 && s.charAt(i) != ' ') {
				System.out.println(s.charAt(i) + ": " + cnt[s.charAt(i)]);
				cnt[s.charAt(i)] = 0;
			}

		}
	}
}
