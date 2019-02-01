package com.shreejipedhadiya;

import java.util.List ;

public interface AgentDAO {

    final String DRIVER = "com.mysql.jdbc.Driver";
    final String URL = "jdbc:mysql://localhost:3306/javajdbc";
    final String DB_USER = "root";
    final String DB_PASSWORD = "";

    public boolean createAgent(Agent agent);
    public boolean deleteAgent(String agent_code);
    public int updateAgent(String agent_code, String workingarea);
    public List<Agent> getAllAgents();
    public Agent getAgentByCode(String agent_code);

}
