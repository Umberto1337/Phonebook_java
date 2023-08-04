import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "cp866");
        Map<String, List<String>> phoneBook = new HashMap<>();

        while (true) {
            System.out.println("Меню:");
            System.out.println("1) Добавить контакт");
            System.out.println("2) Вывести всех");
            System.out.println("3) Выход");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Считываем лишний перенос строки

            if (choice == 1) {
                System.out.print("Введите имя контакта: ");
                String name = scanner.nextLine();
                System.out.print("Введите телефон: ");
                String phone = scanner.nextLine();

                phoneBook.putIfAbsent(name, new ArrayList<>());
                List<String> phones = phoneBook.get(name);
                if (!phones.contains(phone)) {
                    phones.add(phone);
                }
            } else if (choice == 2) {
                for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
                    String name = entry.getKey();
                    List<String> phones = entry.getValue();
                    Collections.sort(phones, Collections.reverseOrder());
                    System.out.print(name + ": ");
                    for (String phone : phones) {
                        System.out.print(phone + ", ");
                    }
                    System.out.println("\"" + String.join(", ", phones) + "\"");
                }
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        }

        scanner.close();
    }
}
