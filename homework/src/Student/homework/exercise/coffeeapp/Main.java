package Student.homework.exercise.coffeeapp;

public class Main {
    public static void main(String[] args) {
        CoffeeMachine homeCoffeeMachine = new CoffeeMachine();
        Container cup = new Container();
        cup.setVolume(147);
        homeCoffeeMachine.pour(cup);
    }
}

/*
      +----------+
       \        /
        \      /
         \    /
          \__/

 */