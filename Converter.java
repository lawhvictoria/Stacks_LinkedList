import java.util.EmptyStackException;
import java.util.Scanner;

/**
 *
 * @author Victoria Law
 * vhlaw@calpoly.edu
 * January 21,2016
 * Project 1
 */
public class Converter {
    
    public Converter() // creating a constructor
    {
    }
    
    public static String infixToPostfix (String expression)
    {
        MyStack<String> stack = new MyStack<>(); // creates a new stack.
        String postfix = ""; // this is the output of the function
        
        String[] str = expression.split(" "); //this splits the expression by white spaces.
        
        for(int i = 0; i < str.length; i++) // parse through the expression.
        {
            switch(str[i])
            {
            	case "(":
            		stack.push(str[i]);
            		break;
            
            	case ")":
            		while(true) // the while loop first check if the stack is empty, it it's not, it pops off each element and appends the symbol to the output expression.
            		{
            			if(stack.isEmpty())
            			{
            				break;
            			}
            			
            			String exp = stack.pop();
            			
            			if(!exp.equals("("))
            			{
            				postfix = postfix + exp + " ";
            			}
            			
            			else
            			{
            				break;
            			}
            		}
            		break;
            		
            	case "*":
            		while(true)
            		{
    					if(stack.isEmpty())
    					{
    						stack.push(str[i]);
    						break;
    					}
    					
    					if(stack.peek().equals("/") || stack.peek().equals("*"))
    					{
    						String exp = stack.pop();
    						postfix = postfix + exp + " ";
    					}
    					
    					else
    					{
    						stack.push(str[i]);
    						break;
    					}
    				}
    				break;   
    				
            	case "/":
            		while(true)
            		{
            			if(stack.isEmpty())
            			{
            				stack.push(str[i]);
            				break;
            			}
            			
            			if(stack.peek().equals("/") || stack.peek().equals("*")) // use .equals instead of == because comparing objects, not primitives.
            			{
            				String exp = stack.pop();
            				postfix = postfix + exp + " ";
            			}
            			
            			else
            			{
            				stack.push(str[i]);
            				break;
            			}
            		}
            		break;

    				
            	case "+":
            		while(true)
            		{
            			if(stack.isEmpty())
            			{
            				stack.push(str[i]);
            				break;
            			}
            		
            			if(stack.peek().equals("/") || stack.peek().equals("*") || stack.peek().equals("+") || stack.peek().equals("-"))
            			{
            				String exp = stack.pop();
            				postfix = postfix + exp + " ";
            			}
					
            			else
            			{
            				stack.push(str[i]);
            				break;
            			}
            		}
            		break;
            		
            	case "-":
            		while(true)
            		{
    					if(stack.isEmpty())
    					{
    						stack.push(str[i]);
    						break;
    					}
            		
    					if(stack.peek().equals("/") || stack.peek().equals("*") || stack.peek().equals("+") || stack.peek().equals("-"))
    					{
    						String exp = stack.pop();
    						postfix = postfix + exp + " ";
    					}
    					
    					else
    					{
    						stack.push(str[i]);
    						break;
    					}
            		}
    				break;
    				
    			default:
    				postfix = postfix + str[i] + " ";
    			}
        }
        
        while(!stack.isEmpty())
        {
        	postfix = postfix + stack.pop() + " ";
        }
        
        return postfix;
}
    
    public static double postfixValue(String expression)
    {
    	MyStack<String> stack = new MyStack<>(); // creates a new empty stack.
        double result = 0;
        double num1; //this is to store the first integer after popping off of the stack. 
        double num2; //this is to store the second integer after popping off of the stack.
        
        String[] str = expression.split(" "); //this splits the expression by white spaces.
        
        for(int i = 0; i < str.length; i++) // parse through the expression.
        {
        	switch(str[i])
        	{
        		case "+":
        			try
        			{
        				num1 = Double.parseDouble(stack.pop());
        				num2 = Double.parseDouble(stack.pop());
        				stack.push(Integer.toString((int)(num1+num2)));
        			}
        			catch(Exception e)
        			{
        			}
        			break;
        	
        		case "-":
        			try
        			{
        				num1 = Double.parseDouble(stack.pop());
        				num2 = Double.parseDouble(stack.pop());
        				stack.push(Integer.toString((int)(num2-num1)));
        			}
        			catch(Exception e)
        			{
        			}
        			break;
        
        		case "*":
        			try
        			{
        				num1 = Double.parseDouble(stack.pop());
        				num2 = Double.parseDouble(stack.pop());
        				stack.push(Integer.toString((int)(num2*num1)));
        			}
        			catch(Exception e)
        			{
        			}
        			break;
        			
        		case "/":
        			try
        			{
        				num1 = Double.parseDouble(stack.pop());
        				num2 = Double.parseDouble(stack.pop());
        				stack.push(Integer.toString((int)(num2/num1)));
        			}
        			catch(Exception e)
        			{
        			}
        			break;
        			
        		default:
        			stack.push(str[i]);
        	}
        }
        return Double.parseDouble(stack.pop());
    }
}   
