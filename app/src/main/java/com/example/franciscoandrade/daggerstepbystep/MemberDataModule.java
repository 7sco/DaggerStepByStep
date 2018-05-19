package com.example.franciscoandrade.daggerstepbystep;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Everytime we create a new module, to indicate that to dagger we should include @Module annotation
 */
@Module
public class MemberDataModule {
    /**
     * We need to provide member data manager object, therefore the name of hte method is provideMemberDataManager
     *
     * We use @Provide annotation to tell dagger this method is a dependency provider
     * If we are going to create this object once we can create Singleton Annotation
     */

    @Singleton
    @Provides
    MemberDataManager provideMemberDataManager(){
        return new MemberDataManager();
    }


    //In this application we are only going to have on e method here, in a real world app, there can be more than one methods, and modules

}
