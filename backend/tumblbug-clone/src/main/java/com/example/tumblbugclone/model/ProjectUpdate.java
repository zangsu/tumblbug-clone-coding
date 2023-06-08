package com.example.tumblbugclone.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PROJECT_UPDATE")
@NoArgsConstructor
@Data
@ToString(exclude = {"project", "creater"})
public class ProjectUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UPDATE_ID")
    long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PROJECT_ID")
    Project project;

    @Column(name = "CONTENT")
    String content;

    @ManyToOne
    @JoinColumn(name = "USER_IDX")
    User creater;

    @Column(name = "UPDATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    Date updateDate;

    @Column(name = "IS_MODIFIED")
    boolean modified = false;

    @Column(name = "comment")
    @OneToMany(mappedBy = "update")
    List<UpdateComment> comment;
}
