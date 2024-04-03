package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="COURSE_DTLS")
public class Course {

	private Integer cid;
	private String cname;
	private Double price;
}
