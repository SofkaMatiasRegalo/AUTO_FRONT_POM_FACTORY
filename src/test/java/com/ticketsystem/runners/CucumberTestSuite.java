package com.ticketsystem.runners;

import com.ticketsystem.utils.Constantes;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                Constantes.FEATURES_PATH + "/01_registro.feature",
                Constantes.FEATURES_PATH + "/03_login.feature",
                Constantes.FEATURES_PATH + "/02_cierre_sesion.feature"
        },
        glue = Constantes.GLUE,
        plugin = {Constantes.PLUGIN_PRETTY}
)
public class CucumberTestSuite {
}
