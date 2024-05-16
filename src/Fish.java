public class Fish {
    private String name;

    public Fish() {
    }

    public Fish(String name) {
        this.name = name;
    }

    public void eat(String food){
        System.out.println("Fish eat " + food);
    }
}
