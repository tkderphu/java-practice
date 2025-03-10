package code_ptit.practice.competition;

public class Team implements Comparable<Team>{
    private Institution institution;
    private String name;

    public Team(Institution institution, String name) {
        this.institution = institution;
        this.name = name;
    }


    @Override
    public int compareTo(Team o) {
        if(o.institution.getName().compareTo(institution.getName()) == 0) {
            return name.compareTo(o.name);
        }
        return institution.getName().compareTo(o.institution.getName());
    }

    @Override
    public String toString() {
        return name + " " + institution.getName();
    }
}

