package chile.maps.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Github_act extends AppCompatActivity {

    private Spinner sp1;
    private TextView tv1;
    private String[] precios = new String[]{"7000", "22000", "45000"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github_act);

        sp1 = (Spinner)findViewById(R.id.spinner);
        tv1 = (TextView)findViewById(R.id.resultado);

        Bundle dat = getIntent().getExtras();
        String[] list = dat.getStringArray("libros");

        ArrayAdapter adapt = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, list);

        sp1.setAdapter(adapt);


        if (sp1.getSelectedItem().equals("Farenheit")) {
            String precio = precios[0];
            tv1.setText("El valor de Farenheit es: " + precio);
        }
        else if (sp1.getSelectedItem().equals("Revival")) {
            String precio = precios[1];
            tv1.setText("El valor de Revival es: " + precio);
        }
        else if (sp1.getSelectedItem().equals("El Alquimista")) {
            String precio = precios[2];
            tv1.setText("El valor de El Alquimista es: " + precio);
        }

    }

}
