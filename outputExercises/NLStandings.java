class NLStandings {
    public static void main(String[] args) {
        printRow("TEAM", "W", "L", "PCT", "GB", "STRK", "L10");
        printRow("Philadelphia", "94", "50", ".653", "--", "Lost 2", "6-4");
        printRow("Atlanta", "84", "64", ".568", "12", "Lost 4", "3-7");
        printRow("NY Mets", "71", "76", ".483", "24\u00bd", "Lost 3", "4-6");
        printRow("Washington", "68", "77", ".469" /* nice */, "26\u00bd", "Won 2", "5-5");
        printRow("Florida", "67", "79", ".459", "28", "Won 4", "7-3");

    }

    public static void printRow(String team, String wins, String losses, String pct, String gb, String streak, String last10) {
        System.out.printf("%-15s%5s%5s%8s%8s%12s%6s\n", team, wins, losses, pct, gb, streak, last10);
    }
}
