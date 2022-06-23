public class Human extends Animal {
    Human() {
        super(2);
    }

    public void eat(String food) {
        if (!food.equals("teman")) {
            this.hungry = false;
        }
    }

    public void run() {
        System.out.println("Human is running");
    }
}
