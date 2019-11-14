package com.example.ordenums;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity
{
    EditText etIngresa;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etIngresa = findViewById(R.id.etIngresa);
        btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener()
        {
            int[] arreglo = new int[5];
            int clicks = -1;

            public void onClick(View v)
            {
                if(etIngresa.length() != 0)
                {
                    int n = Integer.parseInt(etIngresa.getText().toString());
                    if(n >= -9999 && n <= 9999)
                    {
                        clicks += 1;
                        arreglo[clicks] = n;
                        Toast.makeText(MainActivity.this, Arrays.toString(arreglo), Toast.LENGTH_SHORT).show();
                        if (clicks == arreglo.length-1)
                        {
                            clicks = -1;
                            ordenaArreglo(arreglo);
                            Toast.makeText(MainActivity.this, MainActivity.this.getString(R.string.Ordenado)+Arrays.toString(arreglo), Toast.LENGTH_LONG).show();
                            Arrays.fill(arreglo,0);
                        }
                        etIngresa.getText().clear();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, getApplicationContext().getString(R.string.PosNeg), Toast.LENGTH_SHORT).show();
                    }


                }
                else
                {
                    Toast.makeText(MainActivity.this, getApplicationContext().getString(R.string.FaltaNum), Toast.LENGTH_LONG).show();
                }
            }

        });
    }

    private void ordenaArreglo(int [] arr)
    {
        //Ordenamiento Burbuja
       boolean cambio = true;
       int i = 0, aux;
       while (cambio)
       {
           cambio = false;
           i += 1;
           for(int j=0 ; j < arr.length-i ; j++)
           {
                if(arr[j] > arr[j+1])
                {
                    cambio = true;
                    aux = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = aux;
                }
           }
       }
    }
}
