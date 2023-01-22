package com.company.inheritance;

public class App {

    public static void main(String[] args) {
        Developer developer = new Developer();
        TeamLead teamLead = new TeamLead();
        Architect architect = new Architect();

        developer.checkInCode();
        teamLead.planSprint();
        architect.assignWork(developer);
    }
}
