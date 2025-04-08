package dev.courses.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("database_sequence")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DataBaseSequence {
    @Id
    private String id;

    private long seq;
}
