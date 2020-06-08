package ir.omidashouri.conference.model;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Registration {

    @NotEmpty
    private String name;
}
