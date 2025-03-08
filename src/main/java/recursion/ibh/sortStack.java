package recursion.ibh;

import java.util.Stack;

public class sortStack {

    public static Stack<Integer> sort(Stack<Integer> stack){
        if(stack.size()==1){
            return stack;
        }
        int temp = stack.pop();
        sort(stack);

        insert(stack,temp);
        return stack;
    }

    public static void insert(Stack<Integer> stack,int temp){
        if( stack.empty() || temp>=stack.peek() ){
            stack.push(temp);
            return;
        }
        int newTemp=stack.pop();
        insert(stack,temp); // NOTE- This is temp not newTemp
        stack.push(newTemp);
    }



    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(5);
        stack.push(1);
        stack.push(5);

        sort(stack);
        while(!stack.isEmpty()){
            int ele=stack.pop();
            System.out.println(ele);
        }
    }

}
