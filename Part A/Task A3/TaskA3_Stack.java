class Main {
    public static void main(String[] args) {
     char[] exp = {'5','8','*','2','/','9','+','7','-'};
     int size = exp.length;
     int[] stack = new int[size];
     int top = -1;
     int poppedNum1;
	 int poppedNum2;
	 int result = 0;
        
for(int i=0; i<size; i++) {
    if(exp[i] >= '0' && exp[i] <= '9') {
       if(top == size-1) {
      System.out.println("Stack is full!");
           }
    else{
      top++;
      stack[top] = exp[i] - '0';
      }     
    } 
else {
    if(top < 1) {
        System.out.println("Insufficient operands!");
    }
    else{
        poppedNum1 = stack[top];
          top--;
          poppedNum2 = stack[top];
          top--;
        switch(exp[i]) {
               case '*':
	                    result = poppedNum2 * poppedNum1;
                break;
                
               case '/':
	                    result = poppedNum2 / poppedNum1;
                break;
                
	           case '+': 
	                    result = poppedNum2 + poppedNum1;
                break;
                
               case '-':
	                    result = poppedNum2 - poppedNum1;
                break;
        }
          top++;
          stack[top] = result;
    }
  }
}
 if(top < 0) {
    System.out.println("Stack is empty!"); 
 } else {
     System.out.println("The result of the expression is: " + stack[top]);
     }
   }
 }  
