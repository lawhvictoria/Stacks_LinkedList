import java.util.Scanner;

public class StackTest {
    public static void main(String[] args) {
        // TODO code application logic here
        MyStack<String> stack = new MyStack<>();
        
        System.out.println("Choose one of the following operations:\n" +
                " Push/Add (enter the letter a)\n" +
                " Pop/Delete (enter the letter d)\n"+ 
                "  Peek (enter the letter p)\n" +
                " Check if the stack is empty (enter the letter e)\n" +
                " quit (enter the letter q)");
        Scanner scan = new Scanner(System.in);
        
        boolean cont = true;
        while(cont)
        {
            System.out.println("Choose an operation: ");
            String c = scan.next();            
            
            char choice = 'i';
            if(c.length() ==  1)
            {
                choice = c.charAt(0);
            }
            
            switch(choice)
            {
                case 'a':
                    System.out.println("Please enter a input value: ");
                    if(scan.hasNext())
                    {
                        String num = scan.next();
                        stack.push(num);
                        System.out.println(num + " Pushed In");
                    }
                    else
                    {
                        scan.next();
                        System.out.println("Invalid Choice");
                    }
                    break;

                case 'd':
                    try{
                        String pop = stack.pop();
                        System.out.println(pop + " Popped Out");                    
                    }
                    catch(Exception MyException){
                        System.out.println("Invalid operation: The Stack is Empty!");
                    }
                    break;
                    
                case 'p':
                    try{
                        String peek = stack.peek();
                        System.out.println(peek + " On Top");
                    }
                    catch(Exception MyException)
                    {
                        System.out.println("Invalid operation: The Stack is Empty!");
                    }
                    break;

                case 'e':
                    String s = "Not Empty";
                    if(stack.isEmpty())
                    {
                        s = "Empty!";
                    }
                    System.out.println(s);
                    break;

                case 'q':
                    System.out.println("GoodBye!");
                    cont = false;
                    break;
                    
                default:
                    System.out.println("Invalid menu choice!");
            }
        }               
    }
    
}