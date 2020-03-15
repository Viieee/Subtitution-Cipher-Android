package com.example.subtitutioncipher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public static final String str = "abcdefghijklmnopqrstuvwxyz";
    private EditText iText,iKey;
    private TextView output;
    private Button enc,dec;
    private int k;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iText = findViewById(R.id.inputText);
        iKey = findViewById(R.id.inputKey);
        enc = findViewById(R.id.buttonEncrypt);
        dec = findViewById(R.id.buttonDecrypt);
        output = findViewById(R.id.output);
        dec.setVisibility(dec.INVISIBLE);
        output.setVisibility(output.INVISIBLE);

    }

    public static String encrypt(String input, int key){
        input=input.toLowerCase();
        String cipher="";
        for (int i=0;i<input.length();i++){ //mengecek posisi dari char pada string yang diinputkan
                                            //dan menjadi argumen
            int posisiChar = str.indexOf(input.charAt(i));
            int keyValue = (posisiChar+key)%26;
            char charPengganti = str.charAt(keyValue);
            cipher=cipher+charPengganti;
        }
        return cipher;
    }

    public static String decrypt(String input, int key){
        input=input.toLowerCase();
        String cipher="";
        for (int i=0;i<input.length();i++){ //mengecek posisi dari char pada string yang diinputkan
            //dan menjadi argumen
            int posisiChar = str.indexOf(input.charAt(i));
            int keyValue = (posisiChar-key)%26;
            if (keyValue<0){
                keyValue = str.length()+keyValue;
            }
            char charPengganti = str.charAt(keyValue);
            cipher=cipher+charPengganti;
        }
        return cipher;
    }

    public void encr(View view) {
        dec.setVisibility(dec.VISIBLE);
        output.setVisibility(output.VISIBLE);
        k = Integer.parseInt(iKey.getText().toString());
        output.setText(encrypt(iText.getText().toString(),k));
        iText.setText("");
        iKey.setText("");
    }

    public void decr(View view) {
        dec.setVisibility(dec.INVISIBLE);
        output.setText(decrypt(output.getText().toString(),k));
    }
}
