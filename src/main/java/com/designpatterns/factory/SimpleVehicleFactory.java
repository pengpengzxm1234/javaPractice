package com.designpatterns.factory;

import java.lang.annotation.Target;

/**
 * 简单工厂
 * 扩展性不好
 */
public class SimpleVehicleFactory {

    public static class TravelFactory{
        public static Transportation createTransportation(String type){
            if(type.equals("买菜")){
                return new Bicycle();
            }else if(type.equals("上班")){
                return new Car();
            }else if (type.equals("穿越")){
                return new Track();
            }

            return new Transportation();
        }
    }

    public static class Transportation{
        public void run(){
            System.out.println("run");
        }
    }

    /**
     * 自行车
     */
    public static class Bicycle extends Transportation{
        @Override
        public void run() {
            System.out.println("Bicycle run");
        }
    }


    /**
     * 汽车
     */
    public static class Car extends Transportation{
        @Override
        public void run() {
            System.out.println("Car run");
        }
    }

    /**
     * 卡车
     */
    public static class Track extends Transportation{
        @Override
        public void run() {
            System.out.println("Track run");
        }
    }

    public static class Travel{
        static Transportation transportation;
        Travel(String type){
            if(type.equals("买菜")){
                transportation = new Bicycle();
            }else if(type.equals("上班")){
                transportation = new Car();
            }else if (type.equals("穿越")){
                transportation = new Track();
            }else {
                transportation = new Transportation();
            }
        }

        public void run(){
            transportation.run();
        }
    }

    public static void main(String[] args) {
        Transportation transportation = TravelFactory.createTransportation("买菜");
        transportation.run();
        transportation = TravelFactory.createTransportation("上班");
        transportation.run();

        Travel travel = new Travel("穿越");
        travel.run();
    }

}
