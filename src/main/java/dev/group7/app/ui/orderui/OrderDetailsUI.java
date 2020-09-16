// package dev.group7.app.ui.orderui;

// import java.util.List;

// import dev.group7.app.bl.OrderBL;
// import dev.group7.app.persistance.Order;

// public class OrderDetailsUI {
//     static OrderBL obl = new OrderBL();

//     public void showOrderdetails() {
//         List<Order> lodt = obl.ALLOrderDetails();
//         System.out.println("\nOrderDetails List");
//         System.out.println("+------------------------------------------------------------------+");
//         System.out.printf("| %-10s | %-10s | %-25s | %-10s |\n", "Order_id", "Product_id", "Unit_price", "Quantity");
//         System.out.println("+------------------------------------------------------------------+");
//         if (lodt.isEmpty()) {
//             System.out.println("Empty list!");
//         }
//         for (Order odt : lodt) {
//             System.out.printf("| %-10d | %-10d | %-25.2f | %-10d |\n", odt.getOrder_id(), odt.getPro_id(),
//                     odt.getUnit_price(), odt.getQuantity());
//         }
//         System.out.println("+------------------------------------------------------------------+");
//     }

//     public void showOrderdetailsById() {
//         List<Order> listbyid = obl.OrderDetailsById();
//         System.out.println("\nOrderDetails List");
//         System.out.println("+--------------------------------------------------------------------------------+");
//         System.out.printf("| %-10s | %-10s | %-10s | %-25s | %-10s  |\n", "Order_id", "User_id", "Pro_id", "Unit_price",
//                 "Quantity");
//         System.out.println("+--------------------------------------------------------------------------------+");
//         if (listbyid.isEmpty()) {
//             System.out.println("Empty list!");
//         }
//         for (Order odtid : listbyid) {
//             System.out.printf("| %-10d | %-10d | %-10d | %-25.2f | %-10d  |\n", odtid.getOrder_id(), odtid.getUser_id(),
//                     odtid.getPro_id(), odtid.getUnit_price(), odtid.getQuantity());
//         }
//         System.out.println("+--------------------------------------------------------------------------------+");
//     }
// }