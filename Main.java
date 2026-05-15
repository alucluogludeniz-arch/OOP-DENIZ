import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ShapeList shapes = new ShapeList();

        String menu =
                "\n ***** Shape Management Application ****** \n" +
                        "1- Add Shape\n" +
                        "2- Remove Shape\n" +
                        "3- Get Shape Information by ID\n" +
                        "4- Area & Perimeter by ID\n" +
                        "5- Show all shapes\n" +
                        "6- Translate all shapes\n" +
                        "7- Scale all shapes\n" +
                        "0- Exit\n";

        while (true) {

            System.out.print(menu);
            System.out.print("Enter your choice: ");
            String choice = input.next();

            // ================= EXIT =================
            if (choice.equals("0")) {
                System.out.println("Exiting program...");
                break;
            }

            // ================= ADD SHAPE =================
            else if (choice.equals("1")) {

                System.out.print("Enter shape type (C, T, S, R): ");
                char type = input.next().toUpperCase().charAt(0);

                if (type == 'C') {

                    System.out.print("Enter x: ");
                    int x = input.nextInt();
                    System.out.print("Enter y: ");
                    int y = input.nextInt();
                    System.out.print("Enter radius: ");
                    double r = input.nextDouble();

                    shapes.addShape(new Circle(new Coordinates(x, y), r));
                    System.out.println("Circle added.");
                }

                else if (type == 'S') {

                    System.out.print("Enter x: ");
                    int x = input.nextInt();
                    System.out.print("Enter y: ");
                    int y = input.nextInt();
                    System.out.print("Enter side: ");
                    double side = input.nextDouble();

                    shapes.addShape(new Square(new Coordinates(x, y), side));
                    System.out.println("Square added.");
                }

                else if (type == 'R') {

                    System.out.print("Enter x: ");
                    int x = input.nextInt();
                    System.out.print("Enter y: ");
                    int y = input.nextInt();
                    System.out.print("Enter width: ");
                    double width = input.nextDouble();
                    System.out.print("Enter length: ");
                    double length = input.nextDouble();

                    shapes.addShape(new Rectangle(new Coordinates(x, y), width, length));
                    System.out.println("Rectangle added.");
                }

                else if (type == 'T') {

                    System.out.print("Enter x1 y1: ");
                    Coordinates v1 = new Coordinates(input.nextInt(), input.nextInt());

                    System.out.print("Enter x2 y2: ");
                    Coordinates v2 = new Coordinates(input.nextInt(), input.nextInt());

                    System.out.print("Enter x3 y3: ");
                    Coordinates v3 = new Coordinates(input.nextInt(), input.nextInt());

                    shapes.addShape(new Triangle(v1, v2, v3));
                    System.out.println("Triangle added.");
                }

                else {
                    System.out.println("Invalid shape type.");
                }
            }

            // ================= REMOVE =================
            else if (choice.equals("2")) {

                System.out.print("Enter ID to remove: ");
                int id = input.nextInt();

                if (shapes.isValid(id)) {
                    shapes.removeShape(id);
                    System.out.println("Shape removed successfully.");
                } else {
                    System.out.println("Invalid ID.");
                }
            }

            // ================= DISPLAY BY ID =================
            else if (choice.equals("3")) {

                System.out.print("Enter ID: ");
                int id = input.nextInt();

                if (shapes.isValid(id)) {
                    System.out.println(shapes.getShape(id));
                } else {
                    System.out.println("Shape not found.");
                }
            }

            // ================= AREA & PERIMETER =================
            else if (choice.equals("4")) {

                System.out.print("Enter ID: ");
                int id = input.nextInt();

                if (shapes.isValid(id)) {
                    System.out.println(shapes.getShape(id));
                    System.out.println("Area: " + shapes.area(id));
                    System.out.println("Perimeter: " + shapes.perimeter(id));
                } else {
                    System.out.println("Shape not found.");
                }
            }

            // ================= SHOW ALL =================
            else if (choice.equals("5")) {

                if (shapes.size() == 0) {
                    System.out.println("No shapes available.");
                } else {
                    System.out.println(shapes.display());
                }
            }

            // ================= TRANSLATE =================
            else if (choice.equals("6")) {

                System.out.print("Enter dx: ");
                int dx = input.nextInt();

                System.out.print("Enter dy: ");
                int dy = input.nextInt();

                shapes.translateShapes(dx, dy);
                System.out.println("All shapes translated.");
            }

            // ================= SCALE =================
            else if (choice.equals("7")) {

                System.out.print("Enter scale factor: ");
                int factor = input.nextInt();

                System.out.print("Positive scale? (true/false): ");
                boolean sign = input.nextBoolean();

                shapes.scale(factor, sign);
                System.out.println("All shapes scaled.");
            }

            else {
                System.out.println("Invalid choice.");
            }
        }

        input.close();
    }
}