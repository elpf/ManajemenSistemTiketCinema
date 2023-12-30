/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package movieticketbookingmanagement;

import javafx.scene.control.DatePicker;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Date;
import java.time.LocalDate;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.StageStyle;




/**
 * FXML Controller class
 *
 * @author Elga
 */
public class DashboardController implements Initializable {

    @FXML
    private Label username;
    @FXML
    private Button dashboard_btn;
    @FXML
    private Button addMovies_btn;
    @FXML
    private Button availableMovies_btn;
    @FXML
    private Button editScreening_btn;
    @FXML
    private Button customers_btn;
    @FXML
    private Button signOut_btn;
    @FXML
    private AnchorPane dashboard_form;
    @FXML
    private TableColumn<?, ?> customers_col_dateCheckedOut;
    @FXML
    private Label dashboard_totalEarn;
    @FXML
    private Label dashboard_availableMovies;
    @FXML
    private AnchorPane addMovies_form;
    @FXML
    private ImageView addMovies_imageView;
    @FXML
    private Button addMovies_import;
    @FXML
    private TextField addMovies_movieTitle;
    @FXML
    private TextField addMovies_genre;
    @FXML
    private TextField addMovies_duration;
    @FXML
    private Button addMovies_insertBtn;
    @FXML
    private Button addMovies_updateBtn;
    @FXML
    private Button addMovies_deleteBtn;
    @FXML
    private Button addMovies_clearBtn;
    @FXML
    private TableView<moviesData> addMovies_tableView;
    @FXML
    private TableColumn<moviesData, String> addMovies_col_movieTitle;
    @FXML
    private TableColumn<moviesData, String> addMovies_col_genre;
    @FXML
    private TableColumn<moviesData, String> addMovies_col_duration;
    @FXML
    private TableColumn<moviesData, String> addMovies_col_showingDate;
    @FXML
    private TextField addMovies_search;
    @FXML
    private AnchorPane availableMovies_form;
    @FXML
    private Button availableMovies_selectMovie;
    @FXML
    private TextField availableMovies_movieTitle;
    @FXML
    private TextField availableMovies_genre;
    @FXML
    private TextField availableMovies_date;
    @FXML
    private ImageView availableMovies_imageView;
    @FXML
    private Label availableMovies_title;
    @FXML
    private TableView<moviesData> availableMovies_tableView;
    @FXML
    private TableColumn<moviesData, String> availableMovies_col_movieTitle;
    @FXML
    private TableColumn<moviesData, String> availableMovies_col_genre;
    @FXML
    private TableColumn<moviesData, String> availableMovies_col_showingDate;
    @FXML
    private Spinner<Integer> availableMovies_specialClass_quantity;
    @FXML
    private Label availableMovies_specialClass_price;
    @FXML
    private Label availableMovies_normalClass_price;
    @FXML
    private Label availableMovies_total;
    @FXML
    private Spinner<Integer> availableMovies_normalClass_quantity;
    @FXML
    private Button availableMovies_clearBtn;
    @FXML
    private Button availableMovies_receiptBtn;
    @FXML
    private Button availableMovies_buyBtn;
    @FXML
    private AnchorPane editScreening_form;
    @FXML
    private ImageView editScreening_imageView;
    @FXML
    private Label editScreening_title;
    @FXML
    private ComboBox<?> editScreening_current;
    @FXML
    private Button editScreening_clearBtn;
    @FXML
    private Button editScreening_updateBtn;
    @FXML
    private TableView<moviesData> editScreening_tableView;
    @FXML
    private TableColumn<moviesData, String> editScreening_col_movieTitle;
    @FXML
    private TableColumn<moviesData, String> editScreening_col_genre;
    @FXML
    private TableColumn<moviesData, String> editScreening_col_duration;
    @FXML
    private TableColumn<moviesData, String> editScreening_col_current;
    @FXML
    private TextField editScreening_searchBtn;
    @FXML
    private AnchorPane customers_form;
    @FXML
    private TextField customers_ticketNumber;
    @FXML
    private TextField customers_movieTitle;
    @FXML
    private TextField customers_totalPayment;
    @FXML
    private TextField customers_date;
    @FXML
    private TextField customers_time;
    @FXML
    private Button customers_clearBtn;
    @FXML
    private Button customers_deleteBtn;
    @FXML
    private TableView<customerData> customers_tableView;
    @FXML
    private TableColumn<customerData, String> customers_col_ticketNumber;
    @FXML
    private TableColumn<customerData, String> customers_col_movieTitle;
    @FXML
    private TableColumn<customerData, String> customers_col_totalPayment;
    @FXML
    private TableColumn<customerData, String> customers_col_timeCheckedOut;
    @FXML
    private TextField customers_search;
    @FXML
    private Label dashboard_totalSoldTicket;
    @FXML
    private DatePicker addMovies_date;
    @FXML
    private AnchorPane topForm;

