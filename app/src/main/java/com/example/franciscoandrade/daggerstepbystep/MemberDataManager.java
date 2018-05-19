package com.example.franciscoandrade.daggerstepbystep;

import java.util.ArrayList;

public class MemberDataManager {

    private String memberStatus;
    private ArrayList<Member> members = new ArrayList<>();

    public MemberDataManager() {
        populateData();
    }

    /*
        This methods receives a string input, and decides if user exist in the DB
     */

    public String checkMemberStatus(String userInput) {

        memberStatus = "Access Denied";
        for (Member m : members) {
            if ((m.getMemberId().equals(userInput))) {
                memberStatus = "Access Granted";
            }

        }
        return memberStatus;
    }


    private void populateData() {
        /*
            Here we can have code that connects with a rest api or grab data from DB
         */


        members.add(new Member("123", "Tom", "tom@gmail.com"));
        members.add(new Member("127", "Sam", "sam@gmail.com"));
        members.add(new Member("670", "Jack", "jack@gmail.com"));
        members.add(new Member("230", "Frank", "frank@gmail.com"));
        members.add(new Member("118", "Mary", "mary@gmail.com"));
        members.add(new Member("602", "Sara", "sara@gmail.com"));
    }


}
