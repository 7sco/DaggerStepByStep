package com.example.franciscoandrade.daggerstepbystep;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

    private EditText memberId;
    private Button submitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        memberId = findViewById(R.id.etMemberId);
        submitButton = findViewById(R.id.btnSubmit);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((memberId.getText().toString().equals(""))) {
                    Toast.makeText(getApplicationContext(), "Member ID is empty", Toast.LENGTH_SHORT).show();
                } else {
                    /*
                        -Construct a new member Data Object
                        -Call  checkMemberStatus and pass in the user input
                        -We save String and pass in as a Toast message if the user has been granted access or denied,
                            based on list of members from MemberDataManager.class
                     */
                    String input = memberId.getText().toString();
                    String result = new MemberDataManager().checkMemberStatus(input);
                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();

                    /*
                        By using this approach we go against SOLID principle,()
                     */

                    /**
                     * Objects should not create new objects of other types by them selves
                     * They should get other objects via abstractions (using Interfaces)
                     * In real life we do not make everything by ourselves, we go to a supermarket and buy them
                     */

                    /*
                      Every time we pass in a text we create a new MemberDataManager object,
                      for task like connect with rest API, convert JSON data, and connect with local DB
                      Inefficient, inecesary use of resources
                     */

                    /**
                     * By using Dagger we can create a mechanism to create a one object of the user data manager at the begining,
                     * and inject that one object again and again to the main activity, whenever required
                     */

                }
            }
        });
    }
}
