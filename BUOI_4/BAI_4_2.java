import java.util.Scanner;

public class BAI_4_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1, str2, str3 = "";
		int cnt = 0, max = 0;
		System.out.println("NHAP CHUOI 1: ");
		str1 = sc.nextLine();
		System.out.println("NHAP CHUOI 2: ");
		str2 = sc.nextLine();
		for (int i = 0; i < str2.length(); i++) {
			String s = str2.substring(i, i + 1);
			str3 = str3.concat(s);
			if (str1.contains(str3) == false || s.compareTo(" ") == 0) {
				max = Math.max(max, cnt);
				str3 = "";
				cnt = 0;
			} else {
				cnt++;
			}
		}

		max = Math.max(max, str3.length());
		System.out.println(max);

	}
}
