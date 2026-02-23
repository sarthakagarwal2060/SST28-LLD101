public class ExportResult {

    public final String contentType;
    public final byte[] bytes;
    public final String error;

    private ExportResult(String contentType, byte[] bytes, String error) {
        this.contentType = contentType;
        this.bytes = bytes;
        this.error = error;
    }

    public static ExportResult ok(String type, byte[] bytes) {
        return new ExportResult(type, bytes, null);
    }

    public static ExportResult error(String msg) {
        return new ExportResult(null, null, msg);
    }

    public boolean isError() {
        return error != null;
    }
}