import java.util.*;

public class StudentValidator {

    public List<String> validate(ParsedStudent ps) {

        List<String> errors = new ArrayList<>();

        if (ps.name.isBlank())
            errors.add("name is required");

        if (ps.email.isBlank() || !ps.email.contains("@"))
            errors.add("email is invalid");

        if (ps.phone.isBlank() || !ps.phone.chars().allMatch(Character::isDigit))
            errors.add("phone is invalid");

        if (!(ps.program.equals("CSE")
                || ps.program.equals("AI")
                || ps.program.equals("SWE")))
            errors.add("program is invalid");

        return errors;
    }
}