package by.mvvmwrapper.dagger.utils;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import javax.inject.Provider;

import by.mvvmwrapper.utils.viewmodelproviders.ProviderViewModelProviderFactory;
import by.mvvmwrapper.viewmodel.BaseViewModel;

/**
 * Utility class that encapsulates retrieving {@link android.arch.lifecycle.ViewModel} instances
 * through {@link ViewModelProviders}.
 *
 * <br/><br/>
 * Created by alex.lobur on 5/16/18.
 */
public final class ViewModelDiUtils {
    private ViewModelDiUtils() {}


    @NonNull
    public static <TViewModel extends BaseViewModel> TViewModel provideViewModel(@NonNull FragmentActivity activity,
                                                                                 @NonNull Class<TViewModel> viewModelClass,
                                                                                 @NonNull Provider<TViewModel> viewModelProvider) {
        ViewModelProvider.Factory factory = createViewModelFactory(viewModelClass, viewModelProvider);
        return ViewModelProviders.of(activity, factory).get(viewModelClass);
    }

    @NonNull
    public static <TViewModel extends BaseViewModel> TViewModel provideViewModel(@NonNull Fragment fragment,
                                                                                 @NonNull Class<TViewModel> viewModelClass,
                                                                                 @NonNull Provider<TViewModel> viewModelProvider) {
        ViewModelProvider.Factory factory = createViewModelFactory(viewModelClass, viewModelProvider);
        return ViewModelProviders.of(fragment, factory).get(viewModelClass);
    }


    @NonNull
    private static <TViewModel extends BaseViewModel> ViewModelProvider.Factory createViewModelFactory(
            @NonNull Class<TViewModel> viewModelClass,
            @NonNull Provider<TViewModel> viewModelProvider) {
        return new ProviderViewModelProviderFactory<>(viewModelClass, viewModelProvider);
    }
}
