package com.mycompany;


import java.util.*;

class Participant {
    private String name;
    private int id;
    private int swimmingTime;
    private int cyclingTime;
    private int runningTime;

    public Participant(String name, int id, int swimmingTime, int cyclingTime, int runningTime) {
        this.name = name;
        this.id = id;
        this.swimmingTime = swimmingTime;
        this.cyclingTime = cyclingTime;
        this.runningTime = runningTime;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getTotalTime() {
        return swimmingTime + cyclingTime + runningTime;
    }

    public void displayDetails() {
        System.out.println("Name: " + name + ", ID: " + id + ", Total Time: " + getTotalTime() + " minutes");
    }
}

class EliteParticipant extends Participant {
    private String sponsorName;

    public EliteParticipant(String name, int id, int swimmingTime, int cyclingTime, int runningTime, String sponsorName) {
        super(name, id, swimmingTime, cyclingTime, runningTime);
        this.sponsorName = sponsorName;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Sponsor: " + sponsorName);
    }
}

class BeginnerParticipant extends Participant {
    public BeginnerParticipant(String name, int id, int swimmingTime, int cyclingTime, int runningTime) {
        super(name, id, swimmingTime, cyclingTime, runningTime);
    }
}

public class TriathlonResults {
    public static void main(String[] args) {
        List<Participant> participants = Arrays.asList(
            new Participant("Alice", 1, 25, 40, 20),
            new Participant("Bob", 2, 20, 35, 25),
            new EliteParticipant("Charlie", 3, 30, 50, 30, "Acme Corp"),
            new BeginnerParticipant("Diana", 4, 28, 42, 18)
        );

        participants.sort(Comparator.comparingInt(Participant::getTotalTime));

        System.out.println("Sorted Participants by Total Time:");
        for (Participant p : participants) {
            p.displayDetails();
        }

        System.out.println("\nFastest Participant:");
        Participant fastest = participants.get(0);
        fastest.displayDetails();

        System.out.println("\nSecond Fastest Participant:");
        Participant secondFastest = participants.get(1);
        secondFastest.displayDetails();
    }
}