    /**
     * Initializes the controller class.
     */
    private Image image;

    private double x = 0;
    private double y = 0;

    //DATABASE TOOLS
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    
    //EDIT AVAILABLE MOVIES FORM
    
    public SpinnerValueFactory<Integer> spinner1;
    public SpinnerValueFactory<Integer> spinner2;
    
    private float price1 = 0;
    private float price2 = 0;
    private float total = 0;
    private int qty1 = 0;
    private int qty2 = 0;
    
    
    private int totalMovies;
    public void totalAvailableMovies() {
    
        String sql = "SELECT count(id) FROM movie WHERE Current = 'Showing'";
     
        connect = database.connectDb();
        
        try{
            
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            if(result.next()) {
            
                totalMovies = result.getInt("count(id)");
            
            }
        
        } catch(Exception e) {e.printStackTrace();}
    }
    
    
    public void displayTotalAvailableMovies() {
        totalAvailableMovies();
        dashboard_availableMovies.setText(String.valueOf(totalMovies));

    }
    
    
    private double totalIncome;
    public void totalIncomeToday() {
    
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        
        String sql = "SELECT SUM(total) FROM customer WHERE date = '" 
                + String.valueOf(sqlDate) + "'";
        
        connect = database.connectDb();
        
        try{
            
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            if(result.next()) {
            
                totalIncome = result.getDouble("SUM(total)");
            
            }
        
        } catch(Exception e) {e.printStackTrace();}
    
    }
    
    public void displayTotalIncomeToday() {
    totalIncomeToday();
        dashboard_totalEarn.setText("$" + String.valueOf(totalIncome));
    }
    
    
    private int soldTicket;
    public void countTicket() {
        String sql = "SELECT count(id) FROM customer";
        
        connect = database.connectDb();
        
        try{
            
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            if(result.next()) {
            
                soldTicket = result.getInt("count(id)");
            
            }
        
        } catch(Exception e) {e.printStackTrace();}
    
    }
    
    
    public void displayTotalSoldTicket() {
        countTicket();
        dashboard_totalSoldTicket.setText(String.valueOf(soldTicket));
    }
    
    public ObservableList<customerData> customerList() {
    
        ObservableList<customerData> customerL = FXCollections.observableArrayList();
    
        String sql = "SELECT *  FROM customer";
        
        connect = database.connectDb();
        
        try {
            
            customerData customerD;
            
            prepare = connect.prepareStatement(sql); 
            result = prepare.executeQuery();
            
            while(result.next()) {
            
                customerD = new customerData(result.getInt("id")
                        , result.getString("type")
                        , result.getString("movieTitle")
                        , result.getInt("quantity")
                        , result.getDouble("total")
                        , result.getDate("date")
                        , result.getTime("time"));
                
                customerL.add(customerD);
            }
        
        } catch(Exception e) {e.printStackTrace();}
        
        return customerL;
    }
    
    
    private ObservableList<customerData> custList;
    public void showCustomerList() {
        
        custList = customerList();
        
        customers_col_ticketNumber.setCellValueFactory(new PropertyValueFactory<>("id"));
        customers_col_movieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        customers_col_totalPayment.setCellValueFactory(new PropertyValueFactory<>("total"));
        customers_col_dateCheckedOut.setCellValueFactory(new PropertyValueFactory<>("date"));
        customers_col_timeCheckedOut.setCellValueFactory(new PropertyValueFactory<>("time"));
    
        
        customers_tableView.setItems(custList);
    }
    
    
    
