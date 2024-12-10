package utilities;

import java.io.File;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class DashboardReporter implements ITestListener {

	StringBuilder reporttext = null;

	StringBuilder resulttemplate = null;

	int count = 1;

	@Override
	public void onStart(ITestContext arg0) {

		reporttext = new StringBuilder();
		reporttext.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		reporttext.append("\n<testResults version=\"1.0\">");

	}

	@Override
	public void onTestStart(ITestResult arg0) {

		System.out.println(arg0);

	}

	@Override
	public void onTestSuccess(ITestResult arg0) {

		String tcname = String.valueOf(count++) + " -" + arg0.getInstanceName() + " - " + arg0.getName();
		createXMLString(tcname, String.valueOf(arg0.getEndMillis() - arg0.getStartMillis()), "true",
				"Passed. No issues observed during execution.");

	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		String tcname = String.valueOf(count++) + " -" + arg0.getInstanceName() + " - " + arg0.getName();
		createXMLString(tcname, String.valueOf(arg0.getEndMillis() - arg0.getStartMillis()), "false",
				"Failed due to " + arg0.getThrowable().getMessage());

	}

	@Override
	public void onFinish(ITestContext arg0) {
		reporttext.append("\n</testResults>");
		createReport(reporttext);

	}

	public void createXMLString(String tcname, String timetaken, String tcstatus, String message) {
		resulttemplate = new StringBuilder();
		resulttemplate.append("\n<httpSample t=\"" + timetaken + "\"  s=\"" + tcstatus + "\" lb=\"" + tcname + "\">");
		resulttemplate.append("\n<sample></sample>");
		resulttemplate.append("\n<responseData class=\"java.lang.String\">" + message + "</responseData>");
		resulttemplate.append("\n</httpSample>");
		reporttext.append(resulttemplate.toString());

	}

	public void createReport(StringBuilder reporttext) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document doc = builder.parse(new InputSource(new StringReader(reporttext.toString())));

			// Write the parsed document to an xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);

			StreamResult result = new StreamResult(new File("DashboardReport/DashboardReport.xml"));
			transformer.transform(source, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
