package com.example.mobileappdevelop.testmessmanagement;

import java.util.ArrayList;

/**
 * Created by AL ASIF on 7/20/2016.
 */
public class Member {

    String memberName;

    public Member(String memberName) {
        this.memberName = memberName;
    }

    public Member() {
    }

    public String getMemberName() {
        return memberName;
    }

    public ArrayList<Member> allMember(){
        ArrayList<Member> members = new ArrayList<>();
        members.add(new Member("Khalid"));
        members.add(new Member("Asif"));
        members.add(new Member("Antor"));
        members.add(new Member("Sadi"));
        members.add(new Member("Hasan"));
        return members;
    }
}