    public void selectCustomerList() {
    
        customerData custD = customers_tableView.getSelectionModel().getSelectedItem();
        int num = customers_tableView.getSelectionModel().getSelectedIndex();
        
        if((num - 1) < -1) {
        
            return;
        }
        
        customers_ticketNumber.setText(String.valueOf(custD.getId()));
        customers_movieTitle.setText(String.valueOf(custD.getTitle()));
        customers_totalPayment.setText(String.valueOf(custD.getTotal()));
        customers_date.setText(String.valueOf(custD.getDate()));
        customers_time.setText(String.valueOf(custD.getTime()));

    
    }
    
    
    public void deleteCustomer() {
        
        String sql = "DELETE FROM customer WHERE id = '"+ customers_ticketNumber.getText() +"'";
    
        connect = database.connectDb();
        
        try {
            
            Alert alert;
            
            statement = connect.createStatement();
            
            if(customers_ticketNumber.getText().isEmpty() 
                    || customers_movieTitle.getText().isEmpty() 
                    || customers_totalPayment.getText().isEmpty()
                    || customers_date.getText().isEmpty()
                    || customers_time.getText().isEmpty()) {
            
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please select the movie first");
                alert.showAndWait();
            
            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to delete " + customers_movieTitle + "?");
                                
                Optional<ButtonType> option = alert.showAndWait();
                
                if(ButtonType.OK.equals(option.get())) {
                    
                    statement.executeUpdate(sql);
                    
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Succesfully deleted!");
                    alert.showAndWait();
                 
                    showCustomerList();
                    clearCustomer(); 
                    
                } else {
                
                    return;
                }
                
              
            }
        
        
        } catch(Exception e) {e.printStackTrace();}
    }
    
    public void clearCustomer() {
        customers_ticketNumber.setText("");
        customers_movieTitle.setText("");
        customers_totalPayment.setText("");
        customers_date.setText("");
        customers_time.setText("");
    }
     
    private int num;
    private int qty;
    
