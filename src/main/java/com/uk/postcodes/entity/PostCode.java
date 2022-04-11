package com.uk.postcodes.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "POST_CODE")
public class PostCode {

    @Id
    @GeneratedValue
    private int id;
    private String postCode;
    private String outerCode;
    private String innerCode;
}
