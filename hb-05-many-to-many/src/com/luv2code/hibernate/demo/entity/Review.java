package com.luv2code.hibernate.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @SequenceGenerator( name = "reviewSequence", sequenceName = "review_id_seq", allocationSize = 1)
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "reviewSequence")
    @Column(name = "id")
    private int id;

    @Column(name = "comment")
    private String comment;

    public Review(){
    }

    public Review(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