    public void buy() {
        
        String sql = "INSERT INTO customer (type, movieTitle, quantity, total, date, time) VALUES (?,?,?,?,?,?)";
        
        connect = database.connectDb();
        
        String type = "";
        if(price1 > 0 && price2 == 0) {
            type = "Special Class";
        
        } else if(price2 > 0 && price1 == 0) {
            type = "Normal Class";
        } else if(price2 > 0 && price1 > 0) {
            type = "Special & Normal Class";
        }
        
        
        Date date = new Date();
        java.sql.Date setDate = new java.sql.Date(date.getTime());
        try {
            
            LocalTime localTime = LocalTime.now();
            Time time = Time.valueOf(localTime);
            
            qty = qty1 + qty2;
            
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, type);
            prepare.setString(2, availableMovies_title.getText());
            prepare.setString(3, String.valueOf(qty));
            prepare.setString(4, String.valueOf(total));
            prepare.setString(5, String.valueOf(setDate));
            prepare.setString(6, String.valueOf(time));
          
            Alert alert;
            
            if(availableMovies_imageView.getImage() == null 
                    || availableMovies_title.getText().isEmpty()) {
            
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please select the movie first");
                alert.showAndWait(); 
            
            } else if(price1 == 0 && price2 == 0) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please indicate the quantity of ticket you want to purchase!");
                alert.showAndWait();             
            } else {
                prepare.executeUpdate();
                
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully purchase!");
                alert.showAndWait();  
                
                
                String sql1 = "SELECT * FROM customer";
                
                prepare = connect.prepareStatement(sql1);
                result = prepare.executeQuery();
                
                int num = 0;
                
                while(result.next()) {
                
                    num = result.getInt("id");
                
                }
                
                String slq2 = "INSERT INTO customer_info (customer_id, type, movieTitle, total, quantity) VALUES(?,?,?,?,?)";
                
                prepare = connect.prepareStatement(slq2);
                
                prepare.setString(1, String.valueOf(num));
                prepare.setString(2, type);
                prepare.setString(3, availableMovies_title.getText());
                prepare.setString(4, String.valueOf(total));
                prepare.setString(5, String.valueOf(qty));
                prepare.execute();
                
                
                
                clearPurchaseTicketInfo();
            }
        
        }catch(Exception e) {e.printStackTrace();}
    
    }
    
    public void clearPurchaseTicketInfo() {
        
        spinner1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
        spinner2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
        
        availableMovies_specialClass_quantity.setValueFactory(spinner1);        availableMovies_specialClass_quantity.setValueFactory(spinner1);
        availableMovies_normalClass_quantity.setValueFactory(spinner2);
        
        availableMovies_specialClass_price.setText("$0.0");
        availableMovies_normalClass_price.setText("$0.0");
        availableMovies_total.setText("$0.0");
        
        availableMovies_imageView.setImage(null);
        availableMovies_title.setText("");
    }
    
    public void showSpinnerValue() {
    
        spinner1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
        spinner2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
        
        availableMovies_specialClass_quantity.setValueFactory(spinner1);
        availableMovies_normalClass_quantity.setValueFactory(spinner2);
        
        
    }
    
    
    public void getSpinnerValue(MouseEvent event) {
        
        qty1 = availableMovies_specialClass_quantity.getValue();
        qty2 = availableMovies_normalClass_quantity.getValue();
        
        price1 = (qty1 * 25);
        price2 = (qty2 * 10);
        
        total = (price1 + price2);
        
        availableMovies_specialClass_price.setText("$" + String.valueOf(price1));
        availableMovies_normalClass_price.setText("$" + String.valueOf(price2));
    
        availableMovies_total.setText("$" + String.valueOf(total));
    }
    
    
    public ObservableList<moviesData> availableMoviesList() {
    
        ObservableList<moviesData> listAvMovies = FXCollections.observableArrayList();
        
        String sql = "SELECT * FROM movie WHERE current = 'showing'";
        
        connect = database.connectDb();
        
        try {
            
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            moviesData movD;
            
            while(result.next()) {
            
                movD = new moviesData(result.getInt("id")
                        , result.getString("movieTitle")
                        , result.getString("genre")
                        , result.getString("duration")
                        , result.getString("image")
                        , result.getDate("date")
                        , result.getString("current"));
                
                listAvMovies.add(movD);
            
            }
        
        } catch(Exception e) {e.printStackTrace();}
        
        return listAvMovies;
    }
    
    
    private ObservableList<moviesData> availableMoviesList;
    public void showAvailableMovies() {
    
        availableMoviesList = availableMoviesList();
        
        availableMovies_col_movieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        availableMovies_col_genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        availableMovies_col_showingDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        availableMovies_tableView.setItems(availableMoviesList);
    }
    
    public void selectAvailableMovies() {
        
        moviesData movD = availableMovies_tableView.getSelectionModel().getSelectedItem();
        int num = availableMovies_tableView.getSelectionModel().getSelectedIndex();
        
        if((num -1) < -1) {
        
            return;
        
        }
        
        availableMovies_movieTitle.setText(movD.getTitle());
        availableMovies_genre.setText(movD.getGenre());
        availableMovies_date.setText(String.valueOf(movD.getDate()));

        
        getData.path = movD.getImage();
        getData.title = movD.getTitle();
    
    }
    
    
    public void selectMovie() {
        
        Alert alert;
        
        if(availableMovies_movieTitle.getText().isEmpty()
                || availableMovies_genre.getText().isEmpty()
                || availableMovies_date.getText().isEmpty()) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please select the movie first");
            alert.showAndWait();    
        
        
        } else {
        
            String uri = "file:" + getData.path;

            image = new Image(uri, 130, 200, false, true);
            availableMovies_imageView.setImage(image);


            availableMovies_title.setText(getData.title);


            availableMovies_movieTitle.setText("");
            availableMovies_genre.setText("");
            availableMovies_date.setText("");

        
        }
     
    }
    
    
    //EDIT SCREENING
    private String[] currentList = {"Showing", "End Showing"};
    
    public void comboBox() {
        
        List<String> listCurrent = new ArrayList<>();
        
        for(String data: currentList) {
            listCurrent.add(data);
        
        }
        
        ObservableList listC = FXCollections.observableArrayList(listCurrent);
        editScreening_current.setItems(listC);
    }
    
    
   
    public ObservableList<moviesData> editScreeningList() {
        
        ObservableList<moviesData> editsList = FXCollections.observableArrayList();
        
        String sql = "SELECT * FROM movie";
        
        connect = database.connectDb();
        
        try {
            
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            moviesData movD;
            
            while (result.next()) {
                movD = new moviesData(result.getInt("id"),
                    result.getString("movieTitle"),
                    result.getString("genre"), result.getString("duration"),
                    result.getString("image"), result.getDate("date"),
                        result.getString("current"));
                
               
              editsList.add(movD);  
       
                
            }
        
        } catch(Exception e) {e.printStackTrace();}
        return editsList;
    }
    
    
    public void updateEditScreening() {
        
        String sql = "UPDATE movie SET current = '" 
                + editScreening_current.getSelectionModel().getSelectedItem() 
                + "' WHERE movieTitle = '" + editScreening_title.getText()+ "'";
        
        connect = database.connectDb();
        
        try {
            
            statement = connect.createStatement();
            
            Alert alert;
            if(editScreening_title.getText().isEmpty() 
                    || editScreening_imageView.getImage() == null
                    || editScreening_current.getSelectionModel().isEmpty()) {
            
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please select the movie first");
                alert.showAndWait();
            } else {
                
                statement.executeUpdate(sql);
                
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Update!");
                alert.showAndWait();
                
                showEditScreening();
                clearEditScreening();
         
                      
            }
        
        } catch(Exception e) {e.printStackTrace();}
    }
    
    
    public void clearEditScreening(){
    
        editScreening_title.setText("");
        editScreening_imageView.setImage(null);
          
    }
    
    
    public void searchEditScreening() {
    
        FilteredList<moviesData> filter = new FilteredList(editScreeningL, e -> true);
        
        editScreening_searchBtn.textProperty().addListener((observable, oldValue, newValue) -> {
        
            filter.setPredicate(predicateMoviesData -> {
                
                if(newValue.isEmpty() || newValue == null) {
                    return true;
                
                }
                
                String searchKey = newValue.toLowerCase();
                
                
                if (predicateMoviesData.getTitle().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateMoviesData.getGenre().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateMoviesData.getDuration().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateMoviesData.getCurrent().toLowerCase().contains(searchKey)) {
                    return true;
                }
            
            
                return false;
            });
        });
        
        SortedList<moviesData> sortData = new SortedList<> (filter);
        sortData.comparatorProperty().bind(editScreening_tableView.comparatorProperty());
        editScreening_tableView.setItems(sortData);
    
    }
    
    public void selectEditScreening() {
        
        moviesData movD = editScreening_tableView.getSelectionModel().getSelectedItem();
        int num = editScreening_tableView.getSelectionModel().getFocusedIndex();
        
        if((num - 1) < -1) {
            return;
        
        }
        
        String uri = "file:" + movD.getImage();
        image = new Image(uri, 118, 160, false, true);
        editScreening_imageView.setImage(image);
        
        editScreening_title.setText(movD.getTitle());
        
    }
    
    private ObservableList<moviesData> editScreeningL;
    
    public void showEditScreening() {
    
        editScreeningL = editScreeningList();
        
        editScreening_col_movieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        editScreening_col_genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        editScreening_col_duration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        editScreening_col_current.setCellValueFactory(new PropertyValueFactory<>("current"));
        
        editScreening_tableView.setItems(editScreeningL);
    }
    
    
    
    public void searchAddMovies() {
        
        FilteredList<moviesData> filter = new FilteredList<>(listAddMovies, e -> true);
        
        addMovies_search.textProperty().addListener((observable, oldValue, newValue) -> {
            
            filter.setPredicate(predicateMoviesData -> {
            
                if(newValue.isEmpty() || newValue == null) {
                
                    return true;
                }
                
                String keySearch = newValue.toLowerCase();
                
                if(predicateMoviesData.getTitle().toLowerCase().contains(keySearch)) {
                    return true;
                } else if(predicateMoviesData.getGenre().toLowerCase().contains(keySearch)) {
                    return true;
                } else if(predicateMoviesData.getDuration().toLowerCase().contains(keySearch)) {
                    return true;
                } else if(predicateMoviesData.getDate().toString().contains(keySearch)) {
                    return true;
                }
                
                
                return false;
            });
    
        });
        
        SortedList<moviesData> sortData = new SortedList<>(filter);
        sortData.comparatorProperty().bind(addMovies_tableView.comparatorProperty());
                
        addMovies_tableView.setItems(sortData);
    }

    public void importImage() {

        FileChooser open = new FileChooser();
        open.setTitle("Open Image File");
        open.getExtensionFilters().add(new ExtensionFilter("Image File", "*png", "*jpg"));

        Stage stage = (Stage) addMovies_form.getScene().getWindow();
        File file = open.showOpenDialog(stage);

        if (file != null) {

            image = new Image(file.toURI().toString(), 98, 150, false, true);
            addMovies_imageView.setImage(image);

            getData.path = file.getAbsolutePath();
        }

    }

    
    
    
    
    public void movieId() {
        String sql = "SELECT count(id) FROM movie";
         
        connect = database.connectDb();
        
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            if(result.next()) {
                getData.movieId = result.getInt("count(id)");
            }
        
        } catch(Exception e) {e.printStackTrace();}
    }
    
    
    public void insertAddMovies() {

        String sql1 = "SELECT * FROM movie WHERE movieTitle = '" + addMovies_movieTitle.getText() + "'";

        connect = database.connectDb();

        Alert alert;

        try {

            statement = connect.createStatement();
            result = statement.executeQuery(sql1);

            if (result.next()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText(addMovies_movieTitle.getText() + " was already exist!");
                alert.showAndWait();

            } else {
                if (addMovies_movieTitle.getText().isEmpty() 
                        || addMovies_genre.getText().isEmpty() 
                        || addMovies_duration.getText().isEmpty() 
                        || addMovies_imageView.getImage() == null 
                        || addMovies_date.getValue() == null) {

                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Please select the movie first");
                    alert.showAndWait();
                } else {
                    String sql = "INSERT INTO movie (id, movieTitle, genre, duration, image, date, current) VALUES (?,?,?,?,?,?,?)";
                    
                    String uri = getData.path;
                    uri = uri.replace("\\", "\\\\");
                    
                    movieId();
                    
                    String mID = String.valueOf(getData.movieId +1);
                    
                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, mID);
                    prepare.setString(2, addMovies_movieTitle.getText());
                    prepare.setString(3, addMovies_genre.getText());
                    prepare.setString(4, addMovies_duration.getText());
                    prepare.setString(5, uri);
                    prepare.setString(6, String.valueOf(addMovies_date.getValue()));
                    prepare.setString(7, "Showing");

                    prepare.execute();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully add new movie!");
                    alert.showAndWait();
                    clearAddMoviesList();
                    showAddMoviesList();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updateAddMovies() {
        
        String uri = getData.path;
        uri = uri.replace("\\", "\\\\");
        String sql = "UPDATE movie SET movieTitle = '" + addMovies_movieTitle.getText() 
                + "', genre = '" + addMovies_genre.getText()
                + "', duration = '" + addMovies_duration.getText() 
                + "', image = '" + uri 
                + "', date = '" + addMovies_date.getValue() 
                + "' WHERE id = '" + String.valueOf(getData.movieId) + "'";
        
        
        connect = database.connectDb();
        
        try{
            
            statement = connect.createStatement();
            
            Alert alert; 
            
            if (addMovies_movieTitle.getText().isEmpty() 
                    || addMovies_genre.getText().isEmpty() 
                    || addMovies_duration.getText().isEmpty() 
                    || addMovies_imageView.getImage() == null 
                    || addMovies_date.getValue() == null) {
            
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            
            } else {
                statement.executeUpdate(sql);
                
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully update " + addMovies_movieTitle.getText());
                alert.showAndWait();
                
                showAddMoviesList();
                clearAddMoviesList();
           
            }
            
            
        
        
        }catch(Exception e) {e.printStackTrace();}
    }

    
    public void deleteAddMovies() {
        String sql = "DELETE FROM movie WHERE movieTitle = '"
                + addMovies_movieTitle.getText() + "'";
        
        connect = database.connectDb();
        
        try {
            statement = connect.createStatement();
            
            Alert alert;
            if(addMovies_movieTitle.getText().isEmpty()
                    || addMovies_genre.getText().isEmpty()
                    || addMovies_duration.getText().isEmpty()
                    //|| addMovies_date.getValue() == null
                    || addMovies_imageView.getImage() == null) {
            
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please select the movie first");
                alert.showAndWait();
            
            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure to delete " + addMovies_movieTitle.getText() + "?" );
                
                Optional<ButtonType> option = alert.showAndWait();
                
                if(ButtonType.OK.equals(option.get())) {
                    
                    statement.executeUpdate(sql);
                    
                    showAddMoviesList();
                    clearAddMoviesList();
                    
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Succesfully deleted!");
                    alert.showAndWait();
                    
                
                
                } else {
                
                    return;
                }
                
            
            }
        
        } catch(Exception e) {e.printStackTrace();}
    }
    
    public void clearAddMoviesList() {

        addMovies_movieTitle.setText("");
        addMovies_genre.setText("");
        addMovies_duration.setText("");
        addMovies_imageView.setImage(null);
        addMovies_date.setValue(null);

    }

    //database
    public ObservableList<moviesData> addMoviesList() {

        ObservableList<moviesData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM movie";

        connect = database.connectDb();

        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            moviesData movD;

            while (result.next()) {
                movD = new moviesData(result.getInt("id"),
                        result.getString("movieTitle"), 
                        result.getString("genre"), 
                        result.getString("duration"), 
                        result.getString("image"), 
                        result.getDate("date"),
                        result.getString("current")
                );

                listData.add(movD);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listData;
    }

    private ObservableList<moviesData> listAddMovies;

    public void showAddMoviesList() {
        listAddMovies = addMoviesList();

        addMovies_col_movieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        addMovies_col_genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        addMovies_col_duration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        addMovies_col_showingDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        addMovies_tableView.setItems(listAddMovies);
    }

    public void selectAddMoviesList() {
        moviesData movD = addMovies_tableView.getSelectionModel().getSelectedItem();
        int num = addMovies_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;

        }
        
        getData.path = movD.getImage();

        getData.movieId = movD.getId();
        
        addMovies_movieTitle.setText(movD.getTitle());
        addMovies_genre.setText(movD.getGenre());
        addMovies_duration.setText(movD.getDuration());

        String getDate = String.valueOf(movD.getDate());

        
        String uri = "file:" + movD.getImage();

        image = new Image(uri, 98, 150, false, true);
        addMovies_imageView.setImage(image);
        

        
        //addMovies_date.setValue(movD.getDate().toLocalDate());
       

       
        
    }
    
   
    
    public void logout() {

        signOut_btn.getScene().getWindow().hide();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

            Stage stage = new Stage();
            Scene scene = new Scene(root);

            root.setOnMousePressed((MouseEvent event) -> {

                x = event.getSceneX();
                y = event.getSceneY();

            });

            root.setOnMouseDragged((MouseEvent event) -> {

                stage.setX(event.getScreenX() - x);
                stage.setY(event.getScreenY() - y);

            });

            stage.initStyle(StageStyle.TRANSPARENT);

            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void switchForm(ActionEvent event) {

        if (event.getSource() == dashboard_btn) {

            dashboard_form.setVisible(true);
            addMovies_form.setVisible(false);
            availableMovies_form.setVisible(false);
            editScreening_form.setVisible(false);
            customers_form.setVisible(false);

            dashboard_btn.setStyle("-fx-background-color:#A07779;");
            addMovies_btn.setStyle("-fx-background-color:transparent");
            availableMovies_btn.setStyle("-fx-background-color:transparent");
            editScreening_btn.setStyle("-fx-background-color:transparent");
            customers_btn.setStyle("-fx-background-color:transparent");
            
            displayTotalSoldTicket();
            displayTotalIncomeToday();
            displayTotalAvailableMovies();

        } else if (event.getSource() == addMovies_btn) {

            dashboard_form.setVisible(false);
            addMovies_form.setVisible(true);
            availableMovies_form.setVisible(false);
            editScreening_form.setVisible(false);
            customers_form.setVisible(false);

            dashboard_btn.setStyle("-fx-background-color:transparent");
            addMovies_btn.setStyle("-fx-background-color:#A07779;");
            availableMovies_btn.setStyle("-fx-background-color:transparent");
            editScreening_btn.setStyle("-fx-background-color:transparent");
            customers_btn.setStyle("-fx-background-color:transparent");

            showAddMoviesList();
            
        } else if (event.getSource() == availableMovies_btn) {

            dashboard_form.setVisible(false);
            addMovies_form.setVisible(false);
            availableMovies_form.setVisible(true);
            editScreening_form.setVisible(false);
            customers_form.setVisible(false);

            dashboard_btn.setStyle("-fx-background-color:transparent");
            addMovies_btn.setStyle("-fx-background-color:transparent");
            availableMovies_btn.setStyle("-fx-background-color:#A07779;");
            editScreening_btn.setStyle("-fx-background-color:transparent");
            customers_btn.setStyle("-fx-background-color:transparent");
            
            showAvailableMovies();

        } else if (event.getSource() == editScreening_btn) {

            dashboard_form.setVisible(false);
            addMovies_form.setVisible(false);
            availableMovies_form.setVisible(false);
            editScreening_form.setVisible(true);
            customers_form.setVisible(false);

            dashboard_btn.setStyle("-fx-background-color:transparent");
            addMovies_btn.setStyle("-fx-background-color:transparent");
            availableMovies_btn.setStyle("-fx-background-color:transparent");
            editScreening_btn.setStyle("-fx-background-color:#A07779;");
            customers_btn.setStyle("-fx-background-color:transparent");
            
            showEditScreening();

        } else if (event.getSource() == customers_btn) {

            dashboard_form.setVisible(false);
            addMovies_form.setVisible(false);
            availableMovies_form.setVisible(false);
            editScreening_form.setVisible(false);
            customers_form.setVisible(true);

            dashboard_btn.setStyle("-fx-background-color:transparent");
            addMovies_btn.setStyle("-fx-background-color:transparent");
            availableMovies_btn.setStyle("-fx-background-color:transparent");
            editScreening_btn.setStyle("-fx-background-color:transparent");
            customers_btn.setStyle("-fx-background-color:#A07779;");

            showCustomerList();
        }

    }

    public void displayUsername() {

        username.setText(getData.username);
    }

    public void close() {

        System.exit(0);
    }

    public void minimize() {

        Stage stage = (Stage) topForm.getScene().getWindow();
        stage.setIconified(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        displayUsername();
        showAddMoviesList();
        showEditScreening();
        
        comboBox();
        
        showAvailableMovies();
        showSpinnerValue();
        showCustomerList();
        
        displayTotalSoldTicket();
        displayTotalIncomeToday();
        displayTotalAvailableMovies();
    }

}
