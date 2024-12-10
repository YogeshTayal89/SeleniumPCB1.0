package utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryMethod implements IRetryAnalyzer {

	private int maxRetryCount = 2; // Maximum number of retries
	private int retryCount = 0; // Counter to track retry attempts

	@Override
	public boolean retry(ITestResult result) {
		if (retryCount < maxRetryCount) {
			System.out.println("Retrying test case " + result.getName() + " with status "
					+ getResultStatusName(result.getStatus()) + " for the " + (retryCount + 1) + " time(s).");
			retryCount++;
			return true; // Retry the test case
		}
		return false; // Do not retry the test case
	}

	private String getResultStatusName(int status) {
		String resultName = null;
		switch (status) {
		case ITestResult.SUCCESS:
			resultName = "SUCCESS";
			break;
		case ITestResult.FAILURE:
			resultName = "FAILURE";
			break;
		case ITestResult.SKIP:
			resultName = "SKIP";
			break;
		default:
			resultName = "UNKNOWN";
			break;
		}
		return resultName;
	}
}
