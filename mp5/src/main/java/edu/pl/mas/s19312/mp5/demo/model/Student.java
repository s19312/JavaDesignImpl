package edu.pl.mas.s19312.mp5.demo.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Student extends Person {

    @ElementCollection
    @CollectionTable
    @Builder.Default
    private Set<Double> grades = new HashSet<>();

}
