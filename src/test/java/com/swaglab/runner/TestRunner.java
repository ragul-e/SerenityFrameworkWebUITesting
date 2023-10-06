package com.swaglab.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = "src/test/resources/features/swagslab.feature",
		glue = "com.swaglabs.stepdef",
		tags = "@tag2 or @tag3 or @tag4 or @tag5 or @tag6 or @tag7 or @tag8 or @tag9 or @tag10 or @tag11 or @tag12"
		
		)


public class TestRunner {


}
