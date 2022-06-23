public class Main {
    public static void main(String[] args) {
        int i;

        // Section 1
        System.out.println("--- Section 1 ---");
        GhostPokemon g1 = new GhostPokemon();
        FightingPokemon f1 = new FightingPokemon();
        NormalPokemon n1 = new NormalPokemon();
        Pokemon p1 = new Pokemon();
        System.out.println(g1.getName());
        System.out.println(f1.getName());
        System.out.println(n1.getName());
        System.out.println(p1.getName());
        GhostPokemon g2 = new GhostPokemon("Gastly");
        FightingPokemon f2 = new FightingPokemon("Machop");
        NormalPokemon n2 = new NormalPokemon("Rattata");
        Pokemon p2 = new Pokemon("Big Boss");
        System.out.println(g2.getName());
        System.out.println(f2.getName());
        System.out.println(n2.getName());
        System.out.println(p2.getName());
        g2.displayClass();
        f2.displayClass();
        n2.displayClass();
        p2.displayClass();
        g2.setUniqueID("G1");
        System.out.println(g2.getUniqueID());
        f2.setUniqueID(12);
        System.out.println(f2.getUniqueID());

        // Section 2
        System.out.println("--- Section 2 ---");
        g2.checkElement();
        f2.checkElement();
        n2.checkElement();
        g2.specialSkill();
        f2.displayAura();
        g2.displayAura();
        f2.specialSkill();

        // Section 3
        System.out.println("--- Section 3 ---");
        PokemonAction<GhostPokemon> gp = new PokemonAction<>(g2);
        PokemonAction<NormalPokemon> np = new PokemonAction<>(n2);
        gp.displayPokemonClass();
        np.displayPokemonClass();
        System.out.println(g2.getName() + " vs " + n2.getName());
        for (i = 0; i < 7; i++) {
            gp.attack();
            np.defense();
        }
        for (i = 0; i < 3; i++) {
            np.attack();
            gp.defense();
        }
        np.useSkill();
        gp.useSkill();
        np.run();

        // Section 4
        System.out.println("--- Section 4 ---");
        System.out.println("New Battle Found");
        PokemonAction<FightingPokemon> fp = new PokemonAction<>(f2);
        PokemonAction<Pokemon> pp = new PokemonAction<>(p2);
        fp.displayPokemonClass();
        pp.displayPokemonClass();
        System.out.println(p2.getName() + " vs " + f2.getName());
        for (i = 0; i < 4; i++) {
            fp.attack();
            pp.defense();
        }
        for (i = 0; i < 8; i++) {
            pp.attack();
            fp.defense();
        }
        fp.useSkill();
        pp.useSkill();
        fp.run();
        System.out.println("All Battle Finished");
    }
}
