package es.ulpgc.eite.cleancode.clickcounter.clicks;

public class ClicksModel implements ClicksContract.Model {

  public static String TAG = ClicksModel.class.getSimpleName();

  private Integer numOfClicks;

  public ClicksModel() {
    numOfClicks=0;
  }

  @Override
  public Integer getStoredData() {
    // Log.e(TAG, "getStoredValue()");
    return numOfClicks;
  }

  @Override
  public void onRestartScreen(Integer number) {
    // Log.e(TAG, "onRestartScreen()");
  }

  @Override
  public void onDataFromNextScreen(Integer number) {
    // Log.e(TAG, "onDataFromNextScreen()");
  }

  @Override
  public void onDataFromPreviousScreen(Integer number) {
    // Log.e(TAG, "onDataFromPreviousScreen()");
    numOfClicks=number;
  }
}
