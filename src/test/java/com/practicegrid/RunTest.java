package com.practicegrid;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Yogesh on 25-11-2016.
 */


@RunWith(Cucumber.class)
@CucumberOptions(format="html:target/cucumber.html",
                features="src/test/feature/",
                tags="@smoke")

public class RunTest {
}
