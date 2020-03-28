package es.ulpgc.eite.cleancode.clickcounter;

import android.content.Context;

import androidx.test.rule.ActivityTestRule;

import es.ulpgc.eite.cleancode.clickcounter.counter.CounterActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class CounterInstrumentedRobot {


  private ActivityTestRule<CounterActivity> testRule= new ActivityTestRule<>(
      CounterActivity.class, false, false
  );


  public void iniciamos_pantalla_COUNTER() {
    testRule.launchActivity(null);
    Context ctx = testRule.getActivity();
  }


  public void iniciamos_pantalla_CLICKS() {


  }

  public void resumimos_pantalla_COUNTER() {

  }

  public void finalizamos_pantalla_CLICKS() {


  }


  public void pausamos_pantalla_COUNTER() {

  }

  public void texto_en_COUNTER_muestra(int numero) {
//    CounterActivity activity = counterTestCtrl.get();
//    TextView tv = activity.findViewById(R.id.tvCounter);
//    int valor = Integer.valueOf(tv.getText().toString());
//    assertThat(valor, equalTo(numero));

    String text= String.valueOf(numero);

    onView(withId(R.id.tvCounter))
        .check(matches(isDisplayed()))
        //.check(matches(isEnabled()))
        .check(matches(withText(text)));

  }


  public void texto_en_CLICKS_muestra(int numero) {
//    ClicksActivity activity = clicksTestCtrl.get();
//    TextView tv = activity.findViewById(R.id.tvClicks);
//    int valor = Integer.valueOf(tv.getText().toString());
//    assertThat(valor, equalTo(numero));
  }


  public void botón_INCREMENT_se_encuentra(boolean activado) {

//    CounterActivity activity = counterTestCtrl.get();
//    Button btn = activity.findViewById(R.id.btnIncrement);
//    assertThat(btn.isEnabled(), equalTo(activado));
  }

  public void botón_RESET_se_encuentra(boolean activado) {
//    CounterActivity activity = counterTestCtrl.get();
//    Button btn = activity.findViewById(R.id.btnReset);
//    assertThat(btn.isEnabled(), equalTo(activado));
    
  }

  public void botón_CLICKS_se_encuentra(boolean activado) {
//    CounterActivity activity = counterTestCtrl.get();
//    Button btn = activity.findViewById(R.id.btnClicks);
//    assertThat(btn.isEnabled(), equalTo(activado));
    
  }

  public void botón_CLEAR_se_encuentra(boolean activado) {
//    ClicksActivity activity = clicksTestCtrl.get();
//    Button btn = activity.findViewById(R.id.btnClear);
//    assertThat(btn.isEnabled(), equalTo(activado));
  }

  public void hacemos_clic_en_botón_INCREMENT() {
//    CounterActivity activity = counterTestCtrl.get();
//    Button btn = activity.findViewById(R.id.btnIncrement);
//    btn.performClick();
  }

  public void hacemos_clic_en_botón_CLICKS() {
//    CounterActivity activity = counterTestCtrl.get();
//    Button btn = activity.findViewById(R.id.btnClicks);
//    btn.performClick();

    onView(withId(R.id.btnClicks)).perform(click());
  }


  public void hacemos_clic_en_botón_CLEAR() {
//    ClicksActivity activity = clicksTestCtrl.get();
//    Button btn = activity.findViewById(R.id.btnClear);
//    btn.performClick();
  }


  public void hacemos_clic_en_botón_RESET() {
//    CounterActivity activity = counterTestCtrl.get();
//    Button btn = activity.findViewById(R.id.btnReset);
//    btn.performClick();
  }


  public void rotamos_pantalla_COUNTER() {

  }

  public void rotamos_pantalla_CLICKS() {

  }
}
