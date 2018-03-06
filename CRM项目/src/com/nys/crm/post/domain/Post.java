package com.nys.crm.post.domain;

import com.nys.crm.department.domain.Department;
import com.nys.crm.staff.domain.Staff;

import java.util.HashSet;
import java.util.Set;

public class Post {
    private String postId;
    private String postName;
    private Department department;
    private String depId;
    private Set<Staff> staffs = new HashSet<>();

    public String getDepId() {
        return depId;
    }

    public void setDepId(String dpId) {
        this.depId = dpId;
    }

    public Set<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(Set<Staff> staffs) {
        this.staffs = staffs;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (postId != null ? !postId.equals(post.postId) : post.postId != null) return false;
        if (postName != null ? !postName.equals(post.postName) : post.postName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = postId != null ? postId.hashCode() : 0;
        result = 31 * result + (postName != null ? postName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId='" + postId + '\'' +
                ", postName='" + postName + '\'' +
                ", department=" + department +
                ", depId='" + depId + '\'' +
                '}';
    }
}
