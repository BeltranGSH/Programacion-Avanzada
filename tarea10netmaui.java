package cordi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class WeatherData {
    String condition;
    double temperature;
    double humidity;
    double precipitation;
    double wind;

    public WeatherData(String condition, double temperature, double humidity, double precipitation, double wind) {
        this.condition = condition;
        this.temperature = temperature;
        this.humidity = humidity;
        this.precipitation = precipitation;
        this.wind = wind;
    }
}

public class tarea10netmaui extends JFrame {

    private JLabel lblCondition, lblTemperature, lblHumidity, lblPrecipitation, lblWind;
    private JButton btnRefresh;
    private JTextField txtPostalCode;

    public tarea10netmaui() {
        setTitle("Weather Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        txtPostalCode = new JTextField();
        lblCondition = new JLabel("Condition");
        lblTemperature = new JLabel("Temperature");
        lblHumidity = new JLabel("Humidity");
        lblPrecipitation = new JLabel("Precipitation");
        lblWind = new JLabel("Wind");

        btnRefresh = new JButton("Refresh");

        add(new JLabel("Postal Code:"));
        add(txtPostalCode);
        add(lblCondition);
        add(lblTemperature);
        add(lblHumidity);
        add(lblPrecipitation);
        add(lblWind);
        add(btnRefresh);

        btnRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String postalCode = txtPostalCode.getText();
                WeatherData weatherData = getWeather(postalCode);

                updateUI(weatherData);
            }
        });
    }

    private WeatherData getWeather(String postalCode) {
        
        return new WeatherData("Sunny", 25.0, 60.0, 0.0, 15.0);
    }

    private void updateUI(WeatherData weatherData) {
       
        lblCondition.setText("Condition: " + weatherData.condition);
        lblTemperature.setText("Temperature: " + weatherData.temperature + " °C");
        lblHumidity.setText("Humidity: " + weatherData.humidity + " %");
        lblPrecipitation.setText("Precipitation: " + weatherData.precipitation + " mm");
        lblWind.setText("Wind: " + weatherData.wind + " km/h");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                tarea10netmaui app = new tarea10netmaui();
                app.setVisible(true);
            }
        });
    }
}
