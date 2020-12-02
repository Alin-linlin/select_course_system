package com.lnzz.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Date;

/**
 * ClassName：Student
 *
 * @author 冷暖自知
 * @version 1.0
 * @date 2019/12/11 18:37
 * @Description:
 */
@Entity
@Table(name = "t_student")
@Data
@NoArgsConstructor
@Proxy(lazy = false)
public class Student {
    @Id
    @GeneratedValue
    @Column(name = "stu_id",nullable = false,length = 10)
    private Long stuId;

    @Column(name = "stu_code", length = 20, nullable = false, unique = true)
    private String stuCode;// 学号/教师编号

    @Column(name = "stu_password", length = 100, nullable = false)
    private Object stuPassword;//密码

    @Column(name = "stu_type", length = 4, nullable = false)
    private Object stuType;// 类型（1：学生 2：教师）

    @Column(name = "stu_name", length = 30, nullable = false)
    private String stuName; // 姓名

    @Column(name = "stu_sex", length = 4, nullable = false)
    private Integer stuSex;//性别

    @Column(name = "stu_img", length = 255, nullable = false)
    private String stuImg;// 头像

    @Column(name = "stu_birthday")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date stuBirthday;// 出生日期

    @ManyToOne
    private College college;// 所属学院
    @ManyToOne
    private Major major;// 所属专业
    @ManyToOne
    private Grade grade;// 所属班级

    @Column(name = "stu_phone", length = 20, nullable = false)
    private String stuPhone;// 电话

    @Column(name = "stu_email", length = 100, nullable = false)
    private String stuEmail;//邮箱

    @Column(name = "remarks", length = 2000,nullable = true)
    private String remarks;//备注

    @Column(name = "role", length = 4, nullable = false)
    private Object role;//权限（0：管理员 1：学生 2：教师）

    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    @Transient
    private Number collegeId;
    @Transient
    private Number gradeId;
    @Transient
    private Number majorId;

    public Number getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Number collegeId) {
        this.collegeId = collegeId;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public College getCollege() {
        return college;
    }

    public Number getMajorId() {
        return majorId;
    }

    public void setMajorId(Number majorId) {
        this.majorId = majorId;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public Major getMajor() {
        return major;
    }

    public Number getGradeId() {
        return gradeId;
    }

    public void setGradeId(Number gradeId) {
        this.gradeId = gradeId;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public String getStuPassword() {
        return (String) stuPassword;
    }

    public void setStuPassword(Object stuPassword) {
        this.stuPassword = stuPassword;
    }

    public Object getStuType() {
        return stuType;
    }

    public void setStuType(Object stuType) {
        this.stuType = stuType;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setRole(Object role) {
        this.role = role;
    }

    public Object getRole() {
        return role;
    }

    public void setStuImg(String stuImg) {
        this.stuImg = stuImg;
    }

    public String getStuImg() {
        return stuImg;
    }
}
