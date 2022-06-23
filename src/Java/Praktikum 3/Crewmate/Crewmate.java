class Crewmate {
    public String name;
    public boolean isDead;
    private int stabCount;
    static int id = 0;

    Crewmate() {
        id++;
        this.name = "Crewmate " + Integer.toString(id);
        this.isDead = false;
        this.stabCount = 0;
    }

    Crewmate(String name) {
        id++;
        this.name = name;
        this.isDead = false;
        this.stabCount = 0;
    }

    void stab(Crewmate victim) {
        if (this.isDead) {
            System.out.println(this.name + " is dead");
        } else {
            System.out.println(this.name + " stabs " + victim.name);
            victim.isDead = true;
            this.stabCount++;
        }
    }

    public String toString() {
        if (this.isDead) {
            return (this.name + " is dead");
        } else {
            if (this.stabCount > 0) {
                return (this.name + " is sus");
            } else {
                return (this.name + " is cool");
            }
        }
    }
}