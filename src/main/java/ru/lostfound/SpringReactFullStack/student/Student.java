package ru.lostfound.SpringReactFullStack.student;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Student {
    private Long id;
    private String name;
    private String email;
    private Gender gender;
}
