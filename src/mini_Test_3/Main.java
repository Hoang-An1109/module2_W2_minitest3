package mini_Test_3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import static mini_Test_3.ManagerMaterial.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Material> material = new ArrayList<>();

        createObject(material);

        boolean isValid = true;

        while (isValid) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: {
                    showMaterial(material);
                    for (int i = 0; i < 3; i++) {
                        System.out.println();
                    }
                    break;
                }
                case 2: {
                    addMaterial(scanner, material);
                    break;
                }
                case 3: {
                    showMaterial(material);
                    editMaterial(scanner, material);
                    break;
                }
                case 4: {
                    showMaterial(material);
                    deleteMaterial(scanner, material);
                    break;
                }
                case 5: {
                    showTotalCost(totalCost(material));
                    break;
                }
                case 6: {
                    sortByCost(material);
                    showMaterial(material);
                    break;
                }
                case 7: {
                    showCostDifference(costDifference(totalCost(material), costAfterDiscount(material)));
                    break;
                }
                case 8: {
                    isValid = false;
                    break;
                }
                default: {
                    System.out.println("Bạn đã nhập sai!!!");
                }
            }
        }
    }

    private static void sortByCost(ArrayList<Material> material) {
        Collections.sort(material, (m1, m2) -> Double.compare(m1.getCost(), m2.getCost()));

    }

    private static void createObject(ArrayList<Material> material) {
        material.add(new CrispyFlour("01", "Thịt gà", LocalDate.now(), 50000, 10));
        material.add(new CrispyFlour("02", "Thịt bò", LocalDate.now(), 80000, 5));
        material.add(new CrispyFlour("03", "Thịt heo", LocalDate.now(), 70000, 8));
        material.add(new CrispyFlour("04", "Thịt cừu", LocalDate.now(), 130000, 3));
        material.add(new CrispyFlour("05", "Thịt vịt", LocalDate.now(), 60000, 6));

        material.add(new Meat("06", "Bột mì", LocalDate.now(), 20000, 0.5));
        material.add(new Meat("07", "Bột năng", LocalDate.now(), 30000, 0.8));
        material.add(new Meat("08", "Bột khoai tây", LocalDate.now(), 25000, 0.6));
        material.add(new Meat("09", "Bột bắp", LocalDate.now(), 35000, 0.7));
        material.add(new Meat("10", "Bột gạo", LocalDate.now(), 40000, 0.9));
    }

    private static void showMenu() {
        System.out.println("Menu");
        System.out.println("1.Hiện danh sách vật liệu.");
        System.out.println("2.Thêm vật liệu.");
        System.out.println("3.Sửa vật liệu.");
        System.out.println("4.Xóa vật liệu");
        System.out.println("5.Tính tổng tiền của các vật liệu.");
        System.out.println("6.Sắp xếp vật liệu theo giá.");
        System.out.println("7.Tính số chênh lệch giữa chiết khấu và không chiết khấu tại ngày hôm nay.");
        System.out.println("8.Thoát chương trình.");
        System.out.print("Hãy nhập lựa chọn của bạn: ");
    }

    private static void showMaterial(ArrayList<Material> material) {
        System.out.printf("| %-10s | %-40s | %-15s | %-20s | %-10s | %-10s |%n", "ID", "NAME", "DATE", "COST", "QUANTITY", "WEIGHT");

        for (int i = 0; i < material.size(); i++) {
            if (material.get(i) instanceof CrispyFlour) {
                CrispyFlour crispyFlour = (CrispyFlour) material.get(i);
                System.out.printf("| %-10s | %-40s | %-15s | %-20s | %-10s | %-10s |%n", crispyFlour.getId(), crispyFlour.getName(), crispyFlour.getManufacturingDate(), crispyFlour.getCost(), crispyFlour.getQuantity(), ""
                );
            } else {
                Meat meat = (Meat) material.get(i);
                System.out.printf("| %-10s | %-40s | %-15s | %-20s | %-10s | %-10s |%n", meat.getId(), meat.getName(), meat.getManufacturingDate(), meat.getCost(), "", meat.getWeight()
                );
            }
        }
    }

    private static int totalCost(ArrayList<Material> material) {
        int totalCost = 0;
        for (int i = 0; i < material.size(); i++) {
            totalCost += material.get(i).getAmount();
        }
        return totalCost;
    }

    private static void showTotalCost(int totalCost) {
        System.out.println("Tổng tiền của các vật liệu là: " + totalCost);
    }

    private static double costAfterDiscount(ArrayList<Material> material) {
        int costAfterDiscount = 0;
        for (int i = 0; i < material.size(); i++) {
            costAfterDiscount += material.get(i).getRealMoney();
        }
        return costAfterDiscount;
    }

    private static double costDifference(int totalCost, double costAfterDiscount) {
        double costDifference = totalCost - costAfterDiscount;
        return costDifference;
    }

    private static void showCostDifference(double costDifference) {
        System.out.println("Tổng tiền chênh lệch trước và sau khi giảm giá là: " + costDifference);
    }
}
