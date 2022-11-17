package BAI_1_6;

import java.util.*;
import java.util.Scanner;

public class NHAN_VIEN2 {
	private String hoTen;
	private int tuoi;
	private String gioiTinh;
	private String address;
	private int hoursWorked;
	private int hourlyRate;

	public NHAN_VIEN2() {

	}

	public NHAN_VIEN2(String hoTen, int tuoi, String gioiTinh, String address, int hoursWorked, int hourlyRate) {
		this.hoTen = hoTen;
		this.tuoi = tuoi;
		this.gioiTinh = gioiTinh;
		this.address = address;
		this.hoursWorked = hoursWorked;
		this.hourlyRate = hourlyRate;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getAddress() {
		return address;
	}

	public void setDiaChi(String address) {
		this.address = address;
	}

	public int getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(int hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	public int getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(int hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public double getSalary() {
		if (hoursWorked < 45) {
			return hoursWorked * hourlyRate;
		} else {
			return (45 + (hoursWorked - 45) * 1.5) * hourlyRate;
		}
	}

	public double getTax() {
		if (getSalary() > 300) {
			return getSalary() * 0.2;
		} else {
			return 0;
		}
	}

	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("NHAP DIA CHI: ");
		address = sc.nextLine();
		System.out.print("NHAP HO TEN: ");
		hoTen = sc.nextLine();
		System.out.print("NHAP TUOI: ");
		tuoi = sc.nextInt();
		System.out.print("NHAP GIOI TINH: ");
		gioiTinh = sc.next();
		System.out.print("NHAP SO GIOI LAM VIEC: ");
		hoursWorked = sc.nextInt();
		System.out.print("NHAP SO TIEN TRA CHO 1h: ");
		hourlyRate = sc.nextInt();

	}

	public void output() {
		System.out.printf("%-15s%-10d%-10s%-15s%-15f%-15f%-15s", hoTen, tuoi, gioiTinh, address, getSalary(), getTax(),
				hoursWorked);
		System.out.println();
	}

	public static void tieuDe() {
		System.out.printf("%-15s%-10s%-10s%-15s%-15s%-15s%-15s", "HO TEN", "TUOI", "GIOI TINH", "DIA CHI", "LUONG",
				"THUE", "GIO LAM VIEC");
		System.out.println();
	}

	public static void themNV(List<NHAN_VIEN2> input) {
		NHAN_VIEN2 x = new NHAN_VIEN2();
		Scanner sc = new Scanner(System.in);
		System.out.println("NHAP THONG TIN SINH VIEN: ");
		x.input();
		input.add(x);
	}

	public static void inDsNV(List<NHAN_VIEN2> input) {
		NHAN_VIEN2.tieuDe();
		for (NHAN_VIEN2 x : input) {
			x.output();
		}
	}

	public static void timKiemTheoTen(List<NHAN_VIEN2> input) {
		Scanner sc = new Scanner(System.in);
		String s;
		System.out.println("NHAP HO TEN NHAN VIEN CAN TIM KIEM: ");
		s = sc.nextLine();
		for (NHAN_VIEN2 x : input) {
			if (x.getHoTen().equalsIgnoreCase(s)) {
				x.output();
			}
		}
	}

	public static void top3(List<NHAN_VIEN2> input) {
		for (int i = 0; i < input.size(); i++) {
			for (int j = i + 1; j < input.size(); j++) {
				if (input.get(i).getHoursWorked() < input.get(j).getHoursWorked()) {
					NHAN_VIEN2 temp = input.get(i);
					input.set(i, input.get(j));
					input.set(j, temp);
				}
			}
		}
		System.out.println("TOP 3 CON ONG CHAM CHI: ");
		for (int i = 0; i < Math.min(3, input.size()); i++) {
			input.get(i).output();
		}
	}

	public static void main(String[] args) {
		ArrayList<NHAN_VIEN2> arr = new ArrayList<NHAN_VIEN2>();
		Scanner sc = new Scanner(System.in);
		System.out.println("NHAP SO LUONG NHAN VIEN");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println("NHAP SINH VIEN THU: " + (i + 1));
			NHAN_VIEN2 x = new NHAN_VIEN2();
			x.input();
			arr.add(x);
		}
		System.out.println("======================MENU===================");
		System.out.println("1. THEM MOT NHAN VIEN");
		System.out.println("2. DANH SACH NHAN VIEN");
		System.out.println("3. TOP 3 CON ONG CHAM CHI");
		System.out.println("4. TIM KIEM THEO HO TEN");
		System.out.println("0.EXIT");
		int luachon;
		do {
			System.out.println("NHAP LUA CHON: ");
			luachon = sc.nextInt();
			switch (luachon) {
			case 1: {
				System.out.println("NHAP THONG TIN NHAN VIEN: ");
				NHAN_VIEN2 a = new NHAN_VIEN2();
				a.input();
				arr.add(a);
				break;
			}
			case 2: {
				NHAN_VIEN2.inDsNV(arr);
				break;
			}
			case 3: {
				NHAN_VIEN2.top3(arr);
				break;
			}
			case 4: {
				NHAN_VIEN2.timKiemTheoTen(arr);
				break;
			}

			default: {
				if (luachon != 0) {
					System.out.println("LUA CHON KHONG DUNG");
				}
				break;
			}
			}

		} while (luachon != 0);
	}
}
