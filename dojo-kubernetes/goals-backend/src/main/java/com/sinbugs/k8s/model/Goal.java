package com.sinbugs.k8s.model;

import java.util.Date;

/**
 * Representa una meta que se desea cumplir
 *
 * @author nelson
 */
public class Goal {

    private Long id;
    private String name;
    private String description;
    private Date dueDate;
    private String imageName;

    public Goal() {
        
    }

    public Goal(String name, String description, Date dueDate) {
        super();
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
    }
    
    public Goal(String name, String description, Date dueDate, String imageName) {
        this(name, description, dueDate);
        this.imageName = imageName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Goal [id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append(", description=");
        builder.append(description);
        builder.append(", dueDate=");
        builder.append(dueDate);
        builder.append(", imageName=");
        builder.append(imageName);
        builder.append("]");
        return builder.toString();
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
