package db;


/**
 * Created by Administrator on 2014/10/9 0009.
 */
public class SalariedEmployee extends Employee {


    public SalariedEmployee() {
        setType(Employee.SALARYIED_EMPLOYEE);
    }

    @Override

    public void calculateSalary() {
        setSalary(Employee.WEEK_SALARY * 4);
    }
}
