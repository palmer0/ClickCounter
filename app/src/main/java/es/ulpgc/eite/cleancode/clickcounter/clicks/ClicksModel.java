package es.ulpgc.eite.cleancode.clickcounter.clicks;

public class ClicksModel implements ClicksContract.Model {

  public static String TAG = ClicksModel.class.getSimpleName();

  private Integer numOfClicks;

  public ClicksModel() {
    numOfClicks=0;
  }

  @Override
  public Integer getStoredClicks() {
    // Log.e(TAG, "getStoredCounter()");
    return numOfClicks;
  }

  @Override
  public void onRestartScreen(Integer number) {
    // Log.e(TAG, "onRestartScreen()");
    numOfClicks=number;
  }

  @Override
  public void onDataFromPreviousScreen(Integer number) {
    // Log.e(TAG, "onDataFromPreviousScreen()");
    numOfClicks=number;
  }

  @Override
  public void onClearClicks() {
    numOfClicks=0;
  }
}
