import java.util.Scanner;

public class BAI_4_4 {
	static Boolean check(char c) {
		if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
			return true;
		}
		return false;
	}

	static char up(char c) {
		if (c >= 'a' && c <= 'z') {
			c -= 32;
		}
		return c;
	}

	static char down(char c) {
		if (c >= 'A' && c <= 'Z') {
			c += 32;
		}
		return c;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean ok = false;
		System.out.println("NHAP CHUOI: ");
		String s = sc.nextLine();
		int cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == ' ') {
				ok = true;
				continue;
			}
			if (check(c) == true) {
				if (ok == true) {
					cnt++;
					if (cnt == 1) {
						System.out.print(up((char) c));
					} else {
						System.out.print(" " + up((char) c));
					}
					ok = false;
				} else {
					System.out.print(down((char) c));
				}

			}

		}
	}
}
