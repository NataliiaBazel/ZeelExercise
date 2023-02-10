package com.Nataliia.project.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


    @RunWith(Cucumber.class)
    @CucumberOptions(
            plugin = {"html:target/cucumber-report.html",
                    "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                    "json:target/cucumber.json"},
            features = "src/test/resources/features",
            glue = "com/Nataliia/project/step_definitions",
            dryRun = false,
            tags = "@ua"
    )
    public class CukesRunner {

    }

