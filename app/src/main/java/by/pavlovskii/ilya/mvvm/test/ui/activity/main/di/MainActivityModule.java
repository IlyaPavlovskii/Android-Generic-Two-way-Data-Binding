package by.pavlovskii.ilya.mvvm.test.ui.activity.main.di;

import android.support.annotation.NonNull;

import javax.inject.Provider;

import by.mvvmwrapper.dagger.qualifier.TopLevelDependency;
import by.mvvmwrapper.dagger.scope.ActivityScope;
import by.mvvmwrapper.dagger.utils.ViewModelDiUtils;
import by.pavlovskii.ilya.mvvm.test.navigator.MainNavigator;
import by.pavlovskii.ilya.mvvm.test.ui.activity.main.MainActivity;
import by.pavlovskii.ilya.mvvm.test.ui.activity.main.MainViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Navigator;

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

    @Provides
    @ActivityScope
    @TopLevelDependency
    static MainViewModel provideViewModel(@NonNull MainActivity activity,
                                          @NonNull Provider<MainViewModel> viewModelProvider) {
        return ViewModelDiUtils.provideViewModel(activity, MainViewModel.class, viewModelProvider);
    }
}
