package kr.ac.kopo.project4_1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    Button btn1, btn2, btn3, btn4, btn5;
    TextView text1;
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

        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        text1 = findViewById(R.id.text1);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);

        btn1.setOnClickListener(btnListener);
        btn2.setOnClickListener(btnListener);
        btn3.setOnClickListener(btnListener);
        btn4.setOnClickListener(btnListener);
        btn5.setOnClickListener(btnListener);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button eBtn = (Button) v;
            String str1 = edit1.getText().toString();
            String str2 = edit2.getText().toString();
            if(str1.equals("") || str2.equals("")) {
                Toast.makeText(getApplicationContext(), "숫자가 입력되지 않았습니다.", Toast.LENGTH_SHORT).show();
                return;
            }
            double inputNum1 = Double.parseDouble(str1);
            double inputNum2 = Double.parseDouble(str2);
            double result = 0;

            if(eBtn == btn1) {
                result = inputNum1 + inputNum2;
            } else if(eBtn == btn2) {
                result = inputNum1 - inputNum2;
            } else if(eBtn == btn3) {
                if(inputNum2 == 0) {
                    Toast.makeText(getApplicationContext(), "0으로 나누면 안됩니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                result = inputNum1 / inputNum2;
            } else if(eBtn == btn4) {
                result = inputNum1 * inputNum2;
            } else {
                if(inputNum2 == 0) {
                    Toast.makeText(getApplicationContext(), "0으로 나누면 안됩니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                result = inputNum1 % inputNum2;
            }

            text1.setText(String.format("계산결과: %.3f", result));
        }
    };
}