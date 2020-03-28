package es.ulpgc.eite.cleancode.clickcounter.counter;

import android.content.Context;
import android.content.Intent;

import es.ulpgc.eite.cleancode.clickcounter.app.AppMediator;
import es.ulpgc.eite.cleancode.clickcounter.app.CounterToClicksState;
import es.ulpgc.eite.cleancode.clickcounter.clicks.ClicksActivity;

public class CounterRouter implements CounterContract.Router {

  public static String TAG = CounterRouter.class.getSimpleName();

  private AppMediator mediator;

  public CounterRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, ClicksActivity.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }

  @Override
  public void passStateToNextScreen(CounterToClicksState state) {
    mediator.setCounterNextScreenState(state);
  }

  /*
  @Override
  public CounterState getStateFromPreviousScreen() {
    return mediator.getCounterPreviousScreenState();
  }
  */

  @Override
  public CounterState getStateFromNextScreen() {
    return mediator.getCounterNextScreenState();
  }
}
