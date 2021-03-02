package Domain;

public class Horse {

    HorseType horseType;
    boolean is_driving = false;
    Shipment shipment;
    boolean is_loaded = false;


    public Horse(HorseType horseType){
        this.horseType = horseType;
    }

    public void drive(){
        String str = "";
        if(this.is_loaded){
            str = " лошадь везет " + shipment.name;
        } else{
            str = " лошадь едет";
        }
        is_driving = true;
        System.out.println(check_horse_type() + str);
    }

    public String check_horse_type(){
        return switch (horseType){
            case WILD -> "Дикая";
            case DOMESTIC -> "Домашняя";
        };
    }

    public void load_horse(Shipment shipment){
        this.shipment = shipment;
        this.is_loaded = true;
    }


}
