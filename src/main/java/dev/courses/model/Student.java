package dev.courses.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @Transient
    public static final String SEQUENCE_NAME = "student_sequence";
    @Id
    private long rno;
    public String name;
    public String address;
}
