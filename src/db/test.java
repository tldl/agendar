package db;

/**
 * Created by Administrator on 2014/11/2 0002.
 */
public class test {

   public void i()
   {
       Bussiness b = new Bussiness();

       Employee employee=new Employee() {
           @Override
           public void calculateSalary() {

           }
       };

       b.add(employee);
       b.delete(employee);
   }
}
