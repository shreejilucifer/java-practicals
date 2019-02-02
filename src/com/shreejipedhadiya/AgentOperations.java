package com.shreejipedhadiya;

import java.sql.* ;
import java.util.* ;

public class AgentOperations implements AgentDAO{
    private Connection connection;
    private PreparedStatement stmt;
    private ResultSet resultSet;
    private String query;

    public AgentOperations() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        connection = DriverManager.getConnection(URL, DB_USER, DB_PASSWORD);
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

        try {
            stmt = connection.prepareStatement("INSERT INTO AGENTS VALUES(?,?,?,?,?,?)" );

           stmt.setString(1, agentCode);
           stmt.setString( 2, agentName);
           stmt.setString(3, workingArea );
           stmt.setFloat(4, commission );
           stmt.setString(5, phoneNo );
           stmt.setString(6, country);

           stmt.executeUpdate();

           System.out.println( "Agent Created !" );

           return true;

        } catch( SQLException e ) {

            e.printStackTrace();
            return false ;

        }
    }

    @Override
    public boolean deleteAgent(String agent_code){

        try {
            stmt = connection.prepareStatement("DELETE FROM AGENTS WHERE AGENT_CODE = ?" );
            stmt.setString(1, agent_code);

            stmt.executeUpdate();

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

        try {

            stmt = connection.prepareStatement("UPDATE AGENTS SET WORKING_AREA = ? WHERE AGENT_CODE = ?" );
            stmt.setString(1, workingarea);
            stmt.setString(2, agent_code);

            count = stmt.executeUpdate();

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

        try {

            stmt = connection.prepareStatement("SELECT * FROM AGENTS WHERE AGENT_CODE = ?");
            stmt.setString(1, agent_code);

            resultSet = stmt.executeQuery();

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
