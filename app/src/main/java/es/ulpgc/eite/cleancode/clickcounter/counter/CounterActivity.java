package es.ulpgc.eite.cleancode.clickcounter.counter;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import es.ulpgc.eite.cleancode.clickcounter.R;

public class CounterActivity
    extends AppCompatActivity implements CounterContract.View {

  public static String TAG = CounterActivity.class.getSimpleName();

  private CounterContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_counter);
    getSupportActionBar().setTitle(R.string.counter_title);

    // do the setup
    CounterScreen.configure(this);

    if (savedInstanceState == null) {
      presenter.onStart();

    } else {
      presenter.onRestart();
    }
  }

  @Override
  protected void onResume() {
    super.onResume();

    // load the counterVal
    presenter.onResume();
  }


  @Override
  public void onBackPressed() {
    super.onBackPressed();

    presenter.onBackPressed();
  }

  @Override
  protected void onPause() {
    super.onPause();

    presenter.onPause();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();

    presenter.onDestroy();
  }

  @Override
  public void onDataUpdated(CounterViewModel viewModel) {
    //Log.e(TAG, "onDataUpdated()");

    // deal with the data
    String counterVal= String.valueOf(viewModel.counterVal);
    ((TextView) findViewById(R.id.tvCounter)).setText(counterVal);

    findViewById(R.id.btnClicks).setEnabled(viewModel.isClicksEnabled);
    findViewById(R.id.btnIncrement).setEnabled(viewModel.isIncrEnabled);
    findViewById(R.id.btnReset).setEnabled(viewModel.isResetEnabled);
  }


  public void onBtnIncrementClicked(View view) {
    presenter.onBtnIncrementClicked();
  }

  public void onBtnResetClicked(View view) {
    presenter.onBtnResetClicked();
  }

  public void onBtnClicksClicked(View view) {
    presenter.onBtnClicksClicked();
  }

  @Override
  public void injectPresenter(CounterContract.Presenter presenter) {
    this.presenter = presenter;
  }

}
