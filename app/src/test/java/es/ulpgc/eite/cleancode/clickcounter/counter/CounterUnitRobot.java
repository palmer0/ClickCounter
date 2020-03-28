package es.ulpgc.eite.cleancode.clickcounter.counter;

import android.widget.Button;
import android.widget.TextView;

import org.robolectric.Robolectric;
import org.robolectric.android.controller.ActivityController;

import es.ulpgc.eite.cleancode.clickcounter.R;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CounterUnitRobot {


  private ActivityController<CounterActivity> counterTestCtrl;

  private String screen;


  public void estamos_en_pantalla_COUNTER() {
    counterTestCtrl = Robolectric.buildActivity(CounterActivity.class);
    //Context ctx = counterTestCtrl.get();

    CounterActivity activity = counterTestCtrl.get();
    screen = activity.getClass().getSimpleName();

    counterTestCtrl.create().resume().visible();
  }

  public void texto_en_COUNTER_muestra(int valor) {
    CounterActivity activity = counterTestCtrl.get();

    TextView tv = activity.findViewById(R.id.tvCounter);
    assertThat(tv.getText().toString(), equalTo(""+valor));

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

  public void hacemos_clic_en_botón_INCREMENT() {
    CounterActivity activity = counterTestCtrl.get();

    Button btn = activity.findViewById(R.id.btnIncrement);
    btn.performClick();
    
  }

  public void seguimos_en_pantalla_COUNTER() {
    CounterActivity activity = counterTestCtrl.get();
    assertThat(activity.getClass().getSimpleName(), equalTo(screen));
  }
}
