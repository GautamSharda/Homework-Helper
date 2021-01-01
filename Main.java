import java.util.Scanner;
import java.lang.Math;
public class Main
{

  public static void main(String[] args)
  {
    
    boolean variable;
    variable = true;
    Scanner scan = new Scanner(System.in);
    System.out.println("What subject would you like to study?");
    String subject = scan.nextLine();
    
    
    if (subject.toLowerCase().equals("bio") || subject.toLowerCase().equals("biology")){
      Biology bio1 = new Biology();
      System.out.println(bio1.getGreeting());
      while (!subject.equals("Bye"))
      {
        System.out.println (bio1.getResponse(subject));
        subject = scan.nextLine();
      }
    }
    if (subject.toLowerCase().equals("chem")  || subject.toLowerCase().equals("chemistry") ){
      Chemistry chem1 = new Chemistry();
      System.out.println(chem1.getGreeting());
      while (!subject.equals("Bye"))
      {
        System.out.println (chem1.getResponse(subject));
        subject = scan.nextLine();
      }
    }
    if (subject.toLowerCase().equals("phys") || subject.toLowerCase().equals("physics")){
      Physics phys1 = new Physics();
      System.out.println (phys1.getGreeting());
      while (!subject.equals("Bye"))
      {
        System.out.println (phys1.getResponse(subject));
        subject = scan.nextLine();
      }
    }
    
    if (subject.toLowerCase().equals("math") || subject.toLowerCase().equals("mathematics")){
        Mathematics math1 = new Mathematics();
        System.out.println(math1.getGreeting());
        System.out.println ("What would you like to compute?");
        String mathsub = scan.nextLine();
        double a;
        double b;
        double c;
        while (variable == true) {
        if (mathsub.toLowerCase().equals("quadratic formula") || mathsub.toLowerCase().equals("qf")){
          System.out.println("What is the value of a?");
          a = Double.parseDouble(scan.nextLine());
          System.out.println("What is the value of b?");
          b = Double.parseDouble(scan.nextLine());
          System.out.println("What is the value of c?");
          c = Double.parseDouble(scan.nextLine());
          System.out.println (math1.Quadratic(a,b,c));
          break;
          }
        if (mathsub.toLowerCase().equals("linear equation")){
            System.out.println("This is in mx + b form");
            System.out.println("What is the value of m?");
            a = Double.parseDouble(scan.nextLine());
            System.out.println("What is the value of x?");
            b = Double.parseDouble(scan.nextLine());
            System.out.println(math1.Linear(a,b));
            break;
            
        }
        if (mathsub.toLowerCase().equals("trigonometric functions") || mathsub.toLowerCase().equals("tf")){
            System.out.println("What is the numerator? ");
            a = Double.parseDouble(scan.nextLine());
            System.out.println("What is the denominator? ");
            b = Double.parseDouble(scan.nextLine());
            System.out.println(math1.trigfunctions(a, b));
            break;

        }
        if (mathsub.toLowerCase().equals("double angle sine") || mathsub.toLowerCase().equals("das")){
            System.out.println("What is the numerator? ");
            a = Double.parseDouble(scan.nextLine());
            System.out.println("What is the denominator? ");
            b = Double.parseDouble(scan.nextLine());
            System.out.println(math1.doubleangleSine(a,b));
            break;
        }
        if (mathsub.toLowerCase().equals("double angle cosine") || mathsub.toLowerCase().equals("dac")){
            System.out.println("What is the numerator? ");
            a = Double.parseDouble(scan.nextLine());
            System.out.println("What is the denominator? ");
            b = Double.parseDouble(scan.nextLine());
            System.out.println(math1.doubleangleCosine(a,b));
            break; 
        }
        if (mathsub.toLowerCase().equals("double angle tangent") || mathsub.toLowerCase().equals("dat")){
            System.out.println("What is the numerator? ");
            a = Double.parseDouble(scan.nextLine());
            System.out.println("What is the denominator? ");
            b = Double.parseDouble(scan.nextLine());
            System.out.println(math1.doubleangleTangent(a,b));
            break;
        }
        else{
            System.out.println("That is not a valid response. Please ask for something we have.");
        }
          
    }
    }
    }
  
}