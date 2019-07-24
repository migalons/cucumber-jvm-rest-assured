package es.axa.test.data;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Repository {

    private final Integer id;
    private final String name;
    private final String fullName;
}
