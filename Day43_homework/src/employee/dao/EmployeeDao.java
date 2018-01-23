package employee.dao;

import com.nys.util.HibernateUtil;
import employee.domain.Employee;
import org.hibernate.Query;
import user.domain.User;

import java.util.List;

public class EmployeeDao {
    public void insert(Employee e){
        HibernateUtil.handle(session -> {
            session.save(e);
            return null;
        });
    }
    public List<Employee> queryAll(){
        return HibernateUtil.handle(session -> {
            Query query = session.createQuery("from Employee ");
            return query.list();
        });
    }
    public Employee queryById(int id){
        return HibernateUtil.handle(session -> {
            return session.get(Employee.class, id);
        });
    }
    public void update(Employee toE){
        HibernateUtil.handle(session -> {
            Employee e = session.get(Employee.class, toE.getId());
            if ((e.getName()==null&&toE.getName()!=null)||(e.getName()!=null&&!e.getName().equals(toE.getName()))){
                e.setName(toE.getName());
            }
            if ((e.getAge()==null&&toE.getAge()!=null)||(e.getAge()!=null&&!e.getAge().equals(toE.getAge()))){
                e.setAge(toE.getAge());
            }
            if ((e.getDepartment()==null&&toE.getDepartment()!=null)||(e.getDepartment()!=null&&!e.getDepartment().equals(toE.getDepartment()))){
                e.setDepartment(toE.getDepartment());
            }
            if ((e.getJointime()==null&&toE.getJointime()!=null)||(e.getJointime()!=null&&!e.getJointime().equals(toE.getJointime()))){
                e.setJointime(toE.getJointime());
            }
            if ((e.getAddress()==null&&toE.getAddress()!=null)||(e.getAddress()!=null&&!e.getAddress().equals(toE.getAddress()))){
                e.setAddress(toE.getAddress());
            }
            if ((e.getTelephone()==null&&toE.getTelephone()!=null)||(e.getTelephone()!=null&&!e.getTelephone().equals(toE.getTelephone()))){
                e.setTelephone(toE.getTelephone());
            }
            return null;
        });
    }
}
