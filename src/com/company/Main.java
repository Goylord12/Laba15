package com.company;



// Задание \0
//Создать перечисление, содержащее размеры одежды (XXS, XS, S, M, L). Перечисление содержит метод getDescription, возвращающий строку "Взрослый размер".
// Переопределить метод getDescription - для константы XXS метод должен возвращать строку “Детский размер”.
// Также перечисление должно содержать числовое значение euroSize(32, 34, 36, 38, 40), соответствующее каждому размеру.
// Создать конструктор, принимающий на вход euroSize.
//• Создать интерфейсы "Мужская Одежда" с методом "одетьМужчину" и "Женская Одежда" с методом "одетьЖенщину".
//• Создать абстрактный класс Одежда, содержащий переменные - размер одежды, стоимость, цвет.
//• Создать классы наследники Одежды - Футболка (реализует интерфейсы "Мужская Одежда" и "Женская Одежда"), Штаны (реализует интерфейсы "Мужская Одежда" и "Женская Одежда"),
// Юбка (реализует интерфейсы "Женская Одежда"), Галстук (реализует интерфейсы "Мужская Одежда").
//• Создать массив, содержащий все типы одежды. Создать класс Ателье, содержащий методы одетьЖенщину,
// одетьМужчину, на вход которых будет поступать массив, содержащий все типы одежды. Метод одетьЖенщину выводит на консоль всю информацию о женской одежде.
// То же самое для метода одетьМужчину

public class Main {

    public static void main(String[] args) {
        tShirt ts = new tShirt(Size.S, 453.3, "Синий");
        Skirt sk = new Skirt(Size.XS, 964.2, "Желтый");
        Tie tie = new Tie(Size.S, 143.2, "Розовый");
        Pants pants = new Pants(Size.XS, 1252.2, "Коричневый");
        Cloth[] list = new Cloth[] {ts, sk, tie, pants};
        Atelier.dressUpMen(list);
        System.out.println("\n \n");
        Atelier.dressUpWoman(list);
    }
}
enum Size{
    XXS(46){
        @Override
        public String GetDescription(){
            return "Детский размер";
        }
    },
    XS(32), S(34), M(36), L(40);
    int euroSize;
    Size(int euroSize){
        this.euroSize = euroSize;
    }

    public int getEuroSize() {
        return euroSize;
    }

    public String GetDescription(){
        return "Взрослый размер";
    }
}
interface ImenClothes{
    void dressUpMen();
}
interface IwomanClothes{
    void dressUpWoman();
}
abstract class Cloth{
    Size size;
    double price;
    String color;
    Cloth(Size size, double price, String color){
        this.size = size;
        this.price = price;
        this.color = color;
    }
    abstract void getInfo();
}
class tShirt extends Cloth implements ImenClothes, IwomanClothes{
    @Override
    public void dressUpMen(){
        System.out.println("Одеваем мужека");
    }
    @Override
    public void dressUpWoman() {
        System.out.println("Одеваем женщину");
    }
    tShirt(Size size, double price, String color){
        super(size,price,color);
    }

    @Override
    void getInfo(){
        System.out.println("Футболка, размер: " + size.getEuroSize() + " цена: " + price + " цвет: " + color);
    }
}
class Pants extends Cloth implements ImenClothes, IwomanClothes{
    @Override
    public void dressUpMen(){
        System.out.println("Одеваем мужека");
    }
    @Override
    public void dressUpWoman() {
        System.out.println("Одеваем женщину");
    }
    Pants(Size size, double price, String color){
        super(size,price,color);
    }

    @Override
    void getInfo(){
        System.out.println("Штаны, размер: " + size.getEuroSize() + " цена: " + price + " цвет: " + color);
    }
}
class Skirt extends Cloth implements IwomanClothes{
    @Override
    public void dressUpWoman() {
        System.out.println("Одеваем женщину");
    }
    Skirt(Size size, double price, String color){
        super(size,price,color);
    }
    @Override
    void getInfo(){
        System.out.println("Юбка, размер: " + size.getEuroSize() + " цена: " + price + " цвет: " + color);
    }
}
class Tie extends Cloth implements ImenClothes{
    @Override
    public void dressUpMen(){
        System.out.println("Одеваем мужека");
    }
    Tie(Size size, double price, String color){
        super(size,price,color);
    }
    @Override
    void getInfo(){
        System.out.println("Галстук, размер: " + size.getEuroSize() + " цена: " + price + " цвет: " + color);
    }
}
class Atelier{
    static void dressUpMen(Cloth[] list){
        for(Cloth c: list ){
            if (c instanceof ImenClothes){
                c.getInfo();
            }
        }
    }
    static void dressUpWoman(Cloth[] list){
        for(Cloth c: list ){
            if (c instanceof IwomanClothes){
                c.getInfo();
            }
        }
    }
}
