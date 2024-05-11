import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		list.add("black");
		list.add("brown");
		list.add("red");
		list.add("orange");
		list.add("yellow");
   	    list.add("green");
	    list.add("blue");
	    list.add("violet");
	    list.add("grey");
	    list.add("white");
        int num1 = list.indexOf(sc.next())*10;
        int num2 = list.indexOf(sc.next());
        long num3 = list.indexOf(sc.next());
        System.out.println((num1+num2)*(long)Math.pow(10,num3));
    }
}