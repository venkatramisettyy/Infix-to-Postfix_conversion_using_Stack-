public class Infix_to_Postfix 
{
	   public boolean checkIfOperand(char ch)
	    {
	        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
	    }

	    // Function to compare precedence
	    // If we return larger value means higher precedence
	    public int precedence(char ch)
	    {

	    		if(ch=='+' || ch=='-')
	    			return 1;
	    		 
	    			else if(ch=='*' || ch=='/')
	    				return 2;                       // * and / divide have higher precedence.
		    			
	    				if(ch=='^')
	    					return 3;
		    	
	    		  return -1;
	    }
		

	public void InfixToPostfix(String expr)
	{
	    int i;
	    Stack s = new Stack(expr.length());
	    String result = "";
	    
	    for (i = 0; i < expr.length(); i++)
	    {
	        // Here we are checking is the character we scanned is operand or not
	        // and this adding to output.
	        if (checkIfOperand(expr.charAt(i)))
	        {
	            result = result + expr.charAt(i);
	        }
	            // Here, if we scan the character ‘(‘, we need to push it to the stack.
	        else if (expr.charAt(i) == '(')
	        {
	            s.push(expr.charAt(i));
	        }
	            // Here, if we scan character is an ‘)’, we need to pop and print from the stack
	            // do this until an ‘(‘ is encountered in the stack.
	        else if (expr.charAt(i) == ')')
	        {
	            while (!s.isEmpty() && s.peek() != '(')
	            {
		            result = result + s.peek();
	                s.pop();
	            }
	            if (!s.isEmpty() && s.peek() != '(')
	                return; // invalid expression
	            else
	                s.pop();
	        }
	        else // if an operator
	        {
	            while (!s.isEmpty() && precedence(expr.charAt(i)) <= precedence(s.peek()))
	            {
		            result = result + s.peek();
	                s.pop();
	            }
	            s.push(expr.charAt(i));
	        }

	    }

	    // Once all initial expression characters are traversed
	    // adding all left elements from stack to expression
	    while (!s.isEmpty())
	    {
           result = result + s.peek();
	        s.pop();
	    }
	    System.out.println(result);
	    }
	
	  public static void main(String[] args) 
	  {
		  Infix_to_Postfix a = new Infix_to_Postfix ();

		    System.out.println("Infix Expression: "+"\nA*(B*C+D*E)+F");		//(A+B)*(C+D)
		    System.out.println();

			System.out.println("Postfix Expression: ");

		   a.InfixToPostfix("A*(B*C+D*E)+F");
		   
	  }
}