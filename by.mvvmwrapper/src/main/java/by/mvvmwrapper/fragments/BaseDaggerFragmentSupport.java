package by.mvvmwrapper.fragments;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import by.mvvmwrapper.dagger.qualifier.TopLevelDependency;
import by.mvvmwrapper.viewmodel.BaseViewModel;
import dagger.Lazy;
import dagger.android.support.AndroidSupportInjection;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 13.12.2017<br>
 * Time: 11:30<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 * {@link BaseFragmentSupport} extension with dependency injection modules<br>
 * ===================================================================================<br>
 */
public abstract class BaseDaggerFragmentSupport<M extends BaseViewModel, B extends ViewDataBinding>
        extends BaseFragmentSupport<M, B> {

    //======================================================
    //------------------------Fields------------------------
    //======================================================
    @Inject
    @TopLevelDependency
    Lazy<M> mViewModelProvider;


    //======================================================
    //-------------------Override methods-------------------
    //======================================================
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    @NonNull
    @Override
    protected M initViewModel() {
        return mViewModelProvider.get();
    }

    //======================================================
    //-------------------Protected methods------------------
    //======================================================

    //======================================================
    //-------------------Abstract methods-------------------
    //======================================================
}

