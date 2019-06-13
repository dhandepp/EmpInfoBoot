package demo.ei.model;

import javax.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    private String id;
    @Column
    private String name;
    @Column
    private String practice;
    @Column
    private String project;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPractice() {
        return practice;
    }

    public void setPractice(String practice) {
        this.practice = practice;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }
}
