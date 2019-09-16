package com.example.jouleqr;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class GenerateQR extends AppCompatActivity {

    private EditText text;
    private Button generate;
    private ImageView barcode;
    private String user_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_qr);

        text=findViewById(R.id.text);
        generate=findViewById(R.id.generate);
        barcode=findViewById(R.id.barcode);





        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user_text=text.getText().toString();

                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                try {
                    if(user_text.isEmpty()) {
                        System.out.println("empty");
                    }
                    else{
                        System.out.println(user_text);
                    }

                    BitMatrix bitMatrix = multiFormatWriter.encode(user_text, BarcodeFormat.DATA_MATRIX.QR_CODE,200,200);
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                    barcode.setImageBitmap(bitmap);
                } catch (WriterException e) {
                    e.printStackTrace();
                }

            }
        });
    }

}
