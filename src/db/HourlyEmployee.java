package db;

/**
 * Created by Administrator on 2014/10/9 0009.
 */
public class HourlyEmployee extends Employee {


    public HourlyEmployee() {
        setType(Employee.HOURLY_EMPLOYEE);
    }

    @Override
    public void calculateSalary() {
        setSalary(Employee.HOUR_SALARY * getWorkTime());
    }
}
