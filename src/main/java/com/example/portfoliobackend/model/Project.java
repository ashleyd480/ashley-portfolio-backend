package com.example.portfoliobackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "projects")

public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "project_id")
    private Integer projectId;

    @Column(name = "projectname", unique = true, nullable = false)
    private String projectName;

    @Column(name = "projectURL")
    private String projectURL;

    /*  @Temporal is used to control how date and time information is mapped between Java and the database in JPA entity classes
    *  telling JPA that the dataCompleted field should be mapped to a database column representing a date (without a time component).*/
    @Column(name = "date_completed")
    private String dateCompleted;

    @Column(name = "projectheaderimage")
    private String projectHeaderImage;

    @Column(name = "projecttype")
    private String projectType;

    @Column(name = "projectblurb", length = 1000) // had to specify length or else default to 250
    private String projectBlurb;

    @Column(name = "projectuX", length = 1000)
    private String projectUX;

    @Column(name = "project_video")
    private String projectVideo;

    /*doing join table from projects since I figure I will be querying more from Projects */

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "projectskills",
            joinColumns = { @JoinColumn(name = "project_id") },
            inverseJoinColumns = { @JoinColumn(name = "skill_id") }
    )


    private List<Skill> skills;

    @OneToOne(mappedBy = "project")
    private ProjectScoreOverview projectsScoreOverview;
    // ProjectScoreOverview owns the foreign key

}
