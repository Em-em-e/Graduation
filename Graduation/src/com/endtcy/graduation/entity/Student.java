package com.endtcy.graduation.entity;

import java.util.HashSet;
import java.util.Set;


/**
 * Student entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("unchecked")
public class Student  implements java.io.Serializable {


    // Fields    
	private static final long serialVersionUID = 1L;
	private Long id;
     private Classes classes;
     private String name;
     private String username;
     private String password;
     private String studentid;
     private Set studentworks = new HashSet(0);


    // Constructors

    /** default constructor */
    public Student() {
    }

    
    /** full constructor */
    public Student(Classes classes, String name, String username, String password, Set studentworks) {
        this.classes = classes;
        this.name = name;
        this.username = username;
        this.password = password;
        this.studentworks = studentworks;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public Classes getClasses() {
        return this.classes;
    }
    
    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public Set getStudentworks() {
        return this.studentworks;
    }
    
    public void setStudentworks(Set studentworks) {
        this.studentworks = studentworks;
    }


	public String getStudentid() {
		return studentid;
	}


	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
   








}