module swt.group.tiktaktoe {
    requires javafx.controls;
    requires javafx.fxml;


    opens swt.group.tiktaktoe to javafx.fxml;
    exports swt.group.tiktaktoe;
}