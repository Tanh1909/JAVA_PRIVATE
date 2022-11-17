package BAI_1_6;

import java.util.Scanner;

public class nhan_Vien {
	static int count = 0;
	private int id;
	private String hoTen;
	private String kieuNV;
	private int soNgayLam;
	private int namVaoLam;

	public nhan_Vien() {
		setId(++count);
	}

	public static String form(int a) {
		String s = String.valueOf(a);
		String u = "";
		int cnt = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			cnt++;
			u += s.charAt(i);
			if (cnt == 3 && i != 0) {
				u += ",";
				cnt = 0;
			}
		}
		s = "";
		for (int i = u.length() - 1; i >= 0; i--) {
			s += u.charAt(i);
		}
		return s;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getKieuNV() {
		return kieuNV;
	}

	public void setKieuNV(String kieuNV) {
		this.kieuNV = kieuNV;
	}

	public int getSoNgayLam() {
		return soNgayLam;
	}

	public void setSoNgayLam(int soNgayLam) {
		this.soNgayLam = soNgayLam;
	}

	public int getNamVaoLam() {
		return namVaoLam;
	}

	public void setNamVaoLam(int namVaoLam) {
		this.namVaoLam = namVaoLam;
	}

	public int getPhuCap() {
		return 100000 + 200000 * (2022 - namVaoLam);
	}

	public int getLuong() {
		if (kieuNV.equalsIgnoreCase("San Xuat")) {
			return 350000 * soNgayLam;
		} else {
			return 400000 * soNgayLam;
		}
	}

	public int getTong() {
		return getLuong() + getPhuCap();
	}

	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("NHAP HO TEN: ");
		hoTen = sc.nextLine();
		System.out.print("NHAP KIEU NHAN VIEN: ");
		kieuNV = sc.nextLine();
		System.out.print("NHAP SO NGAY LAM: ");
		soNgayLam = sc.nextInt();
		System.out.print("NHAP NAM VAO LAM: ");
		namVaoLam = sc.nextInt();
	}

	public void output() {
		System.out.printf("%-5d%-15s%-20s%-15d%-15d%-15s%-15s%-15s", id, hoTen, kieuNV, soNgayLam, namVaoLam,
				form(getLuong()), form(getPhuCap()), form(getTong()));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.print("NHAP SO LUONG NHAN VIEN");
		n = sc.nextInt();
		nhan_Vien[] arr = new nhan_Vien[n];
		for (int i = 0; i < n; i++) {
			System.out.println("NHAP THONG TIN NHAN VIEN THU: " + (i + 1));
			arr[i] = new nhan_Vien();
			arr[i].input();
			System.out.println();
		}
		System.out.printf("%-5s%-15s%-20s%-15s%-15s%-15s%-15s%-15s", "ID", "HO VA TEN", "KIEU NHAN VIEN", "SO NGAY LAM",
				"NAM VAO LAM", "LUONG", "PHU CAP", "TONG TIEN");
		System.out.println();
		for (int i = 0; i < n; i++) {
			arr[i].output();
			System.out.println();
		}
	}

}
