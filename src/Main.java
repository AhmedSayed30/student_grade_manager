//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
Scanner in = new Scanner(System.in);

void main() {
    String[] names = insertNames();
    String[] subjects = {"Math", "Sci", "Eng"};
    int[][] studentGrade = insertStudentGrade(names,subjects);

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
                showStudentsGrades(names,subjects,studentGrade);
                break;
            case 3:
                System.out.print("Please enter name : ");
                String target = in.nextLine();
                searchByName(names,subjects,studentGrade,target);
                break;
            case 4:
                passedStudents(names,subjects,studentGrade);
                break;
            case 5:
                int subject = -1;

                System.out.print("Enter subject name: ");
                String nameOfSubject = in.nextLine();

                for (int i = 0; i < subjects.length; i++) {
                    if (subjects[i].equalsIgnoreCase(nameOfSubject)) {
                        subject = i;
                        break;
                    }
                }

                if (subject == -1) {
                    System.out.println("Invalid subject.");
                } else {
                    System.out.println("The average of " + nameOfSubject
                            + " is " + showSubjectAverages(studentGrade, subject));
                }
                break;
            case 6:
                showHighestGrades(subjects,studentGrade);
                break;
            case 7:
                showGradesLetter(names,subjects,studentGrade);
                break;
            case 0:
                break;
            default:
                System.out.println("invalid input");
        }
    } while (option != 0);
}

private void showGradesLetter(String[] names, String[] subjects, int[][] studentGrade) {
    for (int i = 0; i < names.length; i++){
        System.out.println(names[i] + " :-");
        for (int j = 0; j < subjects.length; j++){
            System.out.println(subjects[j] + " : " +
                    getLetterGrade(studentGrade[i][j]));

        }
    }
}

private char getLetterGrade(int grade) {
    if (grade >= 85) {
        return 'A';
    } else if (grade >= 75) {
        return 'B';
    } else if (grade >= 65) {
        return 'C';
    } else if (grade >= 50) {
        return 'D';
    } else {
        return 'F';
    }
}

private void showHighestGrades(String[] subjects, int[][] studentGrade) {


    for(int i = 0; i < subjects.length;i++){
        int highest = 0 ;
        for (int j = 0; j < studentGrade.length; j++){
            if(highest < studentGrade[j][i]){
                highest = studentGrade[j][i];
            }
        }
        System.out.println("Highest " + subjects[i] + ": " + highest);
    }

}

private double showSubjectAverages(int[][] studentGrade, int subject) {
    int sumOfGrades = 0;

    for (int[] ints : studentGrade) {
        sumOfGrades += ints[subject];
    }

    return (double) sumOfGrades / studentGrade.length;
}


private int[][] insertStudentGrade(String[] names, String[] subject) {
    int[][] studentGrade = new int[names.length][subject.length];

    System.out.println("Enter Student Grades");

    for (int i = 0; i < names.length; i++) {
        System.out.println(names[i] + " :-");

        for (int j = 0; j < subject.length; j++) {
            System.out.print(subject[j] + " : ");


            do {
                studentGrade[i][j] = in.nextInt();

                if (studentGrade[i][j] < 0 || studentGrade[i][j] > 100) {
                    System.out.println("Invalid grade.");
                    System.out.print("Please enter grade again: ");
                }

            } while (studentGrade[i][j] < 0 || studentGrade[i][j] > 100);

        }
    }

    return studentGrade;
}


private String[] insertNames() {
    String [] names = new String[5];
    for (int i = 0; i < names.length; i++){
        System.out.print("Enter Name " + (i + 1) + ": ");
        names[i] = in.nextLine();
    }
    return names;
}

private void showMenu() {
    System.out.println("\n1. Show All Students names.\n" +
            "2. Show all Students grades in each subject.\n" +
            "3. Search Student by name.\n" +
            "4. Count Passed Students\n" +
            "5. Show Average for each Subject\n" +
            "6. Show highest grade in each subject\n" +
            "7. Show Letter Grades\n"+
            "0. Exit\n");
}

private void passedStudents(String[] names, String[] subject, int[][] grade) {
    int counter = 0;
    for (int i = 0; i < names.length; i++) {
        boolean isPassed = true;
        for (int j = 0; j < subject.length; j++) {
            if (getLetterGrade(grade[i][j]) == 'F') {
                isPassed = false;
                break;
            }
        }
        if (isPassed) {
            counter++;
            System.out.println(names[i] + " is passed");
        }else {
            System.out.println(names[i] + " isn't passed");
        }
    }
    System.out.println("Counter of students Passed is : " + counter);

}

private void searchByName(String[] names, String[] subject, int[][] grade, String target) {
    for (int i = 0; i < names.length; i++){
        if(names[i].equalsIgnoreCase(target)){
            System.out.println(names[i]);
            for (int j = 0; j < subject.length; j++){
                System.out.print(subject[j]+": "+ grade[i][j]+"   ");
            }
            System.out.println(" ");
            return ;
        }
    }
    System.out.println("The name not found");
    return ;
}

private void showStudentsGrades(String[] names, String[] subject, int[][] grade) {
    for (int i = 0; i < names.length; i++){
        System.out.println(names[i]+" :");
        for (int j = 0; j < subject.length; j++){
            System.out.print(subject[j]+": "+ grade[i][j]+"   ");
        }
        System.out.println(" ");
    }
}

private void showStudentsName(String[] names) {
    for (int i = 0; i < names.length; i++){
        System.out.println(names[i]);
    }
}
