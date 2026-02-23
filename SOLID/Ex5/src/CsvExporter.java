import java.nio.charset.StandardCharsets;

public class CsvExporter extends Exporter {

    @Override
    protected ExportResult doExport(ExportRequest req) {

        String title = escape(req.title);
        String body = escape(req.body);

        String csv = "title,body\n" +
                title + "," +
                body + "\n";

        return ExportResult.ok(
                "text/csv",
                csv.getBytes(StandardCharsets.UTF_8));
    }

    private String escape(String s) {

        if (s.contains(",") ||
                s.contains("\n") ||
                s.contains("\"")) {

            s = s.replace("\"", "\"\"");
            return "\"" + s + "\"";
        }

        return s;
    }
}