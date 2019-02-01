package com.shreejipedhadiya;

import java.sql.* ;
import java.util.* ;

public class AgentOperations implements AgentDAO{
    private Connection connection;
    private Statement stmt;
    private ResultSet resultSet;
    private String query;

    public AgentOperations() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        connection = DriverManager.getConnection(URL, DB_USER, DB_PASSWORD);
        stmt = connection.createStatement();
    }

    protected void finalize(){
        try{
            stmt.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean createAgent( Agent agent ) {
        String agentCode = agent.getAgentCode();
        String agentName = agent.getAgentName();
        String workingArea = agent.getWorkingArea();
        Float commission = agent.getCommission();
        String phoneNo = agent.getPhoneNo();
        String country = agent.getCountry();

        query = "INSERT INTO AGENTS VALUES( '"+agentCode+"','"+agentName+"','"+workingArea+"','"+commission+"','"+phoneNo+"','"+country+"' )" ;

        try {
            stmt.execute(query);

            System.out.println( "Agent Created !" );
            return true;

        } catch( SQLException e ) {

            e.printStackTrace();
            return false ;

        }
    }

    @Override
    public boolean deleteAgent(String agent_code){

        query = "DELETE FROM AGENTS WHERE AGENT_CODE = '"+agent_code+"'" ;

        try {

            stmt.execute(query);

            System.out.println("Agent Deleted !");

            return true ;

        } catch ( SQLException e ) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int updateAgent(String agent_code, String workingarea){

        int count ;
        query = "UPDATE AGENTS SET WORKING_AREA = '"+workingarea+"' WHERE AGENT_CODE='"+agent_code+"'";

        try {

            count = stmt.executeUpdate(query);

            System.out.println("Agent Updated !");

            return count ;

        } catch ( SQLException e ) {
            e.printStackTrace();
            return -1 ;
        }

    }

    @Override
    public List<Agent> getAllAgents(){

        List<Agent> agentList = new ArrayList<Agent>();

        query = "SELECT * FROM AGENTS" ;

        try {

            resultSet = stmt.executeQuery(query);

            while (resultSet.next()) {
                Agent a = new Agent(
                        resultSet.getString("AGENT_CODE" ),
                        resultSet.getString("AGENT_NAME" ),
                        resultSet.getString("WORKING_AREA" ),
                        resultSet.getFloat("COMMISSION" ),
                        resultSet.getString("PHONE_NO" ),
                        resultSet.getString("COUNTRY")
                );

                agentList.add( a ) ;
            }

            return agentList ;

        } catch ( SQLException e ) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Agent getAgentByCode(String agent_code) {

        query = "SELECT * FROM AGENTS WHERE AGENT_CODE = '"+agent_code+"'";

        try {

            resultSet = stmt.executeQuery(query);

            if (resultSet.next()) {

                return new Agent(
                        resultSet.getString("AGENT_CODE"),
                        resultSet.getString("AGENT_NAME"),
                        resultSet.getString("WORKING_AREA"),
                        resultSet.getFloat("COMMISSION"),
                        resultSet.getString("PHONE_NO"),
                        resultSet.getString("COUNTRY")
                );
            } else {
                return null ;
            }

        } catch ( SQLException e ) {
            e.printStackTrace();
            return new Agent( "", "", "", Float.parseFloat("0.0"), "", "");
        }
    }

}
