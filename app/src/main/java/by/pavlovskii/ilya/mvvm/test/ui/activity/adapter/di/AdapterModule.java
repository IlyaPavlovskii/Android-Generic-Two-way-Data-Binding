package by.pavlovskii.ilya.mvvm.test.ui.activity.adapter.di;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import javax.inject.Provider;

import by.mvvmwrapper.dagger.qualifier.TopLevelDependency;
import by.mvvmwrapper.dagger.scope.ActivityScope;
import by.mvvmwrapper.dagger.utils.ViewModelDiUtils;
import by.pavlovskii.ilya.mvvm.test.ui.activity.adapter.AdapterActivity;
import by.pavlovskii.ilya.mvvm.test.ui.activity.adapter.AdapterViewModel;
import by.pavlovskii.ilya.mvvm.test.ui.activity.adapter.impl.ColorsFactoryImpl;
import by.pavlovskii.ilya.mvvm.test.ui.adapters.ColorAdapter;
import by.pavlovskii.ilya.mvvm.test.utils.factory.ColorsFactory;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 12.05.2018<br>
 * Time: 20:56<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
@Module
public abstract class AdapterModule {

    @Binds
    abstract RecyclerView.Adapter bindRecyclerView(@NonNull ColorAdapter adapter);

    @Binds
    abstract ColorsFactory bindColorsFactory(@NonNull ColorsFactoryImpl impl);

    @Provides
    @ActivityScope
    @TopLevelDependency
    static AdapterViewModel provideViewModel(@NonNull AdapterActivity activity,
                                             @NonNull Provider<AdapterViewModel> viewModelProvider) {
        return ViewModelDiUtils.provideViewModel(activity, AdapterViewModel.class, viewModelProvider);
    }
}
