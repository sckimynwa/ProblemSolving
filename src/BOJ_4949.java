import java.util.*;
import java.io.*;

public class BOJ_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            String str = br.readLine();
            if(str.equals(".")) break;
            Stack<Character> charStack = new Stack();
            int strLen = str.length();
            boolean flag = false;

            for(int i=0;i<strLen;i++) {
                if(str.charAt(i)=='(') charStack.push('(');
                else if(str.charAt(i)=='[') charStack.push('[');
                else if(str.charAt(i)==')') {
                    if(charStack.empty()) {
                        bw.write("no\n");
                        flag = true;
                        break;
                    } else {
                        char tmp = charStack.peek();
                        if(tmp != '(') {
                            bw.write("no\n");
                            flag = true;
                            break;
                        } else {
                            charStack.pop();
                        }
                    }
                }
                else if(str.charAt(i)==']') {
                    if(charStack.empty()) {
                        bw.write("no\n");
                        flag = true;
                        break;
                    } else {
                        char tmp = charStack.peek();
                        if(tmp != '[') {
                            bw.write("no\n");
                            flag = true;
                            break;
                        } else {
                            charStack.pop();
                        }
                    }
                }
            }
            if(!flag && charStack.empty()) bw.write("yes\n");
            else if(!flag && !charStack.empty()) bw.write("no\n");
        }

        bw.flush();
        bw.close();
    }
}
