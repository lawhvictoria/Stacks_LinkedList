import java.util.Scanner;

public class ConTest {
        public static void main(String[] args) {
        	
            Scanner scan = new Scanner(System.in);        	
            Converter con = new Converter();
            boolean cont = true;            
        
            System.out.println("Choose one of the following operations:\n" +
                    " Infix to postfix conversion (enter the letter i)\n" +
                    " Postfix expression evaluation (enter the letter p),\n" +
                    " Arithmetic expression evaluation (enter the letter a)\n" +
                    " Quit the program (enter the letter q)");

            while(cont)
            {
                System.out.println("Choose an operation: ");
                String choice = scan.nextLine();   

                switch(choice)
                {
                    case "i":
                        System.out.println("Please enter an expression: ");
                        System.out.println("The postfix expression is: " + con.infixToPostfix(scan.nextLine()));
                        break;
                        
                    case "p":
                        System.out.println("Please enter an expression: ");
                        System.out.println("The value of the postfix expression is:" + con.postfixValue(scan.nextLine()));
                        break;
                        
                    case "a":
                        System.out.println("Please enter an expression: ");
                        System.out.println("The value of the arithmetic expression is: " + con.postfixValue(con.infixToPostfix(scan.nextLine())));
                        break;
                        
                    case "q":
                        System.out.println("GoodBye!");
                        cont = false;
                        break;
                        
                    default:
                        System.out.println("Wrong Menu Choice!");
                }
            }
        }
}