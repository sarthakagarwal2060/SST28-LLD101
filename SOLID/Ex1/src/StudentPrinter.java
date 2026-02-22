import java.util.*;

public class StudentPrinter {

    public void printInput(String raw) {
        System.out.println("INPUT: " + raw);
    }

    public void printErrors(List<String> errors) {

        System.out.println("ERROR: cannot register");

        for (String e : errors) {
            System.out.println("- " + e);
        }
    }

    public void printSuccess(String id, int count) {

        System.out.println("OK: created student " + id);
        System.out.println("Saved. Total students: " + count);
        System.out.println("CONFIRMATION:");
    }

    public void printRecord(StudentRecord rec) {
        System.out.println(rec);
    }
}