package BAI_1_6;

import java.util.Scanner;

public class OTO {
	private String chuSoHuu, tenXe, hang;
	private long gia;
	private int namMua;

	public String getChuSoHuu() {
		return chuSoHuu;
	}

	public void setChuSoHuu(String chuSoHuu) {
		this.chuSoHuu = chuSoHuu;
	}

	public String getTenXe() {
		return tenXe;
	}

	public void setTenXe(String tenXe) {
		this.tenXe = tenXe;
	}

	public String getHang() {
		return hang;
	}

	public void setHang(String hang) {
		this.hang = hang;
	}

	public long getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	public int getNamMua() {
		return namMua;
	}

	public void setNamMua(int namMua) {
		this.namMua = namMua;
	}

	public int getNamSD() {
		return 2022 - namMua;
	}

	public double getGiaTriHT() {
		if (gia < 1000000000) {
			return gia - (gia * 0.07 * getNamSD());
		} else if (gia < 2000000000) {
			return gia - (gia * 0.05 * getNamSD());
		} else {
			return gia - (gia * 0.03 * getNamSD());
		}
	}

	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("NHAP CHU SO HUU: ");
		chuSoHuu = sc.nextLine();
		System.out.print("NHAP TEN XE: ");
		tenXe = sc.nextLine();
		System.out.print("NHAP HANG: ");
		hang = sc.next();
		System.out.print("NHAP GIA: ");
		gia = sc.nextLong();
		System.out.print("NHAP NAM MUA: ");
		namMua = sc.nextInt();
	}

	public void output() {
		System.out.printf("%-15s%-15s%-15s%-15d%-15d%-15f", chuSoHuu, tenXe, hang, gia, getNamSD(), getGiaTriHT());
		System.out.println();
	}

	public static void outputXeHGT(OTO[] arr) {
		System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s", "CHU SO HUU", "TEN XE", "HANG", "GIA", "NAM SU DUNG",
				"GIA TRI HIEN TAI");
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].getGiaTriHT() <= 0) {
				arr[i].output();
			}
		}
	}

	public static void outputarr(OTO[] arr) {
		System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s", "CHU SO HUU", "TEN XE", "HANG", "GIA", "NAM SU DUNG",
				"GIA TRI HIEN TAI");
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i].getGiaTriHT() < arr[j].getGiaTriHT()) {
					OTO temp = new OTO();
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i].output();
		}
	}

	public static void main(String[] args) {
		System.out.println("NHAP SO LUONG OTO");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		OTO[] arr = new OTO[n];
		for (int i = 0; i < n; i++) {
			System.out.println("NHAP OTO THU: " + (i + 1));
			arr[i] = new OTO();
			arr[i].input();
		}
		OTO.outputarr(arr);
	}
}
