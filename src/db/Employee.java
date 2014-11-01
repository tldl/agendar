package db;


/**
 * Created by Administrator on 2014/10/9 0009.
 */
public abstract class Employee {
    public final static int HOUR_SALARY = 20;
    public final static int WEEK_SALARY = 700;
    public final static int SALARYIED_EMPLOYEE = 1;
    public final static int HOURLY_EMPLOYEE = 2;
    private int id;
    private String name;
    private int type;
    private float workTime;
    private float salary;


    @Override
    public String toString() {
        return "Employee{" +
                " name='" + name + '\'' +
                ", type=" + type +
                ", workTime=" + workTime +
                ", salary=" + salary +
                '}';
    }

    public String toSql() {
        return "INSERT  into Employee (Name,Type,WorkTime,Salary)values ('"
                + this.name + "','"
                + this.type + "','"
                + this.workTime + "','"
                + this.salary + "')";

    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public abstract void calculateSalary();

    public float getWorkTime() {
        return workTime;
    }

    public void setWorkTime(float workTime) {
        this.workTime = workTime;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
