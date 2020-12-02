package com.lnzz.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Date;

/**
 * ClassName：Course
 *
 * @author 冷暖自知
 * @version 1.0
 * @date 2019/12/11 18:47
 * @Description:
 */
@Entity
@Table(name = "t_course")
@Data
@NoArgsConstructor
@Proxy(lazy = false)
public class Course {
    @Id
    @GeneratedValue
    @Column(name = "course_id", nullable = false, length = 10)
    private Long courseId;

    @Column(name = "course_name", nullable = false, length = 50)
    private String courseName;// 课程名称

    @ManyToOne
    @JoinColumn(name = "course_teacher_id")
    private Student courseTeacher;// 任课教师（教师编号）

    @Column(name = "course_credit", nullable = false, length = 10)
    private Double courseCredit;// 学分

    @Column(name = "course_cycle", nullable = false, length = 40)
    private String courseCycle;// 课程周期

    @Column(name = "course_grade", nullable = false, length = 20)
    private String courseGrade;// 对应年级

    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @ManyToOne
    private CourseType courseType;// 课程类型

    @Column(name = "remarks", nullable = true, length = 2000)
    private String remarks;

    @Transient
    private Number teacherId;
    private Number courseTypeId;

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Number getCourseTypeId() {
        return courseTypeId;
    }

    public void setCourseTypeId(Number courseTypeId) {
        this.courseTypeId = courseTypeId;
    }

    public Number getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Number teacherId) {
        this.teacherId = teacherId;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseTeacher(Student courseTeacher) {
        this.courseTeacher = courseTeacher;
    }

    public Student getCourseTeacher() {
        return courseTeacher;
    }

    public String getCourseCycle() {
        return courseCycle;
    }

    public void setCourseCycle(String courseCycle) {
        this.courseCycle = courseCycle;
    }

    public Double getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(Double courseCredit) {
        this.courseCredit = courseCredit;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
