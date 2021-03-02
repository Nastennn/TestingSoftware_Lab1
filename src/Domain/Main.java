package Domain;
/*Они сидели на мостовой и смотрели с некоторым беспокойством,
        как огромные дети тяжело прыгают по песку,
        а дикие лошади с грохотом везут по небу в Неизведанные
        Области свежие запасы армированных изгородей.*/

public class Main {
    public static void main(String[] args){
        Person p1 = new Person("Person1", 30);
        Person p2 = new Person("Person2",26);
        Person p3 = new Person("Person3",28);
        Person p4 = new Person("Child1",13);
        Person p5 = new Person("Child2",14);
        Person p6 = new Person("Child3",13);
        Horse horse = new Horse(HorseType.WILD);
        Shipment shipment = new Shipment("армированные изгороди", true);


        p1.worry();
        p2.worry();
        p3.worry();
        p1.sit();
        p1.see();
        p2.sit();
        p2.see();
        p3.sit();
        p3.see();


        p4.setSize(Size.HUGE);
        p5.setSize(Size.HUGE);
        p6.setSize(Size.HUGE);

        p4.jump();
        p5.jump();
        p6.jump();

        horse.load_horse(shipment);
        horse.drive();

    }

}
