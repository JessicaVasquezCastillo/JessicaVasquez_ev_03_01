package chile.maps.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

public class Mqtt_act extends AppCompatActivity {

    //Declaración de Variables para establecer la conexión

    static String MQTTHOST = "tcp://tailor.cloudmqtt.com:12883";
    static String USERNAME = "xbhehswd";
    static String PASSWORD = "bbbfm_sZeBcV";
    String topicStr = "LIBROS";
    MqttAndroidClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mqtt_act);

        String clientId = MqttClient.generateClientId();
        client = new MqttAndroidClient(this.getApplicationContext(), MQTTHOST, clientId);
        MqttConnectOptions options = new MqttConnectOptions();
        options.setUserName(USERNAME);
        options.setPassword(PASSWORD.toCharArray());

        try {
            IMqttToken token = client.connect(options);
            token.setActionCallback(new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    // We are connected
                    Toast.makeText(getBaseContext(), "Conectado..", Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    // Something went wrong e.g. connection timeout or firewall problems
                    Toast.makeText(getBaseContext(), "Sin Conexión", Toast.LENGTH_LONG).show();

                }
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void BtnREVIVAL (View v)
    {
        String topic = topicStr;
        String message = "REVIVAL";
        try {
            client.publish(topic, message.getBytes(), 0, false);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void BtnFARENHEITH (View v)
    {
        String topic = topicStr;
        String message = "FARENHEITH";
        try {
            client.publish(topic, message.getBytes(), 0, false);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void BtnELALQUIMISTA (View v)
    {
        String topic = topicStr;
        String message = "EL ALQUIMISTA";
        try {
            client.publish(topic, message.getBytes(), 0, false);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void BtnELPODER (View v)
    {
        String topic = topicStr;
        String message = "EL PODER";
        try {
            client.publish(topic, message.getBytes(), 0, false);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void BtnELDESPERTAR (View v)
    {
        String topic = topicStr;
        String message = "EL DESPERTAR";
        try {
            client.publish(topic, message.getBytes(), 0, false);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}