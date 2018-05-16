package by.pavlovskii.ilya.mvvm.test.ui.activity.launch.di;

import android.support.annotation.NonNull;

import javax.inject.Provider;

import by.mvvmwrapper.dagger.qualifier.TopLevelDependency;
import by.mvvmwrapper.dagger.scope.ActivityScope;
import by.mvvmwrapper.dagger.utils.ViewModelDiUtils;
import by.pavlovskii.ilya.mvvm.test.ui.activity.launch.LaunchActivity;
import by.pavlovskii.ilya.mvvm.test.ui.activity.launch.LaunchViewModel;
import by.pavlovskii.ilya.mvvm.test.ui.activity.launch.impl.SampleItemFactoryImpl;
import by.pavlovskii.ilya.mvvm.test.utils.factory.SampleItemFactory;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 09.05.2018<br>
 * Time: 1:05<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
@Module
public abstract class LaunchModule {

    @Binds
    abstract SampleItemFactory bindSampleItemFactory(@NonNull SampleItemFactoryImpl impl);

    @Provides
    @ActivityScope
    @TopLevelDependency
    static LaunchViewModel provideViewModel(@NonNull LaunchActivity activity,
                                            @NonNull Provider<LaunchViewModel> viewModelProvider) {
        return ViewModelDiUtils.provideViewModel(activity, LaunchViewModel.class, viewModelProvider);
    }
}
