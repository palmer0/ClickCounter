package es.ulpgc.eite.cleancode.clickcounter.counter;

import android.widget.Button;
import android.widget.TextView;

import org.robolectric.Robolectric;
import org.robolectric.android.controller.ActivityController;

import es.ulpgc.eite.cleancode.clickcounter.R;
import es.ulpgc.eite.cleancode.clickcounter.clicks.ClicksActivity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CounterUnitRobot {


  private ActivityController<CounterActivity> counterTestCtrl;
  private ActivityController<ClicksActivity> clicksTestCtrl;

  public void iniciamos_pantalla_COUNTER() {
    counterTestCtrl = Robolectric.buildActivity(CounterActivity.class);
    //Context ctx = counterTestCtrl.get();

    counterTestCtrl.create().resume().visible();
  }


  public void iniciamos_pantalla_CLICKS() {
    clicksTestCtrl = Robolectric.buildActivity(ClicksActivity.class);
    //Context ctx = clicksTestCtrl.get();

    clicksTestCtrl.create().resume().visible();
  }

  public void resumimos_pantalla_COUNTER() {
    counterTestCtrl.resume();
  }

  public void texto_en_COUNTER_muestra(int numero) {
    CounterActivity activity = counterTestCtrl.get();

    TextView tv = activity.findViewById(R.id.tvCounter);
    int valor = Integer.valueOf(tv.getText().toString());
    assertThat(valor, equalTo(numero));

  }


  public void texto_en_CLICKS_muestra(int numero) {
    ClicksActivity activity = clicksTestCtrl.get();

    TextView tv = activity.findViewById(R.id.tvClicks);
    int valor = Integer.valueOf(tv.getText().toString());
    assertThat(valor, equalTo(numero));
  }


  public void botón_INCREMENT_se_encuentra(boolean activado) {

    CounterActivity activity = counterTestCtrl.get();

    Button btn = activity.findViewById(R.id.btnIncrement);
    assertThat(btn.isEnabled(), equalTo(activado));
  }

  public void botón_RESET_se_encuentra(boolean activado) {
    CounterActivity activity = counterTestCtrl.get();

    Button btn = activity.findViewById(R.id.btnReset);
    assertThat(btn.isEnabled(), equalTo(activado));
    
  }

  public void botón_CLICKS_se_encuentra(boolean activado) {
    CounterActivity activity = counterTestCtrl.get();

    Button btn = activity.findViewById(R.id.btnClicks);
    assertThat(btn.isEnabled(), equalTo(activado));
    
  }

  public void botón_CLEAR_se_encuentra(boolean activado) {
    ClicksActivity activity = clicksTestCtrl.get();

    Button btn = activity.findViewById(R.id.btnClear);
    assertThat(btn.isEnabled(), equalTo(activado));
  }

  public void hacemos_clic_en_botón_INCREMENT() {
    CounterActivity activity = counterTestCtrl.get();

    Button btn = activity.findViewById(R.id.btnIncrement);
    btn.performClick();
  }

  public void hacemos_clic_en_botón_CLICKS() {
    CounterActivity activity = counterTestCtrl.get();

    Button btn = activity.findViewById(R.id.btnClicks);
    btn.performClick();
  }


  public void hacemos_clic_en_botón_CLEAR() {
    ClicksActivity activity = clicksTestCtrl.get();

    Button btn = activity.findViewById(R.id.btnClear);
    btn.performClick();
  }


}
