import java.util.*;

public class OnboardingService {

    private final StudentRepository repo;
    private final StudentParser parser;
    private final StudentValidator validator;
    private final StudentPrinter printer;

    public OnboardingService(StudentRepository repo) {

        this.repo = repo;

        this.parser = new StudentParser();
        this.validator = new StudentValidator();
        this.printer = new StudentPrinter();
    }

    public void registerFromRawInput(String raw) {

        printer.printInput(raw);

        ParsedStudent ps = parser.parse(raw);

        List<String> errors = validator.validate(ps);

        if (!errors.isEmpty()) {
            printer.printErrors(errors);
            return;
        }

        String id = IdUtil.nextStudentId(repo.count());

        StudentRecord rec = new StudentRecord(
                id,
                ps.name,
                ps.email,
                ps.phone,
                ps.program);

        repo.save(rec);

        printer.printSuccess(id, repo.count());

        printer.printRecord(rec);
    }
}