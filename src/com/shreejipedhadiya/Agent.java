package com.shreejipedhadiya;

class InvalidArgument extends Exception{
    InvalidArgument(String s){
        super(s);
    }
}

public class Agent {

    String agentCode ;
    String agentName ;
    String workingArea ;
    Float commission ;
    String phoneNo ;
    String country ;

    Agent( String agentCode, String agentName, String workingArea, Float commission, String phoneNo, String country ){
        this.agentCode = agentCode ;
        this.agentName = agentName ;
        this.workingArea = workingArea ;
        this.commission = commission ;
        this.phoneNo = phoneNo ;
        this.country = country ;
    }

    void showData(){
        System.out.println( agentCode + " " + agentName + " " + workingArea + " " + commission + " " + phoneNo + " " + country );
    }

    void updateData( String type , String value ) throws InvalidArgument {

        if( type.equals("agentcode") ) {
            this.agentCode = value ;
        } else if( type.equals("agentname") ) {
            this.agentName = value ;
        } else if( type.equals("workingarea") ) {
            this.workingArea = value ;
        } else if( type.equals("phoneno") ) {
            this.phoneNo = value ;
        } else if( type.equals("country") ) {
            this.country = value ;
        } else {
            throw new InvalidArgument("Pass Valid Arguments" );
        }

    }

    String getAgentCode(){
        return agentCode ;
    }

    String getAgentName(){
        return agentName ;
    }

    String getWorkingArea(){
        return workingArea ;
    }

    Float getCommission(){
        return commission ;
    }

    String getPhoneNo(){
        return phoneNo ;
    }

    String getCountry(){
        return country ;
    }

}
