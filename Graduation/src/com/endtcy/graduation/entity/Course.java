package com.endtcy.graduation.entity;

import java.util.HashSet;
import java.util.Set;


/**
 * Course entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("unchecked")
public class Course  implements java.io.Serializable {


    // Fields    
	private static final long serialVersionUID = 1L;
	private Long id;
     private Teacher teacher;
     private Classes classes;
     private Term term;
     private String name;
	private Set works = new HashSet(0);


    // Constructors

    /** default constructor */
    public Course() {
    }

    
    /** full constructor */
    public Course(Teacher teacher, Classes classes, Term term, String name, Set works) {
        this.teacher = teacher;
        this.classes = classes;
        this.term = term;
        this.name = name;
        this.works = works;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return this.teacher;
    }
    
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Classes getClasses() {
        return this.classes;
    }
    
    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public Term getTerm() {
        return this.term;
    }
    
    public void setTerm(Term term) {
        this.term = term;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Set getWorks() {
        return this.works;
    }
    
    public void setWorks(Set works) {
        this.works = works;
    }
   








}