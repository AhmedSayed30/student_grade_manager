//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    String[] names = {"Ahmed", "Sayed", "Mohamed", "Ali", "Mona"};
    String[] subject = {"Math", "Sci", "Eng"};
    int[][] studentGrade = {
            {90, 80, 70},
            {45, 50, 40},
            {100, 100, 100},
            {80, 85, 60},
            {30, 60, 70}
    };

    Scanner in = new Scanner(System.in);
    int option = -1;
    do {

        showMenu();

        System.out.print("Please enter your option : ");
        option = in.nextInt();
        in.nextLine();
        switch (option){
            case 1:
                showStudentsName(names);
                break;
            case 2:
                showStudentsGrades(names,subject,studentGrade);
                break;
            case 3:
                System.out.print("Please enter name : ");
                String target = in.nextLine();
                searchByName(names,subject,studentGrade,target);
                break;
            case 4:
                passedStudents();
                break;
            case 0:
                break;
            default:
                System.out.println("invalid input");
        }
    } while (option != 0);
}

private void showMenu() {
    System.out.println("\n1. Show All Students names.\n" +
            "2. Show all Students grades in each subject.\n" +
            "3. Search Student by name.\n" +
            "4. Count Passed Students\n" +
            "0. Exit\n");
}

private void passedStudents() {
}

private void searchByName(String[] names, String[] subject, int[][] grade, String target) {
    for (int i = 0; i <= names.length-1; i++){
        if(names[i].equalsIgnoreCase(target)){
            System.out.println(names[i]);
            for (int j = 0; j <= subject.length-1; j++){
                System.out.print(subject[j]+": "+ grade[i][j]+"   ");
            }
            System.out.println(" ");
            return;
        }
    }
    System.out.println("The name not found");
}

private void showStudentsGrades(String[] names, String[] subject, int[][] grade) {
    for (int i = 0; i <= names.length-1; i++){
        System.out.println(names[i]+" :");
        for (int j = 0; j <= subject.length-1; j++){
            System.out.print(subject[j]+": "+ grade[i][j]+"   ");
        }
        System.out.println(" ");
    }
}

private void showStudentsName(String[] names) {
    for (int i = 0; i <= names.length-1; i++){
        System.out.println(names[i]);
    }
}
