package com.example.quantitymeasurement;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner Spinner1, fromUnitSpinner, toUnitSpinner;
    String selectedClass, fromUnit, toUnit;
    private EditText input;
    private Button button;
    private TextView result;



    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner1 = (Spinner) findViewById(R.id.Spinner1);
        fromUnitSpinner = (Spinner) findViewById(R.id.fromUnitSpinner);
        toUnitSpinner = (Spinner) findViewById(R.id.toUnitSpinner);
         button = (Button) findViewById(R.id.convertBtn);
        input = (EditText) findViewById(R.id.firstInputEditText);
        result = (TextView) findViewById(R.id.convertedTextView);
        Spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedClass = parent.getItemAtPosition(position).toString();
                switch (selectedClass) {
                    case "Weight":
                        // assigning div item list defined in XML to the div Spinner
                        fromUnitSpinner.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.WeightUnits)));
                        toUnitSpinner.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.WeightUnits)));

                        break;

                    case "Length":
                        fromUnitSpinner.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.LengthUnits)));

                        toUnitSpinner.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.LengthUnits)));
                        break;

                    case "Volume":
                        fromUnitSpinner.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.VolumeUnits)));

                        toUnitSpinner.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.VolumeUnits)));
                        break;

                    case "Temperature":
                        fromUnitSpinner.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.TemperatureUnits)));
                        toUnitSpinner.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.TemperatureUnits)));
                        break;
                }

                //set divSpinner Visibility to Visible
                Spinner1.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // can leave this empty
            }
        });

        fromUnitSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fromUnit = parent.getItemAtPosition(position).toString();
                /*
                    Now that we have both values, lets create a Toast to
                    show the values on screen
                */
                Toast.makeText(MainActivity.this, "\n Class: \t " + selectedClass +
                        "\n Div: \t" + fromUnit, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // can leave this empty
            }

        });

        toUnitSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                toUnit = parent.getItemAtPosition(position).toString();
                /*
                    Now that we have both values, lets create a Toast to
                    show the values on screen
                */
                Toast.makeText(MainActivity.this, "\n Class: \t " + selectedClass +
                        "\n Div: \t" + toUnit, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // can leave this empty
            }

        });
        button.setOnClickListener(v -> {

                    int k = 1000;
                    double t=0.001;
                    double tonn = 0.000001;
                    int mega=1000000;
                    double c=1.8;
                    double f=0.555;
                    int inputValue = Integer.parseInt(input.getText().toString());
                    if (input.getText().toString().equals("")) {

                        result.setText(R.string.error_message);
                        result.setTextColor(Color.RED);

                    } else if (fromUnit.equals("Kilogram") && toUnit.equals("Kilogram")) {
                        result.setText(String.format("%d", inputValue));

                    } else if (fromUnit.equals("Kilogram") && toUnit.equals("Gram"))
                    {
                        int g = inputValue * k;
                        result.setText(String.format("%d", g));
                    }
                    else if (fromUnit.equals("Kilogram") && toUnit.equals("Ton"))
                    {
                        Double ton = inputValue * t;
                        result.setText(String.format("%f", ton));
                    }
                    else if (fromUnit.equals("Gram") && toUnit.equals("Ton"))
                    {
                        Double gram = inputValue * tonn;
                        result.setText(String.format("%f", gram));
                    }
                    else if (fromUnit.equals("Ton") && toUnit.equals("Ton"))
                    {
                        result.setText(String.format("%d", inputValue));
                    }
                    else if (fromUnit.equals("Gram") && toUnit.equals("Kilogram"))
                    {
                        Double kilo = inputValue * t;
                        result.setText(String.format("%f", kilo));
                    }
                    else if (fromUnit.equals("Gram") && toUnit.equals("Gram"))
                    {
                        result.setText(String.format("%d", inputValue));
                    }
                    else if (fromUnit.equals("Ton") && toUnit.equals("Gram"))
                    {
                        int ton = inputValue * mega;
                        result.setText(String.format("%d", ton));
                    }
                    else if (fromUnit.equals("Ton") && toUnit.equals("Kilogram"))
                    {
                        int ton = inputValue *k;
                        result.setText(String.format("%d", ton));
                    }
                    else if (fromUnit.equals("Liter") && toUnit.equals("Liter"))
                    {
                        result.setText(String.format("%d", inputValue));
                    }
                    else if (fromUnit.equals("Liter") && toUnit.equals("Milliliter"))
                    {
                        int ton = inputValue *k;
                        result.setText(String.format("%d", ton));
                    }
                    else if (fromUnit.equals("Milliliter") && toUnit.equals("Liter"))
                    {
                        double ton = inputValue *t;
                        result.setText(String.format("%f", ton));
                    }
                    else if (fromUnit.equals("Milliliter") && toUnit.equals("Milliliter"))
                    {
                        result.setText(String.format("%d", inputValue));
                    }
                    else if (fromUnit.equals("Centigrade") && toUnit.equals("Centigrade"))
                    {
                        result.setText(String.format("%d", inputValue));
                    }
                    else if (fromUnit.equals("Centigrade") && toUnit.equals("Farehn"))
                    {
                        double farehn=c*inputValue;
                        double ton = farehn+32;
                        result.setText(String.format("%f", ton));
                    }
                    else if (fromUnit.equals("Farehn") && toUnit.equals("Centigrade"))
                    {
                        double centi = inputValue-32;
                        double ton=centi*f;
                        result.setText(String.format("%f", ton));
                    }
                    else if (fromUnit.equals("Farehn") && toUnit.equals("Farehn"))
                    {
                        result.setText(String.format("%d", inputValue));
                    }
                    else if (fromUnit.equals("Kilometer") && toUnit.equals("Kilometer"))
                    {
                        result.setText(String.format("%d", inputValue));

                    }
                    else if (fromUnit.equals("Kilometer") && toUnit.equals("Meter"))
                    {
                        int ton = inputValue *k;
                        result.setText(String.format("%d", ton));
                    }
                    else if (fromUnit.equals("Kilometer") && toUnit.equals("Inch"))
                    {
                        double ton = inputValue *3280.84;
                        result.setText(String.format("%f", ton));
                    }
                    else if (fromUnit.equals("Kilometer") && toUnit.equals("Feet"))
                    {
                        double ton = inputValue *39370.1;
                        result.setText(String.format("%f", ton));
                    }
                    else if (fromUnit.equals("Meter") && toUnit.equals("Meter"))
                    {
                        result.setText(String.format("%d", inputValue));

                    }
                    else if (fromUnit.equals("Meter") && toUnit.equals("Kilometer"))
                    {
                        double ton = inputValue *t;
                        result.setText(String.format("%f", ton));
                    }
                    else if (fromUnit.equals("Meter") && toUnit.equals("Inch"))
                    {
                        double ton = inputValue *39.370;
                        result.setText(String.format("%f", ton));
                    }
                    else if (fromUnit.equals("Meter") && toUnit.equals("Feet"))
                    {
                        double ton = inputValue *3.280;
                        result.setText(String.format("%f", ton));
                    }
                    else if (fromUnit.equals("Inch") && toUnit.equals("Inch"))
                    {
                        result.setText(String.format("%d", inputValue));

                    }
                    else if (fromUnit.equals("Inch") && toUnit.equals("Kilometer"))
                    {
                        double ton = inputValue *2.54e-5;
                        result.setText(String.format("%f", ton));
                    }
                    else if (fromUnit.equals("Inch") && toUnit.equals("Feet"))
                    {
                        double ton = inputValue *0.0833;
                        result.setText(String.format("%f", ton));
                    }
                    else if (fromUnit.equals("Inch") && toUnit.equals("Meter"))
                    {
                        double ton = inputValue *0.0254;
                        result.setText(String.format("%f", ton));
                    }
                    else if (fromUnit.equals("Feet") && toUnit.equals("Inch"))
                    {
                        int ton = inputValue *12;
                        result.setText(String.format("%d", ton));
                    }else if (fromUnit.equals("Feet") && toUnit.equals("Feet"))
                    {
                        result.setText(String.format("%d", inputValue));

                    }else if (fromUnit.equals("Feet") && toUnit.equals("Kilometer"))
                    {
                        double ton = inputValue *0.000304;
                        result.setText(String.format("%f", ton));
                    }else if (fromUnit.equals("Feet") && toUnit.equals("Meter"))
                    {
                        double ton = inputValue *0.304;
                        result.setText(String.format("%f", ton));
                    }
                    else{

                    }




            //int inputValue = Integer.parseInt(input.getText().toString());
                //int g = inputValue * k;
                //result.setText(String.format("%d", g));



        });




    }
}