package es.ulpgc.eite.cleancode.clickcounter.test;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import es.ulpgc.eite.cleancode.clickcounter.R;
import es.ulpgc.eite.cleancode.clickcounter.counter.CounterActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;


public class CounterSteps {

  @Rule
  public ActivityTestRule<CounterActivity> testRule =
      new ActivityTestRule(CounterActivity.class, true, false);

  //private Activity activity;

  @Before("@counter-feature")
  public void setUp() {
    testRule.launchActivity(new Intent());
    //activity = testRule.getActivity();
  }

  @After("@counter-feature")
  public void tearDown() {
    testRule.finishActivity();
  }


  //CounterInstrumentedRobot robot = new CounterInstrumentedRobot();

  @Given("iniciamos pantalla COUNTER")
  public void iniciamosPantallaCOUNTER() {
    //robot.iniciamos_pantalla_COUNTER();
  }

//  @And("texto en COUNTER muestra {numero}")
//  public void textoEnCOUNTERMuestra(int numero) {
//    //robot.texto_en_COUNTER_muestra(numero);
//
//    String text= String.valueOf(numero);
//
//    onView(withId(R.id.tvCounter))
//        .check(matches(isDisplayed()))
//        .check(matches(withText(text)));
//  }


//  @And("texto en CLICKS muestra {int}")
//  public void textoEnCLICKSMuestra(int numero) {
//    //robot.texto_en_CLICKS_muestra(numero);
//
//    String text= String.valueOf(numero);
//
//    onView(withId(R.id.tvClicks))
//        .check(matches(isDisplayed()))
//        .check(matches(withText(text)));
//
//  }

  @And("^texto en COUNTER muestra (\\d+)$")
  public void textoEnCOUNTERMuestra(int numero) {
    String text= String.valueOf(numero);

    onView(withId(R.id.tvCounter))
        .check(matches(isDisplayed()))
        .check(matches(withText(text)));
  }

  @And("^texto en CLICKS muestra (\\d+)$")
  public void textoEnCLICKSMuestra(int numero) {

    String text= String.valueOf(numero);

    onView(withId(R.id.tvClicks))
        .check(matches(isDisplayed()))
        .check(matches(withText(text)));
  }

  @And("boton INCREMENT se encuentra ACTIVADO")
  public void botonINCREMENTSeEncuentraACTIVADO() {
    //robot.boton_INCREMENT_se_encuentra(true);

    onView(withId(R.id.btnIncrement))
        .check(matches(isDisplayed()))
        .check(matches(true ? isEnabled() : not(isEnabled())));
  }

  @And("boton RESET se encuentra DESACTIVADO")
  public void botonRESETSeEncuentraDESACTIVADO() {
    //robot.boton_RESET_se_encuentra(false);

    onView(withId(R.id.btnReset))
        .check(matches(isDisplayed()))
        .check(matches(false ? isEnabled() : not(isEnabled())));
  }

  @And("boton CLICKS se encuentra DESACTIVADO")
  public void botonCLICKSSeEncuentraDESACTIVADO() {
    //robot.boton_CLICKS_se_encuentra(false);

    onView(withId(R.id.btnClicks))
        .check(matches(isDisplayed()))
        .check(matches(false ? isEnabled() : not(isEnabled())));
  }


  @And("boton CLICKS se encuentra ACTIVADO")
  public void botonCLICKSSeEncuentraACTIVADO() {
    //robot.boton_CLICKS_se_encuentra(true);

    onView(withId(R.id.btnClicks))
        .check(matches(isDisplayed()))
        .check(matches(true ? isEnabled() : not(isEnabled())));
  }

  @When("hacemos clic en boton INCREMENT")
  public void hacemosClicEnBotónINCREMENT() {
    //robot.hacemos_clic_en_boton_INCREMENT();

    onView(withId(R.id.btnIncrement)).perform(click());
  }

  @And("boton RESET se encuentra ACTIVADO")
  public void botonRESETSeEncuentraACTIVADO() {
    //robot.boton_RESET_se_encuentra(true);

    onView(withId(R.id.btnReset))
        .check(matches(isDisplayed()))
        .check(matches(true ? isEnabled() : not(isEnabled())));
  }



  @When("hacemos clic en boton CLICKS")
  public void hacemosClicEnBotónCLICKS() {
    //robot.hacemos_clic_en_boton_CLICKS();

    onView(withId(R.id.btnClicks)).perform(click());
  }

  @Then("pausamos pantalla COUNTER")
  public void pausamosPantallaCOUNTER() {
    //robot.pausamos_pantalla_COUNTER();
  }

  @And("iniciamos pantalla CLICKS")
  public void iniciamosPantallaCLICKS() {
    //robot.iniciamos_pantalla_CLICKS();

    try {
      Thread.sleep(700);
    } catch (InterruptedException e) {

    }
  }

  @And("boton CLEAR se encuentra ACTIVADO")
  public void botonCLEARSeEncuentraACTIVADO() {
    //robot.boton_CLEAR_se_encuentra(true);

    onView(withId(R.id.btnClear))
        .check(matches(isDisplayed()))
        .check(matches(true ? isEnabled() : not(isEnabled())));
  }


  @And("boton CLEAR se encuentra DESACTIVADO")
  public void botonCLEARSeEncuentraDESACTIVADO() {
    //robot.boton_CLEAR_se_encuentra(false);

    onView(withId(R.id.btnClear))
        .check(matches(isDisplayed()))
        .check(matches(false ? isEnabled() : not(isEnabled())));
  }

  @And("rotamos pantalla CLICKS")
  public void rotamosPantallaCLICKS() {
    //robot.rotamos_pantalla_CLICKS();
  }

  @When("hacemos clic en boton CLEAR")
  public void hacemosClicEnBotónCLEAR() {
    //robot.hacemos_clic_en_boton_CLEAR();

    onView(withId(R.id.btnClear)).perform(click());
  }


  @And("finalizamos pantalla CLICKS")
  public void finalizamosPantallaCLICKS() {
    //robot.finalizamos_pantalla_CLICKS();

    pressBack();

    try {
      Thread.sleep(700);
    } catch (InterruptedException e) {

    }
  }

//  @And("finalizamos pantalla COUNTER")
//  public void finalizamosPantallaCOUNTER() {
//
//    pressBack();
//
//    try {
//      Thread.sleep(700);
//    } catch (InterruptedException e) {
//
//    }
//  }

  @And("resumimos pantalla COUNTER")
  public void resumimosPantallaCOUNTER() {
    //robot.resumimos_pantalla_COUNTER();

    try {
      Thread.sleep(700);
    } catch (InterruptedException e) {

    }
  }

  @When("hacemos clic en boton RESET")
  public void hacemosClicEnBotónRESET() {
    //robot.hacemos_clic_en_boton_RESET();

    onView(withId(R.id.btnReset)).perform(click());
  }


  @When("rotamos pantalla COUNTER")
  public void rotamosPantallaCOUNTER() {
    //robot.rotamos_pantalla_COUNTER();

    Context context = ApplicationProvider.getApplicationContext();
    int orientation = context.getResources().getConfiguration().orientation;
    Activity activity = testRule.getActivity();

    if(orientation  == Configuration.ORIENTATION_PORTRAIT) {
      activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    } else {
      activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    try {
      Thread.sleep(700);
    } catch (InterruptedException e) {

    }
  }


}
