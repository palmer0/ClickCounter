package es.ulpgc.eite.cleancode.clickcounter.counter;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.clickcounter.app.AppMediator;

public class CounterScreen {

  public static void configure(CounterContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);


    //AppMediator mediator = (AppMediator) context.get().getApplication();
    AppMediator mediator = AppMediator.getInstance();
    //CounterState state = mediator.getCounterState();

    //CounterContract.Router router = new CounterRouter(mediator);
    //CounterContract.Presenter presenter = new CounterPresenter(state);
    CounterContract.Presenter presenter = new CounterPresenter(mediator);
    CounterContract.Model model = new CounterModel();
    presenter.injectModel(model);
    //presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
