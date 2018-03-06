package com.nys.crm.staff.dao.impl;

import com.nys.crm.department.domain.Department;
import com.nys.crm.post.domain.Post;
import com.nys.crm.staff.dao.StaffDao;
import com.nys.crm.staff.domain.Staff;
import com.nys.crm.staff.domain.StaffItem;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.ArrayList;
import java.util.List;
public class StaffDaoImpl extends HibernateDaoSupport implements StaffDao {
    @Override
    public Staff findByLoginName(String loginName) {
        List<?> staffs = getHibernateTemplate().find(
                " from Staff s where s.loginName=?",
                loginName
        );
        if (staffs.size()==0){
            return null;
        }
        return (Staff) staffs.get(0);
    }

    @Override
    public void updatePsw(String loginName, String newPassword) {
        Staff staff = findByLoginName(loginName);
        staff.setLoginPwd(newPassword);
    }

    @Override
    public List<Staff> findAll() {
        List<?> staffs = getHibernateTemplate().find(
                "from Staff "
        );
        return (List<Staff>) staffs;
    }

    @Override
    public List<StaffItem> findAllStaffItem() {
        List<?> list = getHibernateTemplate().find(
                "select s.staffId,s.staffName,s.gender,s.onDutyDate,d.depName,p.postName from Staff s left outer join Post p on s.postId=p.postId left outer join Department d on" +
                        " p.depId = d.depId"
        );
//        List<?> list = getHibernateTemplate().find(
//                "select s.staffName,s.gender,s.onDutyDate,d.depName,p.postName " +
//                        "FROM Staff s LEFT JOIN Post p LEFT JOIN Department d"
//        );
        List<StaffItem> staffItems = new ArrayList<>();
        for (Object o : list) {
            Object[] s = (Object[]) o;
            StaffItem staffItem = new StaffItem();
            Staff staff = new Staff();
            staff.setStaffId((String) s[0]);
            staff.setStaffName((String) s[1]);
            staff.setGender((String) s[2]);
            staff.setOnDutyDate((String) s[3]);
            staffItem.setStaff(staff);
            staffItem.setDepartment((String) s[4]);
            staffItem.setPost((String) s[5]);
            staffItems.add(staffItem);
        }
        return staffItems;
    }


    @Override
    public void updateStaff(Staff staff) {
//        getHibernateTemplate().update(staff);
        String staffId = staff.getStaffId();
//        String loginName = staff.getLoginName();
//        String loginPwd = staff.getLoginPwd();
//        String staffName = staff.getStaffName();
//        String gender = staff.getGender();
//        String onDutyDate = staff.getOnDutyDate();
//        String postId = staff.getPostId();
//
        Staff staff1 = findByStaffId(staffId);
//        staff1.setPostId(postId);
//        staff1.setLoginPwd(loginPwd);
//        staff1.setLoginName(loginName);
//        staff1.setGender(gender);
//        staff1.setOnDutyDate(onDutyDate);
//        staff1.setStaffName(staffName);



        if (!staff1.getLoginName().equals(staff.getLoginName())){
            staff1.setLoginName(staff.getLoginName());
        }

        if (!staff1.getLoginPwd().equals(staff.getLoginPwd())){
            staff1.setLoginPwd(staff.getLoginPwd());
        }

        if (!staff1.getOnDutyDate().equals(staff.getOnDutyDate())){
            staff1.setOnDutyDate(staff.getOnDutyDate());
        }

        if (!staff1.getStaffName().equals(staff.getStaffName())){
            staff1.setStaffName(staff.getStaffName());
        }

        if (!staff1.getGender().equals(staff.getGender())){
            staff1.setGender(staff.getGender());
        }

        if (!staff1.getPostId().equals(staff.getPostId())){
            staff1.setPostId(staff.getPostId());
        }
    }
    @Override
    public Staff findByStaffId(String staffId) {
        List<?> list = getHibernateTemplate().find(
                "from Staff s where s.staffId=?",
                staffId
        );
        if (list.size()==0){
            return null;
        }
        return (Staff) list.get(0);
    }

    @Override
    public List<Staff> findByParams(String postId, String depId, String staffName) {
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;

        String[] params = {"s.post.postId","s.post.department.depId","s.staffName"};
        String[] values = {postId,depId,staffName};
        for (int i=0;i<params.length;i++){
            if (values[i]!=null&&!values[i].equals("")){
                if (isFirst){
                    sb.append(" where ");
                    isFirst = false;
                }else {
                    sb.append(" and ");
                }
                sb.append(params[i]).append("='").append(values[i]).append("'");
            }
        }
        String where = sb.toString();
        System.out.println(where);
        return (List<Staff>) getHibernateTemplate().find(
                "from Staff s" + where
        );

    }

    @Override
    public void add(Staff staff) {
        Post post = getHibernateTemplate().get(Post.class, staff.getPost().getPostId());
        staff.setPost(post);
        getHibernateTemplate().save(staff);
    }
}
