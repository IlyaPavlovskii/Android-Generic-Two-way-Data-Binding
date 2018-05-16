package by.pavlovskii.ilya.mvvm.test.ui.fragments.timer.di;

import android.support.annotation.NonNull;

import javax.inject.Named;
import javax.inject.Provider;

import by.mvvmwrapper.dagger.qualifier.TopLevelDependency;
import by.mvvmwrapper.dagger.scope.FragmentScope;
import by.mvvmwrapper.dagger.utils.ViewModelDiUtils;
import by.pavlovskii.ilya.mvvm.test.storage.Constants;
import by.pavlovskii.ilya.mvvm.test.ui.fragments.timer.TimerFragment;
import by.pavlovskii.ilya.mvvm.test.ui.fragments.timer.TimerViewModel;
import dagger.Module;
import dagger.Provides;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 08.12.2017<br>
 * Time: 17:10<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
@Module
public abstract class TimerViewModelModule {

    @Provides
    @Named(Constants.Dagger.TAG)
    static String provideTag(@NonNull TimerFragment fragment) {
        return fragment.getTag();
    }

    @Provides
    @FragmentScope
    @TopLevelDependency
    static TimerViewModel provideViewModel(@NonNull TimerFragment fragment,
                                           @NonNull Provider<TimerViewModel> viewModelProvider) {
        return ViewModelDiUtils.provideViewModel(fragment, TimerViewModel.class, viewModelProvider);
    }

}
