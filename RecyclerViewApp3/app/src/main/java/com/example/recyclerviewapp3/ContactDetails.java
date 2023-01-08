package com.example.recyclerviewapp3;

public class ContactDetails {
    String name , number;
    String profile;
    public ContactDetails(String name , String contact){
        this.name = capitalise(name);
        this.number = contact;
        profile = String.valueOf(name.charAt(0)).toUpperCase();
    }

    private static String capitalise(String s){
        StringBuilder sb=new StringBuilder();
        Boolean wasSpace = true;

        for(int i =0;i<s.length();i++){
            if(s.charAt(i) == ' '){
                wasSpace = true;
                while (i<s.length() && s.charAt(i)==' '){
                    i++;
                    continue;
                }
            }
            if(i>=s.length()){
                break;
            }
            if(wasSpace){
                if(i!=0){
                    sb.append(" ");
                }
                sb.append(Character.toUpperCase(s.charAt(i)));
                wasSpace = false;
            }
            else {
                sb.append(s.charAt(i));
            }
        }
        if(sb.toString().length()>15){
            return sb.toString().substring(0,16);
        }
        return sb.toString();
    }
}
