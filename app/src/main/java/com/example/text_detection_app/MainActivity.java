package com.example.text_detection_app;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.mlkit.vision.text.TextRecognition;
import com.google.mlkit.vision.text.TextRecognizer;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.text.Text;
import com.google.mlkit.vision.text.latin.TextRecognizerOptions; // Use this for Latin-based text
import java.util.List;
import com.google.android.gms.tasks.OnSuccessListener;





public class MainActivity extends AppCompatActivity {

    //creating variables for our imageview, button and textview
    private ImageView imageview;
    private Button snapbtn, detectbtn;
    private TextView text;

    //variable for our image bitmap
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //initializing our variables
        imageview = findViewById(R.id.image);
        snapbtn = findViewById(R.id.snapbtn);
        detectbtn = findViewById(R.id.detectbtn);
        text = findViewById(R.id.text);
        TextView Note1=findViewById(R.id.lbl1);
        TextView Note2=findViewById(R.id.lbl2);

        detectbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //calling detect text method
                detectText();
            }
        });

        snapbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Note1.setVisibility(View.GONE);
                Note2.setVisibility(View.GONE);
                //method to capture out image
                captureImage();
                text.setMaxHeight(900);
            }

        });


    }

    static final int REQUEST_IMAGE_CAPTURE = 1;

    private void captureImage()
    {
        // in the method we are displaying an intent to capture our image.
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        // on below line we are calling a start activity
        // for result method to get the image captured.
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // calling on activity result method.
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            // on below line we are getting
            // data from our bundles. .
            Bundle extras = data.getExtras();
            bitmap = (Bitmap) extras.get("data");

            // below line is to set the
            // image bitmap to our image.
            imageview.setImageBitmap(bitmap);
        }
    }

    private void detectText() {
        // Ensure you have an image before trying to detect text
        if (bitmap == null) {
            Toast.makeText(this, "Please snap a photo first", Toast.LENGTH_SHORT).show();
            return;
        }

        // 1. Create an InputImage object from your Bitmap
        InputImage image = InputImage.fromBitmap(bitmap, 0);

        // 2. Get an instance of the TextRecognizer
        TextRecognizer recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS);

        // 3. Process the image
        recognizer.process(image)
                .addOnSuccessListener(new OnSuccessListener<Text>() {
                    @Override
                    public void onSuccess(Text visionText) {
                        // Task completed successfully, process the text
                        processTxt(visionText);
                    }
                })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                // Task failed with an exception
                                Toast.makeText(MainActivity.this, "Failed to detect text: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
    }

    private void processTxt(Text result) {
        String resultText = result.getText();
        if (resultText.isEmpty()) {
            Toast.makeText(MainActivity.this, "No Text Detected", Toast.LENGTH_LONG).show();
            return;
        }
        // Set the entire detected text to the TextView
        text.setText(resultText);

    /*
    // Optional: If you want to process by blocks
    for (Text.TextBlock block : result.getTextBlocks()) {
        String blockText = block.getText();
        // You could append text here if you wanted all blocks
        // textView.append(blockText + "\n");
    }
    */
    }

}