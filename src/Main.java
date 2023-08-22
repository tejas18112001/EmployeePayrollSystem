// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.ArrayList;

abstract class Employee {
    private int id = 1 ;

    private String name ;

    public Employee(int id , String name) {
        this.id  = id;
        this.name = name ;

    }

    int getID() {
        return  id ;
    }

    String getName (){
        return name ;
    }




    abstract double calculateSalary()  ;

    public String toString() {
         String emp = "Employee Name : " + name +"\n"+ "Employee_Id : " + id +"\n" + "Employee_Salary " + calculateSalary();
         return emp ;
    }

}

class FullTimeEmployee extends Employee{
    private  double monthSalary ;
    FullTimeEmployee(int id , String name , double monthSalary) {
        super( id , name) ;
        this.monthSalary = monthSalary ;

    }
    @Override
    double calculateSalary() {
        return monthSalary ;
    }

}

class PartTImeEMployee extends Employee {

    private int hour ;
    private double HourlyPay ;

    PartTImeEMployee( int id ,String name , int hour , double HourlyPay) {
        super( id , name) ;
        this.HourlyPay = HourlyPay ;
        this.hour = hour ;
    }

    @Override
    double calculateSalary() {
        return HourlyPay*hour;
    }
}



class Payroll {
    private ArrayList<Employee>employeeList ;

    Payroll() {
        employeeList = new ArrayList<>() ;
    }

    void addEmployee(Employee e) {
           employeeList.add(e) ;
    }

    void removerEmployee(Employee e) {
         employeeList.remove(e) ;
    }

    void displyEmployee(int id) {
        Employee ee = null ;
           for(Employee e : employeeList) {
               if(e.getID() == id) {
                   ee = e ;
                   break ;
               }
           }
        if(ee == null) {
            System.out.println("Employee Not found...Maybe fired");
        }
        System.out.println(ee);
    }

    void CompanyEmployee() {
        for(Employee e : employeeList) {
             System.out.println(e);
        }
    }
}





public class Main {

    private static int a = 1 ;
    static int idGerator() {

        return a++ ;
    }


    public static void main(String[] args) {

        FullTimeEmployee fte1 = new FullTimeEmployee(idGerator() , "Tejas", 23000.5) ;
        PartTImeEMployee pte1  = new PartTImeEMployee(idGerator(), "Suraj", 4 , 55.4) ;
        FullTimeEmployee fte2 = new FullTimeEmployee(idGerator() , "Dhiraj" , 45000.2) ;

        Payroll p = new Payroll() ;
        p.addEmployee(fte1);
        p.addEmployee(pte1);
        p.addEmployee(fte2);

        p.removerEmployee(pte1);
//        p.CompanyEmployee();
        p.displyEmployee(3);

    }
}