package BAI_1_6;

import java.util.Scanner;

public class sinh_Vien {
	Scanner sc = new Scanner(System.in);
	private static int cnt = 0;
	private int maSV;
	private String hoTen;
	private String diaChi;
	private String sdt;
	private double diem;

	public sinh_Vien() {
		setMaSV(++cnt);
	}

	public sinh_Vien(String hoTen, String diaChi, String sdt, double diem) {
		setMaSV(++cnt);
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.diem = diem;
	}

	public int getMaSV() {
		return maSV;
	}

	public void setMaSV(int maSV) {
		this.maSV = maSV;
	}

	public String getHoTen() {
		return hoTen;
	}

	public String getTen() {
		String s = "", u = "";
		for (int i = hoTen.length() - 1; i >= 0; i--) {
			if (hoTen.charAt(i) == ' ') {
				break;
			}
			s += hoTen.charAt(i);
		}
		for (int i = s.length() - 1; i >= 0; i--) {
			u += s.charAt(i);
		}
		return u;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public double getDiem() {
		return diem;
	}

	public void setDiem(double diem) {
		this.diem = diem;
	}

	public String toString() {
		return String.format("%-5d%-15s%-15s%-15s%-5f", maSV, hoTen, diaChi, sdt, diem);
	}

	public Boolean check(String sdt) {
		for (int i = 0; i < sdt.length(); i++) {
			if (sdt.charAt(i) < '0' || sdt.charAt(i) > '9') {
				return false;
			}
		}
		return true;
	}

	public void input() {
		do {
			System.out.print("NHAP HO TEN: ");
			hoTen = sc.nextLine();
			hoTen = hoTen.toLowerCase();
		} while (!hoTen.contains(" "));
		System.out.print("NHAP DIA CHI: ");
		diaChi = sc.nextLine();
		do {
			System.out.print("NHAP SDT: ");
			sdt = sc.next();
		} while (sdt.length() != 7 || !check(sdt));
		do {
			System.out.print("NHAP DIEM: ");
			diem = sc.nextDouble();
		} while (diem < 0 || diem > 10);

	}

	public void output() {
		System.out.printf("%-5d%-15s%-15s%-15s%-5f", maSV, hoTen, diaChi, sdt, diem);
		System.out.println();
	}

	public static void outputarr(sinh_Vien[] arr) {
		System.out.printf("%-5s%-15s%-15s%-15s%-5s", "MA SV", "HO TEN", "DIA CHI", "SDT", "DIEM");
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			arr[i].output();
		}
	}

	public static void sapXepTheoDiem(sinh_Vien[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i].getDiem() > arr[j].getDiem()) {
					sinh_Vien temp = new sinh_Vien();
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		sinh_Vien.outputarr(arr);
	}

	public static void timKiemTheoTen(sinh_Vien[] arr) {
		Scanner sc = new Scanner(System.in);
		String s;
		Boolean ok = false;
		System.out.print("NHAP TEN CAN TIM KIEM: ");
		s = sc.nextLine();
		s = s.toLowerCase();
		for (int i = 0; i < arr.length; i++) {
			if ((arr[i].getTen()).equals(s) == true) {
				ok = true;
				arr[i].output();
			}
		}
		if (ok == false) {
			System.out.println("KHONG TIM THAY SINH VIEN TEN: " + s);
		}
	}

	public static void SapXepTheoTen(sinh_Vien[] arr) {
		Scanner sc = new Scanner(System.in);
		System.out.println("BAN MUON SAP XEP THEO CHIEU: 1.TANG 2.GIAM");
		int luachon = sc.nextInt();
		if (luachon == 1) {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					if ((arr[i].getTen()).compareToIgnoreCase(arr[j].getTen()) < 0) {
						sinh_Vien temp = new sinh_Vien();
						temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					}
				}
			}
		} else if (luachon == 2) {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					if ((arr[i].getTen()).compareToIgnoreCase(arr[j].getTen()) > 0) {
						sinh_Vien temp = new sinh_Vien();
						temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					}
				}
			}
		}
		sinh_Vien.outputarr(arr);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("NHAP SO LUONG SINH VIEN");
		int n = sc.nextInt();
		sinh_Vien[] arr = new sinh_Vien[n];
		for (int i = 0; i < n; i++) {
			System.out.println("NHAP THONG TIN SINH VIEN THU: " + (i + 1));
			arr[i] = new sinh_Vien();
			arr[i].input();
		}
		System.out.println("======================MENU===================");
		System.out.println("1. XUAT DANH SACH");
		System.out.println("2. TIM KIEM");
		System.out.println("3. SAP XEP");
		System.out.println("4. EXIT");
		int luachon;
		do {
			System.out.println("NHAP LUA CHON: ");
			luachon = sc.nextInt();
			switch (luachon) {
			case 1: {
				sinh_Vien.sapXepTheoDiem(arr);
				break;
			}
			case 2: {
				sinh_Vien.timKiemTheoTen(arr);
				break;
			}
			case 3: {
				sinh_Vien.SapXepTheoTen(arr);
				break;
			}
			default: {
				if (luachon != 4) {
					System.out.println("LUA CHON KHONG DUNG");
				}
				break;
			}
			}

		} while (luachon != 4);

	}
}
