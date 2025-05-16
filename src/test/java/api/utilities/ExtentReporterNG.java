package api.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

    private static ExtentReports extent;

    public static ExtentReports getReporterObject() {
        if (extent == null) {
            String path = System.getProperty("user.dir") + "/reports/index.html"; // use forward slashes
            ExtentSparkReporter reporter = new ExtentSparkReporter(path);
            reporter.config().setReportName("REST Assured API Test Report");
            reporter.config().setDocumentTitle("API Test Results");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("Tester", "Praveen M");
            extent.setSystemInfo("Framework", "REST Assured BDD");
        }
        return extent;
    }
}
