package com.shreejipedhadiya;

public class Main {

    public static void main(String[] args) {

        try{

            // Create New Agent

            Agent agent = new Agent(
                    "A013",
                    "Shreeji",
                    "Anand",
                    Float.parseFloat("0.15"),
                    "091-95865567",
                    "India"
            );

            AgentOperations operations= new AgentOperations() ;

            operations.createAgent( agent );

            // Update Agent workingArea

            operations.updateAgent("A013" , "Ahmedabad" );

            // Fetch All Agents

            for( int i=0 ; i<operations.getAllAgents().size(); i++ ) {
                operations.getAllAgents().get(i).showData();
            }

            // Fetch One Agent

            operations.getAgentByCode("A011" ).showData();

            // Delete Agent

            operations.deleteAgent("A013" );

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
