package by.pavlovskii.ilya.mvvm.test.ui.activity.main.di;

import android.support.annotation.NonNull;

import javax.inject.Provider;

import by.mvvmwrapper.dagger.map.ViewModelKey;
import by.mvvmwrapper.dagger.qualifier.TopLevelDependency;
import by.mvvmwrapper.dagger.scope.ActivityScope;
import by.mvvmwrapper.dagger.utils.ViewModelDiUtils;
import by.mvvmwrapper.viewmodel.BaseViewModel;
import by.pavlovskii.ilya.mvvm.test.navigator.MainNavigator;
import by.pavlovskii.ilya.mvvm.test.ui.activity.main.MainActivity;
import by.pavlovskii.ilya.mvvm.test.ui.activity.main.MainViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import ru.terrakok.cicerone.Navigator;
import timber.log.Timber;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 08.12.2017<br>
 * Time: 16:18<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
@Module
public abstract class MainActivityModule {

    @Binds
    @ActivityScope
    abstract Navigator navigator(MainNavigator navigator);

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    abstract BaseViewModel bindMainViewModel(@NonNull MainViewModel viewModel);


    @Provides
    @ActivityScope
    @TopLevelDependency
    static MainViewModel provideViewModel(@NonNull MainActivity activity,
                                          @NonNull Provider<MainViewModel> viewModelProvider) {
        Timber.d("provideViewModel");
        return ViewModelDiUtils.provideViewModel(activity, MainViewModel.class, viewModelProvider);
    }
}
