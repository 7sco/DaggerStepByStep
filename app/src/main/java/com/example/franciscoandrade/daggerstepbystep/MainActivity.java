package com.example.franciscoandrade.daggerstepbystep;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    /**
     * This branch will create:
     * Module: MemberDataModule
     * Interface: MemberAppComponent
     * Main activity can inject member data manager dependency which is provided by member data mosule,
     * through MemberAppComponent interface
     *
     * App: Class acts like an aoutsider, takes responsability to construct all the modules at the beginig,
     * so relevent onjects can be injected at any time
     *
     * MemberAppComponent:is the main interface from which activities and fragments gets the objects, or dependencies,
     * those dependencies are provided by the modules using aplication interface
     *
     *BEHAVIOR of APP:
     * Main activity, wich is the main view class gets member data manager dependency, provided by member data module,
     * via member app component interface
     */

    /**
     * We use inject annotation to inject dependency we want
     */
    @Inject
    MemberDataManager memberDataManager;

    private EditText memberId;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        memberId = findViewById(R.id.etMemberId);
        submitButton = findViewById(R.id.btnSubmit);
        /**
         * To call method get , we create instance of class
         */
        App.getApp().getMemberAppComponent().inject(this);
        //=======
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((memberId.getText().toString().equals(""))) {
                    Toast.makeText(getApplicationContext(), "Member ID is empty", Toast.LENGTH_SHORT).show();
                } else {

                    String input = memberId.getText().toString();

                    /**
                     * Rather than creating a new member data manager object here we can call injected MeberDataManager
                     *  //String result = new MemberDataManager().checkMemberStatus(input);
                     *  We can use the object again and again because it is a singleton
                     */
                    String result = memberDataManager.checkMemberStatus(input);
                    //=====
                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
    /**
     * 1.Add Dependencies
     * 2.Create 3 files:
     *      -App.class: Takes responsibility to create the module at the start time, and create dependencies ready made
     *      -MemberDataModule.class: Use singleton and provides annotations, provide dependencies from the module
     *      -(Interface)MamberAppComponent.class: Define where we are going to inject the dependencies
     *      -MainActivity.class:  we use inject annotation to get the dependency from the interface
     */
}


