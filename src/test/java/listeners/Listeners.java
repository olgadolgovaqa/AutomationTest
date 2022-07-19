package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Test " + iTestResult.getName() + " started");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Test " + iTestResult.getName() + " finished in: " + (iTestResult.getEndMillis() - iTestResult.getStartMillis()));
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Test failed: " + iTestResult.getName() + " " + iTestResult.getEndMillis());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("Test skipped: " + iTestResult.getName() + " " + iTestResult.getEndMillis());

    }

}
