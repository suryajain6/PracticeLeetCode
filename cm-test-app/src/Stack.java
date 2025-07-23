public class Stack {

    int top;
    int stackarray[];

    public Stack(int top, int stackarray[]){
        this.top = -1;
        this.stackarray = new int[5];
    }

    public void push(int data){
        stackarray[++top] =data;
    }

    public int pop(){
        return stackarray[top--];
    }

    public int top(){
        return stackarray[top];
    }

   /* public static boolean ispar(String s) {
        // Declare a stack to hold the previous brackets.
        Stack stk = new Stack();
        for (int i = 0; i < s.length(); i++) {

            // Check if the character is an opening bracket
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stk.push(s.charAt(i));
            }
            else {

                // If it's a closing bracket, check if the stack is non-empty
                // and if the top of the stack is a matching opening bracket
                if (!stk.empty() &&
                        ((stk.peek() == '(' && s.charAt(i) == ')') ||
                                (stk.peek() == '{' && s.charAt(i) == '}') ||
                                (stk.peek() == '[' && s.charAt(i) == ']'))) {
                    stk.pop();
                }
                else {
                    return false; // Unmatched closing bracket
                }
            }
        }

        // If stack is empty, return true (balanced),
        // otherwise false
        return stk.empty();

    }*/


}
