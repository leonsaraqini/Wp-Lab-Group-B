package mk.ukim.finki.lab_group_b.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Artist {
    Long id;
    String firstName;
    String lastName;
    String bio;
}
