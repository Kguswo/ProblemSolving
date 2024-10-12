import java.io.*;

public class Main {
   public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

       String s1 = "`1234567890-=";
       String s2 = "QWERTYUIOP[]\\";
       String s3 = "ASDFGHJKL;'";
       String s4 = "ZXCVBNM,./";
       String[] keyboards = {s1, s2, s3, s4};

       String input = "";
       while((input = br.readLine()) != null){
           for(int i=0; i<input.length(); i++){
               char c = input.charAt(i);
               if(c == ' '){
                   bw.write(" ");
               }
               else{
                   for(int j=0; j<keyboards.length; j++){
                       if(keyboards[j].contains(c+"")){
                           bw.write(keyboards[j].charAt(keyboards[j].indexOf(c)-1));
                           break;
                       }
                   }
               }
           }
           bw.write("\n");
           bw.flush();
       }
   }
}