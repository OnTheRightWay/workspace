package com.nys.crm.classes.domain;

import com.nys.crm.courseType.domain.CourseType;

import java.sql.Timestamp;

public class Classes {
    private String classId;
    private String name;
    private String beginTime;
    private String endTime;
    private String status;
    private Integer totalCount;
    private Integer upgradeCount;
    private Integer changeCount;
    private Integer runoffCount;
    private String remark;
    private String uploadTime;
    private String uploadPath;
    private String uploadFilename;
    private CourseType courseType;

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getUpgradeCount() {
        return upgradeCount;
    }

    public void setUpgradeCount(Integer upgradeCount) {
        this.upgradeCount = upgradeCount;
    }

    public Integer getChangeCount() {
        return changeCount;
    }

    public void setChangeCount(Integer changeCount) {
        this.changeCount = changeCount;
    }

    public Integer getRunoffCount() {
        return runoffCount;
    }

    public void setRunoffCount(Integer runoffCount) {
        this.runoffCount = runoffCount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public String getUploadFilename() {
        return uploadFilename;
    }

    public void setUploadFilename(String uploadFilename) {
        this.uploadFilename = uploadFilename;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Classes classes = (Classes) o;

        if (classId != null ? !classId.equals(classes.classId) : classes.classId != null) return false;
        if (name != null ? !name.equals(classes.name) : classes.name != null) return false;
        if (beginTime != null ? !beginTime.equals(classes.beginTime) : classes.beginTime != null) return false;
        if (endTime != null ? !endTime.equals(classes.endTime) : classes.endTime != null) return false;
        if (status != null ? !status.equals(classes.status) : classes.status != null) return false;
        if (totalCount != null ? !totalCount.equals(classes.totalCount) : classes.totalCount != null) return false;
        if (upgradeCount != null ? !upgradeCount.equals(classes.upgradeCount) : classes.upgradeCount != null)
            return false;
        if (changeCount != null ? !changeCount.equals(classes.changeCount) : classes.changeCount != null) return false;
        if (runoffCount != null ? !runoffCount.equals(classes.runoffCount) : classes.runoffCount != null) return false;
        if (remark != null ? !remark.equals(classes.remark) : classes.remark != null) return false;
        if (uploadTime != null ? !uploadTime.equals(classes.uploadTime) : classes.uploadTime != null) return false;
        if (uploadPath != null ? !uploadPath.equals(classes.uploadPath) : classes.uploadPath != null) return false;
        if (uploadFilename != null ? !uploadFilename.equals(classes.uploadFilename) : classes.uploadFilename != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = classId != null ? classId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (beginTime != null ? beginTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (totalCount != null ? totalCount.hashCode() : 0);
        result = 31 * result + (upgradeCount != null ? upgradeCount.hashCode() : 0);
        result = 31 * result + (changeCount != null ? changeCount.hashCode() : 0);
        result = 31 * result + (runoffCount != null ? runoffCount.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (uploadTime != null ? uploadTime.hashCode() : 0);
        result = 31 * result + (uploadPath != null ? uploadPath.hashCode() : 0);
        result = 31 * result + (uploadFilename != null ? uploadFilename.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "classId='" + classId + '\'' +
                ", name='" + name + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", status='" + status + '\'' +
                ", totalCount=" + totalCount +
                ", upgradeCount=" + upgradeCount +
                ", changeCount=" + changeCount +
                ", runoffCount=" + runoffCount +
                ", remark='" + remark + '\'' +
                ", uploadTime=" + uploadTime +
                ", uploadPath='" + uploadPath + '\'' +
                ", uploadFilename='" + uploadFilename + '\'' +
                ", courseType=" + courseType +
                '}';
    }
}
