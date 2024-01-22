package com.choucar.web.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.util.logging.Logger;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"json:target/build/cucumber.json"},
        features = "src/test/resources/features",
        glue = "com.choucar.web.stepsdefinitions",
        tags = "@Exito"
)
public class CucumberTestSuite {

    private static final Logger logger = Logger.getLogger(CucumberTestSuite.class.getName());

    @BeforeClass
    public static void beforeAll() {
        String bigChoucar =
                "\n  ####    #      #    ########    #       #     ####        ####          ######      \n" +
                        " #        #      #    #      #    #       #    #           #    #         #     #     \n" +
                        " #        #      #    #      #    #       #    #          #      #        ######      \n" +
                        " #        ########    #      #    #       #    #          #########       #     #     \n" +
                        " #        #      #    #      #    #       #    #         #         #      #      ##   \n" +
                        "  ####    #      #    ########     #######      ####    #           #     #       ##  \n";

        logger.info("Before all execution >>> \n" + bigChoucar);

    }
}
