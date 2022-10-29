import java.util.Scanner;

public class BAI_4 {
	static boolean nguyento(int n) {
		for(int i=2;i<=Math.sqrt(n);i++) {
			if(n%i==0) {
				return false;
			}
		}
		return n>1;
	}
	static boolean xuly(int n) {
		if(nguyento(n)==false) {
			return false;
		}
		while(n!=0) {
			if(nguyento(n%10)==false) {
				return false;
			}
			n/=10;
		}
		return true;
	}
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
		boolean ok=false;
		for(int i=0;i<n;i++) {
			if(xuly(a[i])==true) {
				ok=true;
				System.out.print(a[i]+" ");
			}
		}
		if(ok==false) {
			System.out.println("NO");
		}
	}
}
