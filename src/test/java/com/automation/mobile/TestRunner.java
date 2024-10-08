package com.automation.mobile;

import com.automation.helpers.ThreadLocalHelper;
import io.cucumber.testng.*;
import org.testng.annotations.*;

@CucumberOptions(
    features = "src/test/java/com/automation/features",
    glue = {"com.automation.steps"},
    plugin = {
      "pretty",
      "summary",
      "com.automation.mobile.listener.CucumberExtentReportListener:",
      "json:target/cucumber-reports/cucumber.json"
    })
public class TestRunner {
  private TestNGCucumberRunner testNGCucumberRunner;

  @BeforeClass(alwaysRun = true)
  public void setUpClass() {
    this.testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    System.out.println("after test");
  }

  @Test(
      groups = "cucumber scenarios",
      description = "Runs Cucumber Scenarios",
      dataProvider = "scenarios")
  public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
    ThreadLocalHelper.feature.set(pickleWrapper.getPickle());
    this.testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
  }

  @DataProvider
  public Object[][] scenarios() {
    return this.testNGCucumberRunner == null
        ? new Object[0][0]
        : this.testNGCucumberRunner.provideScenarios();
  }

  @AfterClass(alwaysRun = true)
  public void tearDownClass() {
    if (this.testNGCucumberRunner != null) {
      this.testNGCucumberRunner.finish();
    }
  }

}
