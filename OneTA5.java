import java.util.*;

abstract class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void talk();  
}


class Lion extends Animal {
    public Lion(String name, int age) {
        super(name, age);
    }

   
    public void talk() {
        System.out.println("Roar! I am a Lion. Name: " + name + ", Age: " + age);
    }
}

class Tiger extends Animal {
    public Tiger(String name, int age) {
        super(name, age);
    }

    
    public void talk() {
        System.out.println("Grr! I am a Tiger. Name: " + name + ", Age: " + age);
    }
}

class Elephant extends Animal {
    public Elephant(String name, int age) {
        super(name, age);
    }

   
    public void talk() {
        System.out.println("Trumpet! I am an Elephant. Name: " + name + ", Age: " + age);
    }
}

class Zebra extends Animal {
    public Zebra(String name, int age) {
        super(name, age);
    }

   
    public void talk() {
        System.out.println("Neigh! I am a Zebra. Name: " + name + ", Age: " + age);
    }
}

class Giraffe extends Animal {
    public Giraffe(String name, int age) {
        super(name, age);
    }


    public void talk() {
        System.out.println("Hum! I am a Giraffe. Name: " + name + ", Age: " + age);
    }
}


class Zoo {
    private List<Animal> animals;

    public Zoo() {
        animals = new ArrayList<>();
    }

    public void addAnimal(Animal a) {
        animals.add(a);
        System.out.println(a.getClass().getSimpleName() + " added to the zoo.");
    }

    public void removeAnimal(Animal a) {
        animals.remove(a);
        System.out.println(a.getClass().getSimpleName() + " removed from the zoo.");
    }

    public void feedingTime() {
        System.out.println("\nFeeding time! All animals talk:");
        for (Animal a : animals) {
            a.talk();
        }
        System.out.println();
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}


class Menu {
    private String[] options;
    private Scanner scanner;

    public Menu(String[] options) {
        this.options = options;
        this.scanner = new Scanner(System.in);
    }

    public int displayAndChoose() {
        while (true) {
            System.out.println("\n===== Menu =====");
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }
            System.out.print("Choose an option: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= options.length) {
                    return choice;
                } else {
                    System.out.println("Invalid choice. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number.");
            }
        }
    }
}


public class OneTA5 {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        Scanner scanner = new Scanner(System.in);

        String[] options = {
            "Add Lion",
            "Add Tiger",
            "Add Elephant",
            "Add Zebra",
            "Add Giraffe",
            "Remove Animal",
            "Feeding Time",
            "Exit"
        };
        Menu menu = new Menu(options);

        while (true) {
            int choice = menu.displayAndChoose();
            switch (choice) {
                case 1:
                    System.out.print("Enter Lion's name: ");
                    String lionName = scanner.nextLine();
                    System.out.print("Enter Lion's age: ");
                    int lionAge = Integer.parseInt(scanner.nextLine());
                    zoo.addAnimal(new Lion(lionName, lionAge));
                    break;
                case 2:
                    System.out.print("Enter Tiger's name: ");
                    String tigerName = scanner.nextLine();
                    System.out.print("Enter Tiger's age: ");
                    int tigerAge = Integer.parseInt(scanner.nextLine());
                    zoo.addAnimal(new Tiger(tigerName, tigerAge));
                    break;
                case 3:
                    System.out.print("Enter Elephant's name: ");
                    String elephantName = scanner.nextLine();
                    System.out.print("Enter Elephant's age: ");
                    int elephantAge = Integer.parseInt(scanner.nextLine());
                    zoo.addAnimal(new Elephant(elephantName, elephantAge));
                    break;
                case 4:
                    System.out.print("Enter Zebra's name: ");
                    String zebraName = scanner.nextLine();
                    System.out.print("Enter Zebra's age: ");
                    int zebraAge = Integer.parseInt(scanner.nextLine());
                    zoo.addAnimal(new Zebra(zebraName, zebraAge));
                    break;
                case 5:
                    System.out.print("Enter Giraffe's name: ");
                    String giraffeName = scanner.nextLine();
                    System.out.print("Enter Giraffe's age: ");
                    int giraffeAge = Integer.parseInt(scanner.nextLine());
                    zoo.addAnimal(new Giraffe(giraffeName, giraffeAge));
                    break;
                case 6:
                    List<Animal> animals = zoo.getAnimals();
                    if (animals.isEmpty()) {
                        System.out.println("No animals to remove!");
                        break;
                    }
                    System.out.println("Select an animal to remove:");
                    for (int i = 0; i < animals.size(); i++) {
                        System.out.println((i + 1) + ". " + animals.get(i).getClass().getSimpleName() 
                                           + " " + animals.get(i).name);
                    }
                    int removeChoice = Integer.parseInt(scanner.nextLine()) - 1;
                    if (removeChoice >= 0 && removeChoice < animals.size()) {
                        zoo.removeAnimal(animals.get(removeChoice));
                    } else {
                        System.out.println("Invalid choice!");
                    }
                    break;
                case 7:
                    zoo.feedingTime();
                    break;
                case 8:
                    System.out.println("Exiting application...");
                    System.exit(0);
            }
        }
    }
}