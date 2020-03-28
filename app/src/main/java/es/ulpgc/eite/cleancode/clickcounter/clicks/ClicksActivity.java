package es.ulpgc.eite.cleancode.clickcounter.clicks;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import es.ulpgc.eite.cleancode.clickcounter.R;

public class ClicksActivity
    extends AppCompatActivity implements ClicksContract.View {

  public static String TAG = ClicksActivity.class.getSimpleName();

  private ClicksContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_clicks);
    getSupportActionBar().setTitle(R.string.clicks_title);

    // do the setup
    ClicksScreen.configure(this);

    if (savedInstanceState == null) {
      presenter.onStart();

    } else {
      presenter.onRestart();
    }
  }

  @Override
  protected void onResume() {
    super.onResume();

    // load the counterValue
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
  public void onDataUpdated(ClicksViewModel viewModel) {
    //Log.e(TAG, "onDataUpdated()");

    // deal with the counterValue
    ((TextView) findViewById(R.id.data)).setText(viewModel.data);
  }

  @Override
  public void injectPresenter(ClicksContract.Presenter presenter) {
    this.presenter = presenter;
  }
}
