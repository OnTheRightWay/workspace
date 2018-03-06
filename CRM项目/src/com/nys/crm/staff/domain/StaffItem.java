package com.nys.crm.staff.domain;

public class StaffItem {
    private Staff staff;
    private String department;
    private String post;

    public StaffItem() {
    }

    public StaffItem(Staff staff, String department, String post) {
        this.staff = staff;
        this.department = department;
        this.post = post;
    }

    @Override
    public String toString() {
        return "StaffItem{" +
                "staff=" + staff +
                ", department='" + department + '\'' +
                ", post='" + post + '\'' +
                '}';
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
