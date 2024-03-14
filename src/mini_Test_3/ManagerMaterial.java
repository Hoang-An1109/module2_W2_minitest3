package mini_Test_3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerMaterial {
    public static void addMaterial(Scanner scanner, ArrayList<Material> material) {
        boolean isValid = true;
        while (isValid) {
            showMenuAddMaterial();
            int choice = scanner.nextInt();

            choiceAddMaterial(scanner, material, choice);
            showMenuChoiceNext();

            int choice2 = scanner.nextInt();
            scanner.nextLine();
            if (choice2 == 2) {
                isValid = false;
            }
        }
    }

    private static void showMenuChoiceNext() {
        System.out.println();
        System.out.println("Bạn có muốn tiếp tục hay không.");
        System.out.println("Nếu muốn bấm phím 1.");
        System.out.println("Nếu không bấm phím 2.");
    }

    private static void choiceAddMaterial(Scanner scanner, ArrayList<Material> material, int choice) {
        switch (choice) {
            case 1: {
                addMaterialIsCrispyFlour(scanner, material);
                System.out.println("Bạn đã thêm vật liệu thành công.");
                break;
            }
            case 2: {
                addMaterialIsMeat(scanner, material);
                System.out.println("Bạn đã thêm vật liệu thành công.");
                break;
            }
            default: {
                System.out.println("Bạn đã nhập sai!!!");
            }
        }
    }

    private static void showMenuAddMaterial() {
        System.out.println();
        System.out.println("Bạn muốn thêm vật liệu.");
        System.out.println("1.Loại vật liệu bột.");
        System.out.println("2.Loại vật liệu thịt.");
        System.out.print("Chọn loại vật liệu bạn muốn thêm: ");
    }

    public static void addMaterialIsCrispyFlour(Scanner scanner, ArrayList<Material> material) {
        System.out.println("Nhập Id:");
        String id = scanner.nextLine();

        System.out.println("Nhập tên:");
        String name = scanner.nextLine();

        System.out.println("Nhập giá:");
        int price = scanner.nextInt();

        System.out.println("Nhập số lượng:");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        material.add(new CrispyFlour(id, name, LocalDate.now(), price, quantity));
    }

    public static void addMaterialIsMeat(Scanner scanner, ArrayList<Material> material) {
        System.out.println("Nhập Id:");
        String id = scanner.nextLine();

        System.out.println("Nhập tên:");
        String name = scanner.nextLine();

        System.out.println("Nhập giá:");
        int price = scanner.nextInt();

        System.out.println("Nhập cân nặng:");
        double weight = scanner.nextDouble();
        scanner.nextLine();

        material.add(new Meat(id, name, LocalDate.now(), price, weight));
    }

    public static void editMaterial(Scanner scanner, ArrayList<Material> material) {
        System.out.print("Hãy nhập ID của vật liệu bạn muốn sửa: ");
        String id = scanner.nextLine();
        boolean isValid = true;
        for (int i = 0; i < material.size(); i++) {
            if (id.equals(material.get(i).getId())) {
                if (material.get(i) instanceof CrispyFlour) {
                    editMaterialIsCrispyFlour(scanner, material, i);
                    isValid = false;
                } else {
                    editMaterialIsMeat(scanner, material, i);
                    isValid = false;
                }
            }
        }
        if (isValid) {
            System.out.println("Không tìm thấy ID bạn vừa nhập!!!");
        }

    }

    private static void editMaterialIsMeat(Scanner scanner, ArrayList<Material> material, int i) {
        Meat meat = (Meat) material.get(i);
        System.out.println("Nhập tên:");
        String nameEdit = scanner.nextLine();

        System.out.println("Nhập giá:");
        int priceEdit = scanner.nextInt();

        System.out.println("Nhập cân nặng:");
        double weightEdit = scanner.nextDouble();
        scanner.nextLine();

        meat.setName(nameEdit);
        meat.setCost(priceEdit);
        meat.setWeight(weightEdit);
    }

    private static void editMaterialIsCrispyFlour(Scanner scanner, ArrayList<Material> material, int i) {
        CrispyFlour crispyFlour = (CrispyFlour) material.get(i);

        System.out.println("Nhập tên:");
        String nameEdit = scanner.nextLine();

        System.out.println("Nhập giá:");
        int priceEdit = scanner.nextInt();

        System.out.println("Nhập số lượng:");
        int quantityEdit = scanner.nextInt();
        scanner.nextLine();

        crispyFlour.setName(nameEdit);
        crispyFlour.setCost(priceEdit);
        crispyFlour.setQuantity(quantityEdit);
    }

    public static void deleteMaterial(Scanner scanner, ArrayList<Material> material) {
        System.out.print("Hãy nhập ID của vật liệu bạn muốn xóa: ");
        String id = scanner.nextLine();

        for (int i = 0; i < material.size(); i++) {
            if (id.equals(material.get(i).getId())) {
                material.remove(material.get(i));
            }
        }
    }
}
