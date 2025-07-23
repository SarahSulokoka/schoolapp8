package gr.aueb.cf.schoolapp.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserInsertDTO {

    @NotNull(message = "Το username δεν μπορεί να είναι κενό.")
    @Size(min = 2, max = 20, message = "Το username πρέπει να έχει μέγεθος από 2 εώς 20 χαρακτήρες")
    private String username;

    @NotNull(message = "Το password δεν μπορεί να είναι Null.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=])^.{8,}$",
            message = " Το password θα πρέπει να περιέχει τουλάχιστον ένα πεζό ," +
                    " ένα κεφαλαίο, ένα ψηφίο και έναν ειδικό χαρακτήρα, χωρίς κενά.")
    private String password;

    @NotNull(message = "Ο Ρόλος δεν μπορεί να είναι κενός")
    private String role;
}
