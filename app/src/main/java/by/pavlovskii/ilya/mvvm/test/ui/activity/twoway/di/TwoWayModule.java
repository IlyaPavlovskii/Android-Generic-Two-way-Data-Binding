package by.pavlovskii.ilya.mvvm.test.ui.activity.twoway.di;

import android.support.annotation.NonNull;

import javax.inject.Provider;

import by.mvvmwrapper.dagger.qualifier.TopLevelDependency;
import by.mvvmwrapper.dagger.scope.ActivityScope;
import by.mvvmwrapper.dagger.utils.ViewModelDiUtils;
import by.pavlovskii.ilya.mvvm.test.ui.activity.twoway.TwoWayActivity;
import by.pavlovskii.ilya.mvvm.test.ui.activity.twoway.TwoWayViewModel;
import dagger.Module;
import dagger.Provides;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 12.05.2018<br>
 * Time: 18:01<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
@Module
public abstract class TwoWayModule {

    @Provides
    @ActivityScope
    @TopLevelDependency
    static TwoWayViewModel provideViewModel(@NonNull TwoWayActivity activity,
                                            @NonNull Provider<TwoWayViewModel> viewModelProvider) {
        return ViewModelDiUtils.provideViewModel(activity, TwoWayViewModel.class, viewModelProvider);
    }
}
