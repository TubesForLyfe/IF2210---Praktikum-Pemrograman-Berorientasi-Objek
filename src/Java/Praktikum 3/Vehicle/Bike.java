class Bike extends NonMotorizedVehicle implements Rideable {
    Bike() {
        this.name = "Bike";
    }

    Bike(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    public void ride() {
        System.out.println("Riding a " + getName());
    }
}