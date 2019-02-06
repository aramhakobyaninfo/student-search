import java.util.Scanner;
import java.util.ArrayList;
/**
 * Fully functional class with multiple constructors,
 * that instantiates and stores objects of the class
 * in a binary search tree (BST) structure.
 * This class implements a binary search tree whose
 * nodes hold objects that implement the Comparable
 * interface.
 *
 * @author Aram Hakobyan
 * @version Dec 11, 2018
 */
public class StudentSearch
{
    public static BinarySearchTree tree=new BinarySearchTree();
    public static void main( ) throws IllegalArgumentException
    {
       System.out.println("Added 5 students (use the MENU below) \n");
       //Create 5 students to poblate the tree
       Student s1=new Student(1111, "Santi Cosa", "IMM");
       Student s2=new Student(2222, "John Wick", "CHE");
       Student s3=new Student(3333, "Jack Ryan", "MAT");
       Student s4=new Student(4444, "Harvey Specter", "CIS");
       Student s5=new Student(5555, "Hank Moody", "DPR");
       tree.add(s1);
       tree.add(s2);
       tree.add(s3);
       tree.add(s4);
       tree.add(s5);
       //Variable to store the selected menu option
       int option=0;
       while(option!=6)
       {
           //Print menu
           System.out.println("1 - Delete a student ");
           System.out.println("2 - Add a student ");
           System.out.println("3 - Search a student ");
           System.out.println("4 - Show all");
           System.out.println("5 - Search by Major ");
           System.out.println("6 - Exit ");
           System.out.println("Enter option: ");
           System.out.println();
           
           Scanner scanner = new Scanner(System.in);
           //Read option and proceed with the selected method
           try
            {
                option = scanner.nextInt();
            }
            catch(Exception e)
            {System.out.println("Invalid input.");
                continue;
            }
           switch (option)
           {
               case 1:
               {
                   removeStudent();
                   break;
               }
               case 2:
               {
                   addStudent();
                   break;
               }
               case 3:
               {
                   searchStudent();
                   break;
               }
               case 4:
               {
                   showStudents();
                   break;
               }
               case 5:
               {
                   searchByMajor();
                   break;
               }
           }
        }
    }
    public static void removeStudent()
    {
       //Define a variable to store the ID of the student to be removed
       int id_to_remove=0;
       System.out.println("Enter the id of the student to be removed:");
       
       //Read ID from keyboard
       Scanner scanner = new Scanner(System.in);

       
       //Read option and proceed with the selected method
       try{
            id_to_remove = scanner.nextInt();
       }catch(Exception e){
            System.out.println("Invalid input.");
            return;
       }
       System.out.println();
       
       //Create a new student. Useful for searching. Check if value is valid, otherwise abort.
       Student aux=null;
       try{
            aux=new Student(id_to_remove);
       }catch(IllegalArgumentException e){
           //Catch an invalid ID value, then continue execution
            System.out.println("Illegal ID value. Aborting operation.");
            System.out.println();
            return;
       }
       
       //If we find it, we remove it. Otherwise print a msg
       if(tree.find(aux)!=null)
            {
                //If the student was found, remove it
                tree.remove(aux);
                System.out.println("Student succesfully removed!");
                System.out.println();
            }
        else{
            //If no student was found, print an appropiate message
            System.out.println("No student found with this id");
            System.out.println();
        }
    }
    public static void addStudent()
    {
       //Read all attributes from user input
       int id_to_add=0;
       System.out.println("Enter the id of the student:");
       
       //Read ID value from keyboard
       Scanner scanner = new Scanner(System.in);

       
       try
        {
           id_to_add = scanner.nextInt();
        }
         catch(Exception e)
        {
           System.out.println("Invalid input.");
           return;
        }
       String name;
       System.out.println("Enter the name of the student:");
       
       //Read name value from keyboard
       Scanner scanner2 = new Scanner(System.in);
       name = scanner2.nextLine();
       
       String major;
       System.out.println("Enter the major of the student:");
       
       //Read major value from keyboard
       Scanner scanner3 = new Scanner(System.in);
       major = scanner3.nextLine();
       System.out.println();
       //Create a new student and add it
       try{
           //Instantiate a new Student object
           Student aux=new Student(id_to_add,name,major);
           //Add to the tree structure
           tree.add(aux);
        }catch (IllegalArgumentException e){
            //Catch any exception, then continue execution
            System.out.println("Illegal argument value. Aborting operation.");
            System.out.println();
            return;
       }
    }
    public static void searchStudent()
    {
       //Value to store the id to be searched
       int id_to_find=0;
       
       //Tell the user to enter an id
       System.out.println("Enter the id of the student to find:");
       
       //Read ID from keyboard
       Scanner scanner = new Scanner(System.in);
       
       try
        {
           id_to_find = scanner.nextInt();
        }
        catch(Exception e){
           System.out.println("Invalid input.");
           return;
        }
       
       //Create an auxiliar student object to use for the searching. Check if the ID is valid, otherwise abort
       Student aux=null;
       try
       {
            aux=new Student(id_to_find);
       }catch(IllegalArgumentException e){
           //Catch the IllegalArgumentException indicating an id lower than 1
          
            System.out.println("Illegal ID value. Aborting operation.");
            System.out.println();
            return;
       }
       
       //Print the student if we find it
       if(tree.find(aux)!=null)
            {
                //Print the information of the student
                tree.find(aux).toString();
            }
        else{
            //If no student was found print an appropiate message
            System.out.println("No student found with this id");
            System.out.println();
        }
    }
    public static void showStudents()
    {
       //Simply print all students
       System.out.println();
       System.out.println("Showing students:");
       System.out.println();
       
       //Use the print() method of the BinarySearchTree class.
       tree.print();
       System.out.println();
    }
    public static void searchByMajor()
    {
       //Define the string variable that will hold the entered major value
       String major;
       
       //Tell the user to enter the major valie
       System.out.println("Enter the major to show all students with that major:");
       
       //Read input from keyboard
       Scanner scanner = new Scanner(System.in);
       major = scanner.nextLine();
       
       //Useful to print if no student was found
       boolean oneAtLeastFound=false;
       
       //Loop through all students and print only the ones with that major. A cast to Student class needs to be done first
       for(Object o:tree.getList())
       {
           //Cast necesary since getList() method returns a list of Objects
           Student aux=(Student)o;
           //Check if the student's major is equal to the entered major
           if(aux.getMajor().equals(major.toUpperCase()))
           {
               System.out.println(aux.toString());
               //Set to true that one was found (at least)
               oneAtLeastFound=true;
           }
        }
       if(!oneAtLeastFound)
            System.out.println("No students found with that major");
       System.out.println();
    }
}