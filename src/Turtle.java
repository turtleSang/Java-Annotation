@SimpleAnnotation
public class Turtle {
    @FieldAnnotation(table = "name")
    private String name;

    public Turtle() {
    }

    public Turtle(String name) {
        this.name = name;
    }

    @SimpleAnnotation
    @MethodAnnotation(times = 3)
    public void eat(String food){
        System.out.println("turtle eat " + food);
    }

//    @MethodAnnotation(times = 3)
    public void swimming(String w){
        System.out.println("turtle can swimming");
        System.out.println(w);
    }
}
