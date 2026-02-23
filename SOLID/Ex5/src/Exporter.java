public abstract class Exporter {

    public final ExportResult export(ExportRequest req) {

        if (req == null || req.title == null || req.body == null) {
            return ExportResult.error("Invalid request");
        }

        return doExport(req);
    }

    protected abstract ExportResult doExport(ExportRequest req);
}