import java.util.Scanner;
public class Main {
    private static final int MAX_STUDENT = 100;
    private static String[] studentIDs = new String[MAX_STUDENT];
    private static String[] studentNames = new String[MAX_STUDENT];
    private static int[][] studentMarks = new int[MAX_STUDENT][2];
    private static int studentCount = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            clearConsole();
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("| \t\t\tWELCOME TO GDSE MARKS MANAGEMENT SYSTEM\t\t\t |");
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("[1] Add New Student\t\t\t[2] Add New Student With Marks");
            System.out.println("[3] Add Marks\t\t\t\t[4] Update Student Details");
            System.out.println("[5] Update Marks\t\t\t[6] Delete Student");
            System.out.println("[7] Print Student Details\t\t[8] Print Student Ranks");
            System.out.println("[9] Best In Programming Fundamental\t[10] Best In Database Management System");
            System.out.println();
            System.out.print("Enter an option to continue > ");
            int option = scanner.nextInt();
            clearConsole();
            switch (option){
                case 1:
                    addNewStudent(scanner);
                    break;
                case 2:
                    addStudentWithMarks(scanner);
                    break;
                case 3:
                    addMarks(scanner);
                    break;
                case 4:
                    updateStudentDetails(scanner);
                    break;
                case 5:
                    updateMarks(scanner);
                    break;
                case 6:

                    deleteStudent(scanner);
                    break;
                case 7:
                    printStudentDetails(scanner);
                    break;
                case 8:
                    printStudentRank(scanner);
                    break;
                case 9:
                    bestInProgrammingFundamentals(scanner);
                    break;
                case 10:
                    bestInDatabaseManagementSystem(scanner);
                    break;
            }
        }
    }
    private static void bestInDatabaseManagementSystem(Scanner scanner) {
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("| \t\t\tBEST IN DATABASE MANAGEMENT SYSTEM\t\t\t |");
        System.out.println("----------------------------------------------------------------------------------=");
        while (true){
            System.out.println();
            if (studentCount == 0) {
                System.out.println("No students available.");
                System.out.print("Do you want to go back main menu? (Y/N): ");
                String response = scanner.next();
                if (response.equalsIgnoreCase("N")) {
                    clearConsole();
                    break;
                }
                return;
            }
            for (int i = 0; i < studentCount; i++) {
                for (int j = i + 1; j < studentCount; j++) {
                    if (studentMarks[i][1] < studentMarks[j][1]) {
                        String tempID = studentIDs[i];
                        studentIDs[i] = studentIDs[j];
                        studentIDs[j] = tempID;
                        String tempName = studentNames[i];
                        studentNames[i] = studentNames[j];
                        studentNames[j] = tempName;

                        int tempDbms = studentMarks[i][0];
                        studentMarks[i][1] = studentMarks[j][1];
                        studentMarks[j][1] = tempDbms;
                    }
                }
            }
            System.out.println("+-----+--------------------+-----------+----------+");
            System.out.printf("|%-5s|%-20s|%-11s|%-10s|\n","ID","Name","PF Marks","DBMS Marks");
            System.out.println("+-----+--------------------+-----------+----------+");
            for (int i = 0; i < studentCount; i++){
                System.out.printf("|%-5s|%-20s|%-11s|%-10s|\n",studentIDs[i],studentNames[i],studentMarks[i][0],studentMarks[i][1]);
            }
            System.out.println("+-----+--------------------+-----------+----------+");
            System.out.print("Do you want to go back main menu? (Y/N): ");
            String response = scanner.next();
            if (response.equalsIgnoreCase("Y")) {
                clearConsole();
                break;
            }
        }
    }
    private static void bestInProgrammingFundamentals(Scanner scanner) {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("| \t\t\tBEST IN PROGRAMMING FUNDAMENTAL\t\t\t |");
        System.out.println("-------------------------------------------------------------------------------");
        while (true){
            if (studentCount == 0) {
                System.out.println("No students available.");
                System.out.print("Do you want to go back main menu? (Y/N): ");
                String response = scanner.next();
                if (response.equalsIgnoreCase("N")) {
                    clearConsole();
                    break;
                }
                return;
            }
            for (int i = 0; i < studentCount; i++) {
                for (int j = i + 1; j < studentCount; j++) {
                    if (studentMarks[i][0] < studentMarks[j][0]) {
                        String tempID = studentIDs[i];
                        studentIDs[i] = studentIDs[j];
                        studentIDs[j] = tempID;

                        String tempName = studentNames[i];
                        studentNames[i] = studentNames[j];
                        studentNames[j] = tempName;
                        int tempProg = studentMarks[i][0];
                        studentMarks[i][0] = studentMarks[j][0];
                        studentMarks[j][0] = tempProg;
                    }
                }
            }
            System.out.println("+-----+--------------------+-----------+----------+");
            System.out.printf("|%-5s|%-20s|%-11s|%-10s|\n","ID","Name","PF Marks","DBMS Marks");
            System.out.println("+-----+--------------------+-----------+----------+");
            for (int i = 0; i < studentCount; i++){
                System.out.printf("|%-5s|%-20s|%-11s|%-10s|\n",studentIDs[i],studentNames[i],studentMarks[i][0],studentMarks[i][1]);
            }
            System.out.println("+-----+--------------------+-----------+----------+");
            System.out.print("Do you want to go back main menu? (Y/N): ");
            String response = scanner.next();
            if (response.equalsIgnoreCase("Y")) {
                clearConsole();
                break;
            }
        }
    }
    private static int calculateStudentRank(int studentIndex) {
        int[] totalMarks = new int[studentCount];
        for (int i = 0; i < studentCount; i++) {
            totalMarks[i] = studentMarks[i][0] + studentMarks[i][1];
        }
        int[] sortedIndexes = new int[studentCount];
        for (int i = 0; i < studentCount; i++) {
            sortedIndexes[i] = i;
        }
        for (int i = 0; i < studentCount; i++) {
            for (int j = i + 1; j < studentCount; j++) {
                if (totalMarks[sortedIndexes[i]] < totalMarks[sortedIndexes[j]]) {
                    int temp = sortedIndexes[i];
                    sortedIndexes[i] = sortedIndexes[j];
                    sortedIndexes[j] = temp;
                }
            }
        }

        for (int i = 0; i < studentCount; i++) {
            if (sortedIndexes[i] == studentIndex) {
                return i + 1;
            }
        }
        return -1; // should not reach here
    }
    private static void printStudentRank(Scanner scanner) {
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("| \t\t\t\tPRINT STUDENT RANK\t\t\t\t |");
        System.out.println("----------------------------------------------------------------------------------");
        while (true){
            System.out.println();
            if (studentCount == 0) {
                System.out.println("No students available.");
                System.out.print("Do you want to go back main menu? (Y/N): ");
                String response = scanner.next();
                if (response.equalsIgnoreCase("Y")) {
                    clearConsole();
                    break;
                }
                return;
            }
            int[] totalMarks = new int[studentCount];
            for (int i = 0; i < studentCount; i++){
                totalMarks[i] = studentMarks[i][0] + studentMarks[i][1];
            }
            double[] avgMarks = new double[studentCount];
            for (int i = 0; i < studentCount; i++){
                avgMarks[i] = ((double)(totalMarks[i])/2);
            }
            for (int i = 0; i < studentCount; i++) {
                for (int j = i + 1; j < studentCount; j++) {
                    if (totalMarks[i] < totalMarks[j]) {
                        int temp = totalMarks[i];
                        totalMarks[i] = totalMarks[j];
                        totalMarks[j] = temp;
                        String tempID = studentIDs[i];
                        studentIDs[i] = studentIDs[j];
                        studentIDs[j] = tempID;
                        String tempName = studentNames[i];
                        studentNames[i] = studentNames[j];

                        studentNames[j] = tempName;
                        int tempProg = studentMarks[i][0];
                        studentMarks[i][0] = studentMarks[j][0];
                        studentMarks[j][0] = tempProg;
                        int tempDb = studentMarks[i][1];
                        studentMarks[i][1] = studentMarks[j][1];
                        studentMarks[j][1] = tempDb;
                    }
                }
            }
            System.out.println("+-----+-----+--------------------+-----------+----------+");
            System.out.printf("|%-5s|%-5s|%-20s|%-11s|%-10s|\n","Rank","ID","Name","Total Marks","Avg. Marks");
                    System.out.println("+-----+-----+--------------------+-----------+----------+");
            for (int i = 0; i < studentCount; i++){
                System.out.printf("|%-5s|%-5s|%-20s|%-11s|%-10s|\n",i+1,studentIDs[i],studentNames[i],totalMarks[i],avgMarks[i]);
            }
            System.out.println("+-----+-----+--------------------+-----------+----------+");
            System.out.print("Do you want to go back main menu? (Y/N): ");
            String response = scanner.next();
            if (response.equalsIgnoreCase("Y")) {
                clearConsole();
                break;
            }
        }
    }
    private static void printStudentDetails(Scanner scanner) {
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\tPRINT STUDENT DETAILS\t\t\t\t|");
        System.out.println("---------------------------------------------------------------------------------");
        while (true){
            System.out.println();
            System.out.print("Enter Student ID: ");
            String studentID = scanner.next();
            if (studentID.matches("^S\\d{3}$")){
                int index = findStudentIndexByID(studentID);
                if (index == -1){
                    System.out.println("Student ID not found. Please try again.");
                    System.out.print("Do you want to print another student details? (Y/N): ");
                    String response = scanner.next();
                    if (response.equalsIgnoreCase("N")) {

                        clearConsole();
                        break;
                    }
                    continue;
                }
                int rank = calculateStudentRank(index);
                int progmark = studentMarks[index][0];
                int dbmsmark = studentMarks[index][1];
                double avg = (double) (progmark + dbmsmark)/2;
                System.out.println("Student Name : " +studentNames[index]);
                System.out.println();
                System.out.println("+-----------------------------------+--------------------+");
                System.out.printf("|%-35s|%20s|\n","Programming Fundamentals Marks",studentMarks[index][0]);
                System.out.printf("|%-35s|%20s|\n","Database Management System Marks",studentMarks[index][1]);
                System.out.printf("|%-35s|%20s|\n","Total Marks",(studentMarks[index][0]+studentMarks[index][1]));
                System.out.printf("|%-35s|%20s|\n","Average marks",avg);
                System.out.printf("|%-35s|%20s|\n","Rank",rank +formatOrdinalWord(rank));
                System.out.println("+-----------------------------------+--------------------+");
                System.out.print("Do you want to print another student details? (Y/N): ");
                String response = scanner.next();
                if (response.equalsIgnoreCase("N")) {
                    clearConsole();
                    break;
                }
            }else {
                System.out.print("Invalid Student ID. Do you want to print another student details? (Y/N): ");
                String response = scanner.next();
                if (response.equalsIgnoreCase("N")) {
                    clearConsole();
                    break;
                }
            }
        }
    }
    private static void deleteStudent(Scanner scanner) {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("| \t\t\t\tDELETE STUDENT\t\t\t\t |");
        System.out.println("-------------------------------------------------------------------------------");
        while (true){
            System.out.println();

            System.out.print("Enter Student ID: ");
            String studentID = scanner.next();
            if (studentID.matches("^S\\d{3}$")){
                int index = findStudentIndexByID(studentID);
                if (index == -1){
                    System.out.println("Student ID not found. Please try again.");
                    System.out.print("Do you want search again (Y/N): ");
                    String response = scanner.next();
                    if (response.equalsIgnoreCase("N")) {
                        clearConsole();
                        break;
                    }
                    continue;
                }
                for (int i = index; i < studentCount - 1; i++){
                    studentIDs[i] = studentIDs[i+1];
                    studentNames[i] = studentNames[i+1];
                    studentMarks[i][0] = studentMarks[i+1][0];
                    studentMarks[i][1] = studentMarks[i+1][1];
                }
                studentCount--;
                System.out.println("Student deleted successfully.");
                System.out.print("Invalid Student ID. Do you want to delete another student? (Y/N): ");
                String response = scanner.next();
                if (response.equalsIgnoreCase("N")) {
                    clearConsole();
                    break;
                }
            }else {
                System.out.print("Invalid Student ID. Do you want to delete another student? (Y/N): ");
                String response = scanner.next();
                if (response.equalsIgnoreCase("N")) {
                    clearConsole();
                    break;
                }
            }
        }
    }
    private static void updateMarks(Scanner scanner) {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("| \t\t\t\tUPDATE MARKS\t\t\t\t |");
        System.out.println("-------------------------------------------------------------------------------");
        while (true){
            System.out.println();

            System.out.print("Enter Student ID: ");
            String studentID = scanner.next();
            if (studentID.matches("^S\\d{3}$")){
                int index = findStudentIndexByID(studentID);
                if (index == -1){
                    System.out.println("Student ID not found. Please try again.");
                    System.out.print("Do you want search again (Y/N): ");
                    String response = scanner.next();
                    if (response.equalsIgnoreCase("N")) {
                        clearConsole();
                        break;
                    }
                    continue;
                }
                System.out.println("Student Name :" +studentNames[index]);
                if (studentMarks[index][0] != -1 && studentMarks[index][1] != -1){
                    System.out.println("\nProgram Foundamental Mark :" + studentMarks[index][0]);
                    System.out.println("Database Management System Mark :" + studentMarks[index][1]);
                    int progNewMark;
                    int dbmsNewMark;
                    do {
                        System.out.print("Enter new Programming Foundamental Marks :");
                        progNewMark = scanner.nextInt();
                        if (!isValid(progNewMark)){
                            System.out.println("Invalid marks. Please enter correct marks");
                        }
                    } while (!isValid(progNewMark));
                    do {
                        System.out.print("Database Management System Marks :");
                        dbmsNewMark = scanner.nextInt();
                        if (!isValid(dbmsNewMark)){
                            System.out.println("Invalid marks. Please enter correct marks");
                        }
                    } while (!isValid(dbmsNewMark));
                    System.out.println("Marks have been updated successfully.");
                    System.out.print("Do you want update marks for another student? (Y/N): ");
                    String response = scanner.next();
                    if (response.equalsIgnoreCase("N")) {
                        clearConsole();
                        break;
                    }
                } else {

                    System.out.println("This student's marks yet to be added");
                    System.out.print("Do you want search again (Y/N): ");
                    String response = scanner.next();
                    if (response.equalsIgnoreCase("N")) {
                        clearConsole();
                        break;
                    }
                }
            } else {
                System.out.print("Invalid Student ID. Do you want search again (Y/N): ");
                String response = scanner.next();
                if (response.equalsIgnoreCase("N")) {
                    clearConsole();
                    break;
                }
            }
        }
    }
    private static void addMarks(Scanner scanner) {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("| \t\t\t\tADD MARKS\t\t\t\t |");
        System.out.println("-------------------------------------------------------------------------------");
        while (true){
            System.out.println();
            System.out.print("Enter Student ID: ");
            String studentID = scanner.next();
            if (studentID.matches("^S\\d{3}$")){
                int index = findStudentIndexByID(studentID);
                if (index == -1) {
                    System.out.print("Student ID not found. Please try again. Do you want add marks again (Y/N):");
                    String response = scanner.next();
                    if (response.equalsIgnoreCase("N")) {
                        clearConsole();
                        break;
                    }
                    continue;
                }
                if (studentMarks[index][0] != -1 && studentMarks[index][1] != -1){
                    System.out.println("Student Name: " +studentNames[index]);
                    System.out.println("This student's marks have been already added");
                    System.out.println("If you want to update the marks, please use [4] Update Mark option");
                    System.out.print("Do you want add marks again (Y/N):");

                    String response = scanner.next();
                    if (response.equalsIgnoreCase("N")) {
                        clearConsole();
                        break;
                    }
                    continue;
                }
                System.out.println("Student Name: " +studentNames[index]);
                int progMark;
                int dbmsMark;
                do {
                    System.out.print("Programming Foundamental Marks :");
                    progMark = scanner.nextInt();
                    studentMarks[index][0] = progMark;
                    if (!isValid(progMark)){
                        System.out.println("Invalid marks. Please enter correct marks");
                    }
                } while (!isValid(progMark));
                do {
                    System.out.print("Database Management System Marks :");
                    dbmsMark = scanner.nextInt();
                    studentMarks[index][1] = dbmsMark;
                    if (!isValid(dbmsMark)){
                        System.out.println("Invalid marks. Please enter correct marks");
                    }
                } while (!isValid(dbmsMark));
                System.out.println("Marks added successfully.");
                System.out.print("Do you want add marks again (Y/N):");
                String response = scanner.next();
                if (response.equalsIgnoreCase("N")) {
                    clearConsole();
                    break;
                }
            } else {
                System.out.print("Invalid Student ID. Do you want add marks again (Y/N): ");
                String response = scanner.next();
                if (response.equalsIgnoreCase("N")) {
                    clearConsole();
                    break;
                }
            }
        }

    }
    private static void updateStudentDetails(Scanner scanner) {
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\tUPDATE STUDENT DETAILS\t\t\t\t|");
        System.out.println("---------------------------------------------------------------------------------");
        while (true){
            System.out.println();
            System.out.print("Enter Student ID: ");
            String studentID = scanner.next();
            if (studentID.matches("^S\\d{3}$")){
                int index = findStudentIndexByID(studentID);
                if (index == -1){
                    System.out.println("Student ID not found. Please try again.");
                    System.out.print("Do you want search again (Y/N): ");
                    String response = scanner.next();
                    if (response.equalsIgnoreCase("N")) {
                        clearConsole();
                        break;
                    }
                    continue;
                }
                System.out.println("Current Student Name: "+ studentNames[index]);
                System.out.print("Enter New Student Name: ");
                String newName = scanner.next();
                studentNames[index] = newName;
                System.out.println("Student details updated successfully.");
                System.out.print("Do you want search again (Y/N): ");
                String response = scanner.next();
                if (response.equalsIgnoreCase("N")) {
                    clearConsole();
                    break;
                }
            } else {
                System.out.print("Invalid Student ID. Do you want search again (Y/N): ");
                String response = scanner.next();
                if (response.equalsIgnoreCase("N")) {
                    clearConsole();
                    break;
                }
            }
        }
    }
    public static void addNewStudent(Scanner scanner) {
        System.out.println("------------------------------------------------------------------------------");

        System.out.println("| \t\t\t\tADD NEW STUDENT\t\t\t\t |");
        System.out.println("------------------------------------------------------------------------------");
        while (true){
            System.out.println();
            System.out.print("Enter Student ID:");
            String studentID = scanner.next();
            if (studentID.matches("^S\\d{3}$")){
                if (findStudentIndexByID(studentID) != -1) {
                    System.out.println("Student ID already exists. Please try again.");
                    continue;
                }
                System.out.print("Enter Student Name: ");
                String studentName = scanner.next();
                studentIDs[studentCount] = studentID;
                studentNames[studentCount] = studentName;
                studentMarks[studentCount][0] = -1; // -1 indicates marks not assigned
                studentMarks[studentCount][1] = -1; // -1 indicates marks not assigned
                studentCount++;
                System.out.println("Student added successfully.");
                System.out.print("Do you want to add again (Y/N): ");
                String response = scanner.next();
                if (response.equalsIgnoreCase("N")) {
                    clearConsole();
                    break;
                }
            } else {
                System.out.print("Invalid Student ID. Do you want to add again (Y/N): ");
                String response = scanner.next();
                if (response.equalsIgnoreCase("N")) {
                    clearConsole();
                    break;
                }
            }
        }
    }
    public static void addStudentWithMarks(Scanner scanner){
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("| \t\t\t\tADD STUDENT WITH MARKS\t\t\t\t |");
        System.out.println("----------------------------------------------------------------------------------");
        while (true){
            System.out.println();
            System.out.print("Enter Student ID: ");
            String studentID = scanner.next();

            if (studentID.matches("^S\\d{3}$")) {
                if (findStudentIndexByID(studentID) != -1) {
                    System.out.println("Student ID already exists. Please try again.");
                    continue;
                }
                System.out.print("Enter Student Name: ");
                String studentName = scanner.next();
                studentIDs[studentCount] = studentID;
                studentNames[studentCount] = studentName;
                int programmingFundamentalsMarks;
                int databaseManagementSystemMarks;
// add Programming Fundamentals Marks
                do {
                    System.out.print("Programming Fundamentals Marks: ");
                    programmingFundamentalsMarks = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    if (!isValid(programmingFundamentalsMarks)) {
                        System.out.println("Invalid marks, please enter correct marks.");
                    }
                } while (!isValid(programmingFundamentalsMarks));
//add Database Management System Marks
                do {
                    System.out.print("Database Management System Marks: ");
                    databaseManagementSystemMarks = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    if (!isValid(databaseManagementSystemMarks)) {
                        System.out.println("Invalid marks, please enter correct marks.");
                    }
                } while (!isValid(databaseManagementSystemMarks));
                studentMarks[studentCount][0] = programmingFundamentalsMarks; // -1 indicates marksnot assigned
                studentMarks[studentCount][1] = databaseManagementSystemMarks; // -1 indicatesmarks not assigned
                studentCount++;
                System.out.println("Student added successfully.");
                System.out.print("Do you want to add again (Y/N): ");
                String response = scanner.next();
                if (response.equalsIgnoreCase("N")) {
                    clearConsole();
                    break;

                }
            } else {
                System.out.print("Invalid Student ID. Do you want to add again (Y/N): ");
                String response = scanner.next();
                if (response.equalsIgnoreCase("N")) {
                    clearConsole();
                    break;
                }
            }
        }
    }
    // Rank in word
    public static String formatOrdinalWord(int rank) {
        String word = getOrdinalWord(rank);
        return " (" + word + ")";
    }
    public static String getOrdinalWord(int rank) {
        if (rank <= 0) {
            return "Number should be greater than 0";
        }
        String[] units = {
                "", "First", "Second", "Third", "Fourth", "Fifth",
                "Sixth", "Seventh", "Eighth", "Ninth"
        };
        String[] teens = {
                "Tenth", "Eleventh", "Twelfth", "Thirteenth", "Fourteenth",
                "Fifteenth", "Sixteenth", "Seventeenth", "Eighteenth", "Nineteenth"
        };
        String[] tens = {
                "", "", "Twentieth", "Thirtieth", "Fortieth", "Fiftieth",
                "Sixtieth", "Seventieth", "Eightieth", "Ninetieth"
        };
        if (rank < 10) {
            return units[rank];
        } else if (rank < 20) {
            return teens[rank - 10];
        } else {
            int tenUnit = rank / 10;
            int unit = rank % 10;

            String word = tens[tenUnit];
            if (unit > 0) {
                word = tens[tenUnit].replace("ieth", "y") + "-" + units[unit];
            }
            return word;
        }
    }
    private static int findStudentIndexByID(String studentID) {
        for (int i = 0; i < studentCount; i++) {
            if (studentIDs[i].equals(studentID)) {
                return i;
            }
        }
        return -1;
    }
    //Marks validation
    private static boolean isValid(int marks) {
        return marks >= 0 && marks <= 100;
    }
    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name"); if (os.contains("Windows")) { new
                    ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace(); // Handle any exceptions.
        }
    }
}