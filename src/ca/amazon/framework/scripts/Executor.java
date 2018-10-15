package ca.amazon.framework.scripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import ca.amazon.test.testdata.TestData;

public  abstract class Executor  extends TestBase{

protected static Logger logger  =  Logger.getLogger(Thread.currentThread().getStackTrace()[1].getClassName() );



/**
 * to create the following virtual  TestNG xml file for the script executions 
 * 
 * @param args
 * @throws ClassNotFoundException
 * @throws IllegalAccessException
 * @throws IllegalArgumentException
 * @throws InvocationTargetException
 * @throws IOException
 */
	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		
		/*
		 * For creating an virtual testng file
		 */
		XmlSuite suite = new XmlSuite();
		suite.setName("purchase products test suite");
		 
		XmlTest test = new XmlTest(suite);
		test.setName("purchase products test validations");
		List<XmlClass> classes = new ArrayList<XmlClass>();
		classes.add(new XmlClass("ca.amazon.framework.scripts.TestBase"));
		classes.add(new XmlClass("ca.amazon.test.scripts.PurchaseProducts"));
		test.setXmlClasses(classes) ;

		
		/*'
		 * To execute the scripts
		 */
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		TestNG tng = new TestNG();
		tng.setXmlSuites(suites);
		tng.run();

		
		
	}

}
