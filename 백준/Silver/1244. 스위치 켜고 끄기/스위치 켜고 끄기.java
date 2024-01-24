import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int[] Arr = new int[a];
		//배열채우기
		for(int i=0; i<Arr.length;i++ ) {
			int b = sc.nextInt();
			Arr[i] = b;
		}
		
		//몇번 스위칭 할것인가
		int c = sc.nextInt();
		for(int i=0; i<c; i++) {
			int d = sc.nextInt();//성별
			int e = sc.nextInt();//번호
			
			if(d==1) {	//남자(배수)
				for(int j=(e-1); j<a; j+=e) {
					Arr[j] = 1- Arr[j];
				}	
			}
			
			else {	//여자(양쪽)
				int f = e -2;
				int g = e;
                Arr[e-1] = 1- Arr [e-1];//일단 선택한 스위치는 바뀜
               					
				while(f>=0 && g<Arr.length && Arr[f]==Arr[g]) { //양옆같을때
				    Arr[f] = 1- Arr[f];
					Arr[g] = 1- Arr[g];
					f--;
					g++;
				}
			}
		}	

		for(int i=0; i<a; i++) {  //출력
			System.out.print(Arr[i]+" ");
            if ((i + 1) % 20 == 0) {
                System.out.println();
            }
		}
		sc.close();
		}
	}
