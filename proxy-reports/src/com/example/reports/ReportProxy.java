package com.example.reports;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO (student):
 * Implement Proxy responsibilities here:
 * - access check
 * - lazy loading
 * - caching of RealReport within the same proxmapy
 */
public class ReportProxy implements Report {

    private final String reportId;
    private final String title;
    private final String classification;
    private final AccessControl accessControl = new AccessControl();
    private RealReport realReport;

    public ReportProxy(String reportId, String title, String classification) {
        this.reportId = reportId;
        this.title = title;
        this.classification = classification;
    }

    @Override
    public void display(User user) {
        // Starter placeholder: intentionally incorrect.
        // Students should remove direct real loading on every call.
        if (!accessControl.canAccess(user, classification)) {
            System.out.println("[proxy] ACCESS DENIED -> user=" + user.getName()
                    + " role=" + user.getRole()
                    + " required=" + classification);
            return;
        }
        if (realReport != null) {
            realReport.display(user);
            return;
        }
        RealReport report = new RealReport(reportId, title, classification);
        report.display(user);
    }
}
