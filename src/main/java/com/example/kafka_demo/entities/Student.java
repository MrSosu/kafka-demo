package com.example.kafka_demo.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    private Long id;
    private String nome;
    private String cognome;

}
