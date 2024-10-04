import java.util.*;
public class infix_conversion {
    public static void main(String[] args) {
   String str="a+b*c";
        Stack<String> prefix=new Stack<>();
        Stack<String> postfix=new Stack<>();
Stack<Character> op =new Stack<>();
for(int i=0;i<str.length();i++){
    char ch=str.charAt(i);
    if(ch=='('){
        op.push(ch);
    
    }
 if((ch>=0&&ch<=9)||(ch>='A'&& ch<='Z')||(ch>='a'&& ch<='z')){
    prefix.push(ch+"");
    postfix.push(ch+"");
    
    }
    else if( ch==')'){
        while(op.size()>0 &&op.peek()!='('){
           char ops= op.pop();
   String  postv2=postfix.pop();
    String postv1=postfix.pop();
   String postv=postv1+postv2+ops;
    postfix.push(postv);
    String prev2= prefix.pop();
   String pre1=prefix.pop();
   String preva=ops+pre1+prev2;
prefix.push(preva);
        }
        op.pop();
    }
      else if(ch=='+' || ch=='-'||ch=='*'||ch=='/'){
    while(op.size()>0 && op.peek()!='(' &&(precedence(ch)<=precedence(op.peek()))){
        char ops= op.pop();
        String  postv2=postfix.pop();
         String postv1=postfix.pop();
        String postv=postv1+postv2+ops;
         postfix.push(postv);
         String prev2= prefix.pop();
        String pre1=prefix.pop();
        String preva=ops+pre1+prev2;
     prefix.push(preva);
     }
     op.push(ch);
    }
  
}
while(op.size()>0){
    char ops= op.pop();
    String  postv2=postfix.pop();
     String postv1=postfix.pop();
    String postv=postv1+postv2+ops;
     postfix.push(postv);
     String prev2= prefix.pop();
    String pre1=prefix.pop();
    String preva=ops+pre1+prev2;
 prefix.push(preva);
}

    System.out.println(postfix.peek());
    System.out.println(prefix.peek());

    }
    public static int precedence(char optor){
        if(optor=='+'){
        return 1;
        }
        else if(optor=='-'){
        return 1;
        }
        else if(optor=='*'){
        return 2;
        }
        else{
        return 2;
        }
    }
}
