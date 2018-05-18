package com.example.franciscoandrade.daggerstepbystep;


import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;

/**
 * We are using singleton so singleton annotation should be used
 * Define MODULES linked to the interface
 */

@Singleton
@Component(modules = MemberDataModule.class)
public interface MemberAppComponent {
    /**
     * Define where we will inject this dependencies
     * (fragments, activities)
     */

    void inject(MainActivity mainActivity);

}
