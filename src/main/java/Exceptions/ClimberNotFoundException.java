package Exceptions;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "The mountain giveth, the mountain taketh away")
public class ClimberNotFoundException extends EntityNotFoundException {

	private static final long serialVersionUID = -2591687720244290021L;
}
