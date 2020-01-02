package exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Climbing Attempt Not Found")
public class ClimbingAttemptNotFoundException extends EntityNotFoundException {
    private static final long serialVersionUID = -2591687720244290021L;
}
