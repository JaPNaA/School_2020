class BoxOffice {
    public static void main(String[] args) {
        System.out.println(" ".repeat(20) + "TOP WEEKEND BOX OFFICE");

        printRow("RANK", "TITLE", "GROSS");
        printRow("1", "Contagion", "22.4 M");
        printRow("2", "The Help", "8.9 M");
        printRow("3", "Warrior", "5.2 M");
        printRow("4", "The Debt", "4.7 M");
        printRow("5", "Colombiana", "3.9 M");
        printRow("6", "Rise of the Planet of the Apes", "3.8 M");
        printRow("7", "Shark Night 3D", "3.4 M");
        printRow("8", "Apollo 18", "2.8 M");
        printRow("9", "Out Idiot Brother", "2.6 M");
        printRow("10", "Spy Kids: All the Time in the World", "2.5 M");

        System.out.println("\n... who knows how old these stats are...");
        System.out.println("... 2011, apparently");
    }

    public static void printRow(String rank, String title, String gross) {
        System.out.printf("%-15s%40s%8s\n", rank, title, gross);
    }
}
