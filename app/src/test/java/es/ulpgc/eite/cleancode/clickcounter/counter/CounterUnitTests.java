package es.ulpgc.eite.cleancode.clickcounter.counter;

import androidx.test.filters.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

//@RunWith(AndroidJUnit4ClassRunner.class)
@RunWith(RobolectricTestRunner.class)
@LargeTest
public class CounterUnitTests {

  CounterUnitRobot robot = new CounterUnitRobot();

  @Test
  public void pulsar_boton_COUNTER_1_veces() {

    // Given("iniciamos pantalla COUNTER")
    robot.iniciamos_pantalla_COUNTER();
    // And("texto en COUNTER muestra 0")
    robot.texto_en_COUNTER_muestra(0);
    // And("botón INCREMENT se encuentra ACTIVADO")
    robot.botón_INCREMENT_se_encuentra(true);
    // And("botón RESET se encuentra DESACTIVADO")
    robot.botón_RESET_se_encuentra(false);
    // And("botón CLICKS se encuentra DESACTIVADO")
    robot.botón_CLICKS_se_encuentra(false);


    // When("hacemos clic en botón INCREMENT")
    robot.hacemos_clic_en_botón_INCREMENT();

    // Then("texto en COUNTER muestra 1")
    robot.texto_en_COUNTER_muestra(1);
    // And("botón INCREMENT se encuentra ACTIVADO")
    robot.botón_INCREMENT_se_encuentra(true);
    // And("botón RESET se encuentra ACTIVADO")
    robot.botón_RESET_se_encuentra(true);
    // And("botón CLICKS se encuentra ACTIVADO")
    robot.botón_CLICKS_se_encuentra(true);

  }


  @Test
  public void pulsar_boton_COUNTER_10_veces() {

    // Given("iniciamos pantalla COUNTER")
    robot.iniciamos_pantalla_COUNTER();
    // And("texto en COUNTER muestra 0")
    robot.texto_en_COUNTER_muestra(0);
    // And("botón INCREMENT se encuentra ACTIVADO")
    robot.botón_INCREMENT_se_encuentra(true);
    // And("botón RESET se encuentra DESACTIVADO")
    robot.botón_RESET_se_encuentra(false);
    // And("botón CLICKS se encuentra DESACTIVADO")
    robot.botón_CLICKS_se_encuentra(false);

    // When("hacemos clic en botón INCREMENT")
    robot.hacemos_clic_en_botón_INCREMENT();
    // And("hacemos clic en botón INCREMENT")
    robot.hacemos_clic_en_botón_INCREMENT();
    // And("hacemos clic en botón INCREMENT")
    robot.hacemos_clic_en_botón_INCREMENT();
    // And("hacemos clic en botón INCREMENT")
    robot.hacemos_clic_en_botón_INCREMENT();
    // And("hacemos clic en botón INCREMENT")
    robot.hacemos_clic_en_botón_INCREMENT();
    // And("hacemos clic en botón INCREMENT")
    robot.hacemos_clic_en_botón_INCREMENT();
    // And("hacemos clic en botón INCREMENT")
    robot.hacemos_clic_en_botón_INCREMENT();
    // And("hacemos clic en botón INCREMENT")
    robot.hacemos_clic_en_botón_INCREMENT();
    // And("hacemos clic en botón INCREMENT")
    robot.hacemos_clic_en_botón_INCREMENT();
    // And("hacemos clic en botón INCREMENT")
    robot.hacemos_clic_en_botón_INCREMENT();

    // Then("texto en COUNTER muestra 0")
    robot.texto_en_COUNTER_muestra(0);
    // And("botón INCREMENT se encuentra ACTIVADO")
    robot.botón_INCREMENT_se_encuentra(true);
    // And("botón RESET se encuentra DESACTIVADO")
    robot.botón_RESET_se_encuentra(false);
    // And("botón CLICKS se encuentra ACTIVADO")
    robot.botón_CLICKS_se_encuentra(true);

  }


  @Test
  public void pulsar_boton_COUNTER_10_veces_y_ver_numero_clicks() {

    // Given("iniciamos pantalla COUNTER")
    robot.iniciamos_pantalla_COUNTER();
    // And("texto en COUNTER muestra 0")
    robot.texto_en_COUNTER_muestra(0);
    // And("botón INCREMENT se encuentra ACTIVADO")
    robot.botón_INCREMENT_se_encuentra(true);
    // And("botón RESET se encuentra DESACTIVADO")
    robot.botón_RESET_se_encuentra(false);
    // And("botón CLICKS se encuentra DESACTIVADO")
    robot.botón_CLICKS_se_encuentra(false);

    // When("hacemos clic en botón INCREMENT")
    robot.hacemos_clic_en_botón_INCREMENT();
    // And("hacemos clic en botón INCREMENT")
    robot.hacemos_clic_en_botón_INCREMENT();
    // And("hacemos clic en botón INCREMENT")
    robot.hacemos_clic_en_botón_INCREMENT();
    // And("hacemos clic en botón INCREMENT")
    robot.hacemos_clic_en_botón_INCREMENT();
    // And("hacemos clic en botón INCREMENT")
    robot.hacemos_clic_en_botón_INCREMENT();
    // And("hacemos clic en botón INCREMENT")
    robot.hacemos_clic_en_botón_INCREMENT();
    // And("hacemos clic en botón INCREMENT")
    robot.hacemos_clic_en_botón_INCREMENT();
    // And("hacemos clic en botón INCREMENT")
    robot.hacemos_clic_en_botón_INCREMENT();
    // And("hacemos clic en botón INCREMENT")
    robot.hacemos_clic_en_botón_INCREMENT();
    // And("hacemos clic en botón INCREMENT")
    robot.hacemos_clic_en_botón_INCREMENT();
    // And("hacemos clic en botón CLICKS")
    robot.hacemos_clic_en_botón_CLICKS();

    // Then("iniciamos pantalla CLICKS")
    robot.iniciamos_pantalla_CLICKS();
    // Then("texto en COUNTER muestra 10")
    robot.texto_en_CLICKS_muestra(10);
    // And("botón CLEAR se encuentra ACTIVADO")
    robot.botón_CLEAR_se_encuentra(true);

  }
}
