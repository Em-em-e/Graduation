package com.endtcy.graduation.entity;
// default package

import java.util.HashSet;
import java.util.Set;


/**
 * Classes entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("unchecked")
public class Classes  implements java.io.Serializable {
    // Fields    
	private static final long serialVersionUID = 1L;
	private Long id;
     private String name;
     
	private Set students = new HashSet(0);
     private Set courses = new HashSet(0);


    // Constructors

    /** default constructor */
    public Classes() {
    }

	/** minimal constructor */
    public Classes(String name) {
        this.name = name;
    }
    
    /** full constructor */
    public Classes(String name, Set students, Set courses) {
        this.name = name;
        this.students = students;
        this.courses = courses;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Set getStudents() {
        return this.students;
    }
    
    public void setStudents(Set students) {
        this.students = students;
    }

    public Set getCourses() {
        return this.courses;
    }
    
    public void setCourses(Set courses) {
        this.courses = courses;
    }
   








}