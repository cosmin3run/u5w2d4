package epicode.u5w2d4.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class ErrorsPayload {
    private String message;
    private LocalDate timestamp;
}

