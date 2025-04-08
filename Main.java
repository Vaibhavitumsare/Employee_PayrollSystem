import java.util.ArrayList;

abstract class Employee {

    private String name;

    private  int id;

    public Employee(String name,int id){
        this.name=name;
        this.id=id;
    }

    public String getName(){
        return name;
    }

    public  int getId(){
        return id;
    }

    public abstract double calculatesalary();

    @Override
    public String toString(){
        return "Employee [name="+name+",id="+id+",salary="+calculatesalary()+"]";
    }
}

class FullTimemployee extends Employee{

    private double monthlysalary;

    public FullTimemployee(String name,int id,double monthlysalary){
        super(name,id);
        this.monthlysalary=monthlysalary;
    }

    @Override
    public double calculatesalary(){
        return monthlysalary;
    }

}

class PartTimeEmployee extends Employee{

    private double hourlyRate;

    private int hoursWorked;

    public PartTimeEmployee(String name,int id,double hourlyRate,int hoursWorked){
        super(name,id);
        this.hourlyRate=hourlyRate;
        this.hoursWorked=hoursWorked;
    }

    @Override
    public double calculatesalary() {
        return hourlyRate*hoursWorked;
    }
}


class Payrollsystem{

    private ArrayList<Employee> employeeList;

    public Payrollsystem(){
        employeeList=new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public void removeEmployee(int id){

        Employee employeeToRemove=null;
        for(Employee employee:employeeList){
            if(employee.getId()==id){
                employeeToRemove=employee;
                break;
            }
        }
        if(employeeToRemove!=null){
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployee(){
      for(Employee employee:employeeList){
          System.out.println(employee);
      }
    }

}



public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Payrollsystem payrollsystem=new Payrollsystem();
        FullTimemployee emp1=new FullTimemployee("Vikas",1,7000);
        PartTimeEmployee emp2=new PartTimeEmployee("Niraj",2,40,2);
        payrollsystem.addEmployee(emp1);
        payrollsystem.addEmployee(emp2);
        System.out.println("Employee list:");
        payrollsystem.displayEmployee();
        System.out.println("remove employee:");
        payrollsystem.removeEmployee(2);
        System.out.println("remaining employee:");
        payrollsystem.displayEmployee();

    }
}