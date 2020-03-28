package es.ulpgc.eite.cleancode.clickcounter.clicks;

import es.ulpgc.eite.cleancode.clickcounter.app.AppMediator;

public class ClicksRouter implements ClicksContract.Router {

  public static String TAG = ClicksRouter.class.getSimpleName();

  private AppMediator mediator;

  public ClicksRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  /*
  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, ClicksActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passStateToNextScreen(ClicksState state) {
    mediator.setClicksNextScreenState(state);
  }

  @Override
  public ClicksState getStateFromNextScreen() {
    return mediator.getClicksNextScreenState();
  }
  */

  @Override
  public ClicksState getStateFromPreviousScreen() {
    return mediator.getClicksPreviousScreenState();
  }

}
