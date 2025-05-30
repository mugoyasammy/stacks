 import java.util.Scanner;
public class Stacks {
     int Max ;
    int top;
    String [] Animals;
    
    public Stacks(int size) {
         top = -1;
         Max = size;
         Animals = new String[Max] ;  
    }
    public void  Push (String New_Animal) {
        if(top == Max-1)
        {System.out.println("Overflow");}
        else{
            top = top+1;
            Animals[top]=New_Animal;
        }
    }
    
    public void Print_Animals() {
        for(int i=0;i<=top;i++){
            System.out.println(Animals[i]);
        }
    }
    // Returns the top most element and then deletes it
    public String pop(){
          
    if (top == -1) {
        System.out.println("UnderFlow");
        return "UnderFlow";
    }
    else{
        String Value = Animals[top];
        top = top-1;
        System.out.println(Value +  "Has been poped out of the stack");
        return Value;  
    }
    
    }
    // peek returns the value of the top most element without deleting it.
    public String Peek (){
        if (top == -1) {
            System.out.println("Under Flow"+""+"Stack is empty");
            return "Stuck is empty";
        }
        else{
            String Value = Animals[top];
            System.out.println("The top most value is ;\t"+Value);
            return Value; 
        }
    }
   
    

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("How many animals would you like to enter into the stack?");
        int Nunmber_of_animals;
        while (true) {
            
        if(scan.hasNextInt()){
            Nunmber_of_animals = scan.nextInt();
        scan.nextLine();
            if(  Nunmber_of_animals>0){
                break;
            }else{
                System.out.println("The value must be greater than Zero\nPlease Re-enter the value:");
            } 
        }else{
            System.out.println("Invalid input , Value MUST be an integer \n Please re-enter the value: ");
        }
        scan.nextLine();
    }
        Stacks OB = new Stacks(Nunmber_of_animals);

        System.out.println("Please Enter the Animals:\n");
        int i=0;
        while( i < Nunmber_of_animals){
           
            while (true) {
                String entered = scan.nextLine();   
            if (entered.matches("[a-zA-Z ]+")){
                OB.Push(entered);
                break;  
            }else {
                System.out.println("Value must be a string \n Please re-enter the value");
            }
        }
                    
            i++;
        }
        System.out.println("Please Select An option:\n  1.  To POP an animal from the stack \n 2.  To review the top most animal \n 3. TO review the updated list\n 4. To exit ");
        int Option ;
        while (true){
         while (true) {
            if (scan.hasNextInt()){
                Option = scan.nextInt();
                scan.nextLine();
                
         
         switch (Option) {
            case 1:
                OB.pop();
                System.out.println("UPDATED LIST:\n");
                OB.Print_Animals();
        System.out.println("Please Select An option:\n  1.  To POP an animal from the stack \n 2.  To review the top most animal \n 3. TO review the updated list\n 4. To exit ");

                break;
            case 2:
            OB.Peek(); 
        System.out.println("Please Select An option:\n  1.  To POP an animal from the stack \n 2.  To review the top most animal \n 3. TO review the updated list\n 4. To exit ");

           break;
           case 3:
           System.out.println("LIST:");
           OB.Print_Animals();
        System.out.println("Please Select An option:\n  1.  To POP an animal from the stack \n 2.  To review the top most animal \n 3. TO review the updated list\n 4. To exit ");

           break;
           case 4:
           return;
            default:
            System.out.println("Invalid input , value out of range");
                
         }
         break;}
         else {
          System.out.println("Invalid input , The value MUST be a number\n Please re-enter the value");
         scan.nextLine();
        }
    }
}        
    }
}