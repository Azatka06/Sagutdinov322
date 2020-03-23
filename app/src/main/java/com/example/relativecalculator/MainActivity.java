package com.example.relativecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView outputText;
    Button butC,butPlus,butMinus,butPercent,butMult,butSplit,butEqual,butPlusMinus;
    View root,rootE;
    double tempDigit;
    final String PLUS="plus";
    final String MINUS="minus";
    final String PERCENT="percent";
    final String MULTIPLEX="multiplex";
    final String SPLIT="split";
    String optionSelected="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init(){
        root=findViewById(R.id.root);
        rootE=findViewById(R.id.rootE);

        Button butChange=findViewById(R.id.butChange);
        butChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(root.getVisibility()==View.VISIBLE){
                    root.setVisibility(View.GONE);
                    rootE.setVisibility(View.VISIBLE);
                }else{
                    root.setVisibility(View.VISIBLE);
                    rootE.setVisibility(View.GONE);
                }
            }
        });
        outputText=findViewById(R.id.outputView);
        butC=findViewById(R.id.butC);
        butPlus=findViewById(R.id.butPlus);
        butMinus=findViewById(R.id.butMinus);
        butMult=findViewById(R.id.butMultiplex);
        butSplit=findViewById(R.id.butSplit);
        butEqual=findViewById(R.id.butEqual);
        butPercent=findViewById(R.id.butPercent);
        butPlusMinus=findViewById(R.id.butPlusMinus);

        butPlusMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outputText.setText(String.valueOf((
                        -1*Double.valueOf(outputText.getText().toString()))));
            }
        });

        butPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempDigit=Double.valueOf(outputText.getText().toString());
                outputText.setText("");
                optionSelected=PLUS;
            }
        });

        butMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempDigit=Double.valueOf(outputText.getText().toString());
                outputText.setText("");
                optionSelected=MINUS;
            }
        });

        butPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempDigit=Double.valueOf(outputText.getText().toString());
                outputText.setText("");
                optionSelected=PERCENT;
            }
        });

        butMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempDigit=Double.valueOf(outputText.getText().toString());
                outputText.setText("");
                optionSelected=MULTIPLEX;
            }
        });

        butSplit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempDigit=Double.valueOf(outputText.getText().toString());
                outputText.setText("");
                optionSelected=SPLIT;
            }
        });

        butEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!optionSelected.equals("")) {
                    double secondDigit = Double.valueOf(outputText.getText().toString());
                    switch (optionSelected) {
                        case PLUS: {
                            outputText.setText(String.valueOf(tempDigit +secondDigit));
                            break;
                        }
                        case MINUS: {
                            outputText.setText(String.valueOf(tempDigit -secondDigit));
                            break;
                        }
                        case PERCENT: {
                            outputText.setText(String.valueOf(tempDigit / 100 *secondDigit));
                            break;
                        }
                        case MULTIPLEX: {
                            outputText.setText(String.valueOf(tempDigit * secondDigit));
                            break;
                        }
                        case SPLIT: {
                            if(secondDigit==0){
                                Toast.makeText(MainActivity.this,
                                        "Error, zero split unposible",Toast.LENGTH_LONG).show();
                            }else {
                                outputText.setText(String.valueOf(tempDigit / secondDigit));
                            }
                            break;
                        }
                    }
                }
            }
        });
        butC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optionSelected="";
                outputText.setText("");
            }
        });

    }

    public void btnPress(View view) {
        Button btn = (Button) view;
        outputText.append(btn.getText());
    }

}
