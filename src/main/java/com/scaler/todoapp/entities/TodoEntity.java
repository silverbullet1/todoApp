package com.scaler.todoapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column()
    @JsonIgnore
    private Integer id;

    @JsonProperty
    @Column(nullable = false)
    private String task;

    @JsonProperty
    private boolean status;

}
