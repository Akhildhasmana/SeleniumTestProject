package testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"
                , "html:target/cucumber"
                , "summary"
                , "me.jvt.cucumber.report.PrettyReports:target/Reports/cucumber-html-reports"}
        ,features = {"src/test/resources/features"}
        ,glue = {"/stepdefinitions"}
        ,snippets = SnippetType.CAMELCASE
        ,dryRun=false
        ,monochrome=true
)

public class TestRunner {

    @BeforeClass
    public static void initialize() {
        //The code here will be executed once and before all tests in the class.
    }

    @AfterClass
    public static void quit(){
        //The code here will be executed once and after all tests in the class.
    }
}
