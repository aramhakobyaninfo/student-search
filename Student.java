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
public class Student implements Comparable<Student>
{
    private int id;
    private String name;
    private String major;
    public Student()
    {
        
    }
    //Constructor. If an invalid argument is inserted an exception is thrown.
    public Student(int id, String name, String major)
    {
        if(id<=0 || name.length()==0 || major.length()!=3)
            throw new IllegalArgumentException();
            //Set are instance variables. Remember to convert major to uppercase
        this.id=id;
        this.name=name;
        this.major=major.toUpperCase();
    }
    //Student constructor. If id is lower or equals to 0 an exception in thrown
    public Student(int id) throws IllegalArgumentException
    {
        //Check if an Invalid ID was given
        if(id<=0)
            throw new IllegalArgumentException();
            //Set instance variables. Name and major will hold placeholder values
        this.id=id;
        this.name="";
        this.major="";
    }
    
    public int getId()
    {
        return this.id;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name=name;
    }
    
    public String getMajor(){
        return this.major;
    }
    
    //Major variable setter. Exception is thrown if the lenght is not 3
    public void setMajor(String major) throws IllegalArgumentException{
        if(major.length()!=3)
            throw new IllegalArgumentException();
            
        //Convert to uppercase
        this.major=major.toUpperCase();
            
    }
    
    //The overriden method compareTo shall behave like this. If two elements are the same
    //then the value returned should be 0. If we substract the two id's, the result will be
    //0 if we are comparing the same student.
    @Override
    public int compareTo(Student o) {

        return this.id-o.getId();

    }
    
    //A String representation of a student concatenating each variable with it's name
    @Override
    
    public String toString(){
        return "ID: "+this.id+" | Name: "+this.name+" | Major: "+this.major;
    }
}