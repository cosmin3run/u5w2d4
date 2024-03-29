package epicode.u5w2d4.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class ErrorsPayloadWithList extends ErrorsPayload{
    private List<String> errorsList;

    public ErrorsPayloadWithList(String message, LocalDate timestamp, List<String> errorsList){
        super(message, timestamp);
        this.errorsList=errorsList;
    }
}
