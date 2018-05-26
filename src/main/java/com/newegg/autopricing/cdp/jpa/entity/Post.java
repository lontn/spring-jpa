package com.newegg.autopricing.cdp.jpa.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="TB_Post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany(fetch=FetchType.EAGER, cascade = {
            CascadeType.PERSIST,
            CascadeType.REMOVE,
            CascadeType.MERGE,
            CascadeType.REFRESH })
    @JoinTable(
            name = "TB_Tag_Post", 
            joinColumns = @JoinColumn(name = "Post_Id", referencedColumnName = "Id"), 
            inverseJoinColumns = @JoinColumn(name = "Tag_Id", referencedColumnName = "Id"))
    private Set<Tag> tags = new HashSet<Tag>();

    @Column(name = "Title", columnDefinition = "varchar", length = 30, nullable = false)
    private String title;

    @Column(name = "ContentText", columnDefinition = "varchar", length = 100, nullable = false)
    private String contentText;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText;
    }

}
