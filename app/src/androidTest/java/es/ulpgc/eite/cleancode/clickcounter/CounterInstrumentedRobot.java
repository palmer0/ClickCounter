package es.ulpgc.eite.cleancode.clickcounter;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.rule.ActivityTestRule;

import es.ulpgc.eite.cleancode.clickcounter.clicks.ClicksActivity;
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

public class CounterInstrumentedRobot {


  private ActivityTestRule<CounterActivity> counterTestRule =
      new ActivityTestRule<>(
          CounterActivity.class,false, false);

  private ActivityTestRule<ClicksActivity> clicksTestRule =
      new ActivityTestRule<>(
          ClicksActivity.class,false, false);


  public void iniciamos_pantalla_COUNTER() {
    counterTestRule.launchActivity(null);
    //Context ctx = counterTestRule.getActivity();
  }


  public void iniciamos_pantalla_CLICKS() {
    //clicksTestRule.launchActivity(null);

    try {
      Thread.sleep(700);
    } catch (InterruptedException e) {

    }
  }

  public void resumimos_pantalla_COUNTER() {
    //counterTestRule.finishActivity();
    //counterTestRule.launchActivity(null);

    /*
    try {
      Thread.sleep(700);
    } catch (InterruptedException e) {

    }
    */
  }

  public void finalizamos_pantalla_CLICKS() {
    //clicksTestRule.finishActivity();
    pressBack();

    try {
      Thread.sleep(700);
    } catch (InterruptedException e) {

    }


  }


  public void pausamos_pantalla_COUNTER() {
    //counterTestRule.finishActivity();
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

    String text= String.valueOf(numero);

    onView(withId(R.id.tvClicks))
        .check(matches(isDisplayed()))
        .check(matches(withText(text)));
  }


  public void botón_INCREMENT_se_encuentra(boolean activado) {

//    CounterActivity activity = counterTestCtrl.get();
//    Button btn = activity.findViewById(R.id.btnIncrement);
//    assertThat(btn.isEnabled(), equalTo(activado));

    onView(withId(R.id.btnIncrement))
        .check(matches(isDisplayed()))
        .check(matches(activado ? isEnabled() : not(isEnabled())));
  }

  public void botón_RESET_se_encuentra(boolean activado) {
//    CounterActivity activity = counterTestCtrl.get();
//    Button btn = activity.findViewById(R.id.btnReset);
//    assertThat(btn.isEnabled(), equalTo(activado));

    onView(withId(R.id.btnReset))
        .check(matches(isDisplayed()))
        .check(matches(activado ? isEnabled() : not(isEnabled())));
  }

  public void botón_CLICKS_se_encuentra(boolean activado) {
//    CounterActivity activity = counterTestCtrl.get();
//    Button btn = activity.findViewById(R.id.btnClicks);
//    assertThat(btn.isEnabled(), equalTo(activado));

    onView(withId(R.id.btnClicks))
        .check(matches(isDisplayed()))
        .check(matches(activado ? isEnabled() : not(isEnabled())));
  }

  public void botón_CLEAR_se_encuentra(boolean activado) {
//    ClicksActivity activity = clicksTestCtrl.get();
//    Button btn = activity.findViewById(R.id.btnClear);
//    assertThat(btn.isEnabled(), equalTo(activado));

    onView(withId(R.id.btnClear))
        .check(matches(isDisplayed()))
        .check(matches(activado ? isEnabled() : not(isEnabled())));
  }

  public void hacemos_clic_en_botón_INCREMENT() {
//    CounterActivity activity = counterTestCtrl.get();
//    Button btn = activity.findViewById(R.id.btnIncrement);
//    btn.performClick();

    onView(withId(R.id.btnIncrement)).perform(click());
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

    onView(withId(R.id.btnClear)).perform(click());
  }


  public void hacemos_clic_en_botón_RESET() {
//    CounterActivity activity = counterTestCtrl.get();
//    Button btn = activity.findViewById(R.id.btnReset);
//    btn.performClick();

    onView(withId(R.id.btnReset)).perform(click());
  }


  public void rotamos_pantalla_COUNTER() {
    Context context = ApplicationProvider.getApplicationContext();
    int orientation = context.getResources().getConfiguration().orientation;
    Activity activity = counterTestRule.getActivity();

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

  public void rotamos_pantalla_CLICKS() {
    /*
    Context context = ApplicationProvider.getApplicationContext();
    int orientation = context.getResources().getConfiguration().orientation;
    Activity activity = clicksTestRule.getActivity();

    if(orientation  == Configuration.ORIENTATION_PORTRAIT) {
      activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    } else {
      activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    try {
      Thread.sleep(700);
    } catch (InterruptedException e) {

    }
    */
  }
}
