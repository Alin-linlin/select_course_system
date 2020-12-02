package com.lnzz.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ClassName：Major
 *
 * @author 冷暖自知
 * @version 1.0
 * @date 2019/12/11 18:57
 * @Description:
 */
@Entity
@Table(name = "t_major",uniqueConstraints=@UniqueConstraint(columnNames="name"))
@Data
@NoArgsConstructor
@Proxy(lazy = false)//hibernate延时加载
public class Major {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @ManyToOne
    private College college;


    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCollege(College college){
        this.college = college;
    }

    public College getCollege() {
        return college;
    }
}
