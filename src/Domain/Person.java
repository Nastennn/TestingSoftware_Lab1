package Domain;

public class Person {

    String name;
    int age;
    EmotionalStatus status;
    Size size;
    boolean is_sitting;
    boolean is_seeing;
    boolean is_jumping;
    boolean grown_up;


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        setSize(Size.MEDIUM);
        this.status = EmotionalStatus.CALM;
        this.grown_up = age > 18;
    }

    public void sit() {
        is_sitting = true;
        System.out.println(this.name + " сидит.");
    }

    public void see() {
        is_seeing = true;
        System.out.println(this.name + " смотрит " + check_status());
    }

    public void jump() {
        String d = "";
        is_jumping = true;
        if (size == Size.HUGE) {
            d = " тяжело";
        }
        System.out.println(check_size() + " " + analyze_age(age) + " прыгает" + d);
    }

    public void worry() {
        status = EmotionalStatus.WORRIED;
    }

    public void calmDown() {
        status = EmotionalStatus.CALM;
    }


    public void setSize(Size size) {
        this.size = size;
    }

    public String check_size() {
        return switch (size) {
            case HUGE -> "огромный";
            case MEDIUM -> "средний";
            case SMALL -> "малнький";
            default -> " ";
        };
    }

    public String check_status() {
        return switch (status) {
            case WORRIED -> "с беспокойством";
            case CALM -> "спокойно";
            default -> "";
        };
    }

    public String analyze_age(int age) {
        if (age < 18) {
            return "ребенок";
        } else {
            return "взрослый";
        }
    }

}
