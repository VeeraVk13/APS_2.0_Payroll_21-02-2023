package listeners;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;


import actionHelper.WebActionHelperMethods;
import constant.APS_contsant;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import reportManager.ExtentManager;

import java.util.concurrent.ConcurrentHashMap;

public class TestListner implements ITestListener {

	private ConcurrentHashMap<String, ExtentTest> allTests = new ConcurrentHashMap<>();
	String reportFolderPath = System.getProperty("user.dir") + APS_contsant.AutomationReports;
	String reportName = WebActionHelperMethods.dateName() + "_AutomationReport.html";

	// After ending all tests, below method runs.
	@Override
	public void onFinish(ITestContext iTestContext) {
		ExtentManager.getInstance().flush();
	}

	@Override
	public void onTestStart(ITestResult iTestResult) {
		ExtentTest extentTest = ExtentManager.createInstance(reportFolderPath, reportName)
				.createTest(iTestResult.getMethod().getRealClass().getSimpleName());
		allTests.put(iTestResult.getClass().getSimpleName(), extentTest);
	

		ExtentManager.setTest(extentTest);
		ExtentManager.getInstance().flush();
	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		ExtentManager.getTest().get().assignCategory(iTestResult.getClass().getSimpleName());
		ExtentManager.getTest().get()
				.createNode(MarkupHelper.createLabel("Test passed", ExtentColor.GREEN).getMarkup());
		ExtentManager.getTest().get().log(Status.PASS, iTestResult.getClass().getSimpleName());
		ExtentManager.getInstance().flush();
	
	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {

		try {

			ExtentManager.getTest().get()
					.createNode(MarkupHelper.createLabel("Test Failed", ExtentColor.RED).getMarkup())
					.fail(iTestResult.getThrowable());
			String screenshotPath = WebActionHelperMethods.Screenshot_method(iTestResult.getName());
			ExtentManager.getTest().get().log(Status.FAIL, iTestResult.getClass().getSimpleName());
			ExtentManager.getTest().get().fail(iTestResult.getName()).addScreenCaptureFromPath(screenshotPath);
			ExtentManager.getInstance().flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult iTestResult) {

		ExtentManager.getTest().get().log(Status.SKIP, iTestResult.getClass().getSimpleName());
		ExtentManager.getInstance().flush();
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
	}

	@Override
	public void onStart(ITestContext iTestContext) {

	}
}