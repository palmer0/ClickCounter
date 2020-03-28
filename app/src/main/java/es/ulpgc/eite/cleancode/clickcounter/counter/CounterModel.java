package es.ulpgc.eite.cleancode.clickcounter.counter;

public class CounterModel implements CounterContract.Model {

  public static String TAG = CounterModel.class.getSimpleName();

  private Integer value;

  public CounterModel(Integer counter) {
    value = counter;
  }

  @Override
  public Integer getStoredValue() {
    // Log.e(TAG, "getStoredValue()");
    return value;
  }

  @Override
  public void onRestartScreen(Integer data) {
    // Log.e(TAG, "onRestartScreen()");
  }

  @Override
  public void onDataFromNextScreen(Integer data) {
    // Log.e(TAG, "onDataFromNextScreen()");
  }

  @Override
  public void onDataFromPreviousScreen(Integer data) {
    // Log.e(TAG, "onDataFromPreviousScreen()");
  }

  @Override
  public void onIncrementValue() {
    value++;
  }
}
