package knight.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import knight.beans.Food;

public class FoodPeer {
	 public static ArrayList<Food> searchFoods(DataManager dataManager,
			    String keyword) {
			    ArrayList<Food> foods = new ArrayList<Food>();
			    Connection connection = dataManager.getConnection();
			    if (connection != null) {
			      try {
			        Statement s = connection.createStatement();
			        String sql = "select food_id, name, price, description from foods"
			            + " where name like '%" + keyword.trim() + "%'"
			            + " or description like '%" + keyword.trim() + "%'";
			        try {
			          ResultSet rs = s.executeQuery(sql);
			          try {
			            while (rs.next()) {
			              Food food = new Food();
			              food.setId(rs.getString(1));
			              food.setName(rs.getString(2));			  
			              food.setPrice(rs.getDouble(3));
			              food.setDescription(rs.getString(4));
			              foods.add(food);
			              }
			            }
			          finally { rs.close(); }
			          }
			        finally { s.close(); }
			        }
			      catch (SQLException e) {
			        System.out.println("Could not search for foods:" + e.getMessage());
			        }
			      finally {
			        dataManager.putConnection(connection);
			        }
			      }
			    return foods;
			    }

			  public static ArrayList<Food> getFoodsByCategory(DataManager dataManager,
			    String categoryId) {
			    ArrayList<Food> foods = new ArrayList<Food>();
			    Connection connection = dataManager.getConnection();
			    if (connection != null) {
			      try {
			        Statement s = connection.createStatement();
			        String sql = "SELECT food_id, name, price, description FROM restaurant.foods\r\n"
			        		+ "WHERE category_id =" + categoryId;
			        try {
			          ResultSet rs = s.executeQuery(sql);
			          try {
			            while (rs.next()) {
			              Food food = new Food();
			              food.setId(rs.getString(1));
			              food.setName(rs.getString(2));
			              food.setPrice(rs.getDouble(3));
			              food.setDescription(rs.getString(4));
			              foods.add(food);
			              }
			            }
			          finally { rs.close(); }
			          }
			        finally { s.close(); }
			        }
			      catch (SQLException e) {
			        System.out.println("Could not get foods: " + e.getMessage());
			        }
			      finally {
			        dataManager.putConnection(connection);
			        }
			      }
			      return foods;
			    }

			  public static Food getFoodById(DataManager dataManager, String foodID) {
			    Food food = null;
			    Connection connection = dataManager.getConnection();
			    if (connection != null) {
			      try {
			        Statement s = connection.createStatement();
			        String sql = "select food_id, name, price, description from foods"
			            + " where food_id=" + foodID;
			        try {
			          ResultSet rs = s.executeQuery(sql);
			          try {
			            if (rs.next()) {
			              food = new Food();
			              food.setId(rs.getString(1));
			              food.setName(rs.getString(2));
			              food.setPrice(rs.getDouble(3));
			              food.setDescription(rs.getString(4));
			              
			              }
			            }
			          finally { rs.close(); }
			          }
			        finally { s.close(); }
			        }
			      catch (SQLException e) {
			        System.out.println("Could not get food: " + e.getMessage());
			        }
			      finally {
			        dataManager.putConnection(connection);
			        }
			      }
			    return food;
			    }
}
