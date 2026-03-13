package com.ticketsystem.runners;

import com.ticketsystem.utils.Constantes;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {
                Constantes.FEATURES_PATH + "/00_flujo_autenticacion_unificado.feature"
        },
        glue = Constantes.GLUE
)
public class CucumberTestSuite {
}
