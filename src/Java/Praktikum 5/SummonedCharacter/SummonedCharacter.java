import java.util.List;
import java.util.ArrayList;

public class SummonedCharacter implements ISummoned {
    private Character character;
    private int level;
    private int exp;
    private List<Spell> spell;

    public SummonedCharacter(Character character, int level, int exp) {
        this.character = character;
        this.level = level;
        this.exp = exp;
        this.spell = new ArrayList<Spell>();
    }

    // getter
    public int getLevel() {
        return this.level;
    }

    public int getExp() {
        return this.exp;
    }

    // menambahkan spell ke dalam daftar spell aktif
    public void addSpell(Spell s) {
        this.spell.add(s);
    }

    // mengembalikan daftar spell aktif
    public List<Spell> getActiveSpells() {
        return this.spell;
    }

    // meningkatkan level karakter sebanyak 1
    // mereset xp ke 0
    // meningkatkan baseAtk dan baseHp sebanyak attackUp dan healthUp
    public void levelUp() {
        this.level += 1;
        this.exp = 0;
        String name = this.character.getName();
        int baseAtk = this.character.getAttackValue();
        int baseHp = this.character.getHpValue();
        int atkUp = this.character.getAttackUpValue();
        int hpUp = this.character.getHealthUpValue();
        Character updateCharacter = new Character(name, baseAtk + atkUp, baseHp + hpUp, atkUp, hpUp);
        this.character = updateCharacter;
    }

    // menggambar kartu ke layar
    public void render() {
        System.out.println("Nama: " + this.character.getName());
        System.out.println("Level: " + this.getLevel());
        System.out.println("Exp: " + this.getExp());
        System.out.println("Atk: " + this.character.getAttackValue());
        System.out.println("Hp: " + this.character.getHpValue());
        System.out.println("Memiliki " + this.spell.size() + " spell aktif:");
        for (int i = 0; i < this.spell.size(); i++) {
            System.out.println("- " + this.spell.get(i).getName());
        }
        System.out.println();
    }
}

/*
Memiliki konstruktor yang menerima argumen berturut-turut:
    Sebuah objek karakter yang disummon
    integer yang merupakan level dari karakter saat ini
    integer yang merupakan exp dari karakter saat ini
Mencatat level dan exp karakter di arena sekarang
Meningkatkan level
Mencatat spell yang sedang aktif
Menambahkan spell ke karakter
Mengimplemen interface ISummoned
Method render akan menuliskan pesan ke layar, diikuti baris baru. */