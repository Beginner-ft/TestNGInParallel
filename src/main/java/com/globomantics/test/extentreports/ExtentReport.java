package com.globomantics.test.extentreports;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReport {
	static ExtentReports extent;

	public static ExtentReports ReportGenerator() {
		extent = new ExtentReports();

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
		//String repName = "Test-Report-" + timeStamp + ".html";

		String path = "/var/jenkins_home/workspace/Jenkins_POC1/reports/" + "index.html";
		//String path=System.getProperty("user.dir") + "/reports/ " + "index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Globmantic Automation Test Report");
		reporter.config().setDocumentTitle("TestResults");
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "XYZ");
		return extent;

	}
}
