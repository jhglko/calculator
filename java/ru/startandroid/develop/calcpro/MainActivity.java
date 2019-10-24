package ru.startandroid.develop.calcpro;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Build;
import java.util.ArrayList;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    TextView textinfo;
    EditText value;
    double valueResult, valueOne, valueTwo;
    String his;
    char CURRENT_ACTION, CURRENT_ACTION_TWO;
    boolean mode;
    ArrayList<String> history = new ArrayList<String>();
    Button b_0, b_1, b_2, b_3, b_4, b_5, b_6, b_7, b_8, b_9, b_pl, b_min, b_umn, b_del, b_res, b_clear, b_lg, b_tan, b_sin, b_cos, b_x2, b_cor, b_left, b_right, b_delete, b_proc, b_p, b_toc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textinfo = (TextView)findViewById(R.id.t_history);
        valueResult = valueOne = valueTwo = Double.NaN;
        b_0 = (Button)findViewById(R.id.b_0);
        b_1 = (Button)findViewById(R.id.b_1);
        b_2 = (Button)findViewById(R.id.b_2);
        b_3 = (Button)findViewById(R.id.b_3);
        b_4 = (Button)findViewById(R.id.b_4);
        b_5 = (Button)findViewById(R.id.b_5);
        b_6 = (Button)findViewById(R.id.b_6);
        b_7 = (Button)findViewById(R.id.b_7);
        b_8 = (Button)findViewById(R.id.b_8);
        b_9 = (Button)findViewById(R.id.b_9);
        b_pl = (Button)findViewById(R.id.b_pl);
        b_min = (Button)findViewById(R.id.b_min);
        b_umn = (Button)findViewById(R.id.b_umn);
        b_del = (Button)findViewById(R.id.b_del);
        b_res = (Button)findViewById(R.id.b_res);
        b_clear = (Button)findViewById(R.id.b_clear);
        b_lg = (Button)findViewById(R.id.b_lg);
        b_tan = (Button)findViewById(R.id.b_tan);
        b_sin = (Button)findViewById(R.id.b_sin);
        b_cos = (Button)findViewById(R.id.b_cos);
        b_x2 = (Button)findViewById(R.id.b_x2);
        b_cor = (Button)findViewById(R.id.b_cor);
        b_left = (Button)findViewById(R.id.b_left);
        b_right = (Button)findViewById(R.id.b_right);
        b_delete = (Button)findViewById(R.id.b_delete);
        b_proc = (Button)findViewById(R.id.b_proc);
        b_p = (Button)findViewById(R.id.b_p);
        b_toc = (Button)findViewById(R.id.b_toc);
        value = (EditText)findViewById(R.id.t_view);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            value.setShowSoftInputOnFocus(false);
        } else {
            value.setTextIsSelectable(true);
        }

        b_0.setOnClickListener(this);
        b_1.setOnClickListener(this);
        b_2.setOnClickListener(this);
        b_3.setOnClickListener(this);
        b_4.setOnClickListener(this);
        b_5.setOnClickListener(this);
        b_6.setOnClickListener(this);
        b_7.setOnClickListener(this);
        b_8.setOnClickListener(this);
        b_9.setOnClickListener(this);
        b_pl.setOnClickListener(this);
        b_min.setOnClickListener(this);
        b_umn.setOnClickListener(this);
        b_del.setOnClickListener(this);
        b_res.setOnClickListener(this);
        b_clear.setOnClickListener(this);
        if(getResources().getConfiguration().orientation == 2){
            b_lg.setOnClickListener(this);
            b_tan.setOnClickListener(this);
            b_sin.setOnClickListener(this);
            b_cos.setOnClickListener(this);
            b_x2.setOnClickListener(this);
            b_cor.setOnClickListener(this);
            b_left.setOnClickListener(this);
            b_right.setOnClickListener(this);
            b_delete.setOnClickListener(this);
            b_proc.setOnClickListener(this);
            b_p.setOnClickListener(this);
            b_toc.setOnClickListener(this);
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        history = savedInstanceState.getStringArrayList("history");
        getHistory();
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("history", history);
    }

    private boolean checkValue(){
        if(value.getText().toString().length() != 0)
            return true;
        return false;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.b_0: {value.setText(value.getText() + "0");} break;
            case R.id.b_1: {value.setText(value.getText() + "1");} break;
            case R.id.b_2: {value.setText(value.getText() + "2");} break;
            case R.id.b_3: {value.setText(value.getText() + "3");} break;
            case R.id.b_4: {value.setText(value.getText() + "4");} break;
            case R.id.b_5: {value.setText(value.getText() + "5");} break;
            case R.id.b_6: {value.setText(value.getText() + "6");} break;
            case R.id.b_7: {value.setText(value.getText() + "7");} break;
            case R.id.b_8: {value.setText(value.getText() + "8");} break;
            case R.id.b_9: {value.setText(value.getText() + "9");} break;
            case R.id.b_pl: {
                if(checkValue()) {
                    preCalc();
                    CURRENT_ACTION = '+';
                    value.setText("");
                }
            }
            break;
            case R.id.b_min: {
                if(checkValue()) {
                    preCalc();
                    CURRENT_ACTION = '-';
                    value.setText("");
                }
            }
            break;
            case R.id.b_umn: {
                if(checkValue()) {
                    preCalc();
                    CURRENT_ACTION = '*';
                    value.setText("");
                }
            }
            break;
            case R.id.b_del: {
                if(checkValue()) {
                    preCalc();
                    CURRENT_ACTION = '/';
                    value.setText("");
                }
            }
            break;
            case R.id.b_res: {
                if(checkValue()) {
                    preCalc();
                    value.setText(Double.toString(valueResult));
                    getHistory();
                    valueResult = valueOne = valueTwo = Double.NaN;
                }
            }
            break;
            case R.id.b_clear: {
                value.setText("");
                valueResult = valueOne = valueTwo = Double.NaN;
            }
            break;
            case R.id.b_lg: {
                if(checkValue()) {
                    preCalc();
                    CURRENT_ACTION = 'l';
                }
            }
            break;
            case R.id.b_tan: {
                if(checkValue()) {
                    preCalc();
                    CURRENT_ACTION = 't';
                }
            }
            break;
            case R.id.b_sin: {
                if(checkValue()) {
                    preCalc();
                    CURRENT_ACTION = 's';
                }
            }
            break;
            case R.id.b_cos: {
                if(checkValue()) {
                    preCalc();
                    CURRENT_ACTION = 'c';
                }
            }
            break;
            case R.id.b_x2: {
            }
            break;
            case R.id.b_cor: {
                if(checkValue()) {
                    preCalc();
                    CURRENT_ACTION = 'q';
                }
            }
            break;
            case R.id.b_left: {
                CURRENT_ACTION_TWO = CURRENT_ACTION;
                CURRENT_ACTION = '0';
                valueTwo = valueOne;
                valueOne = valueResult = Double.NaN;
            } break;
            case R.id.b_right: {
                if(checkValue()) {
                    preCalc();
                    CURRENT_ACTION = CURRENT_ACTION_TWO;
                    valueOne = valueTwo;
                    value.setText(Double.toString(valueResult));
                }
            } break;
            case R.id.b_delete: {
                value.setText(value.getText().toString().substring(0, value.getText().toString().length() - 1));
            }
            break;
            case R.id.b_proc: {
                if(checkValue()) {
                    preCalc();
                    CURRENT_ACTION = '%';
                    value.setText("");
                }
            }
            break;
            case R.id.b_p: {
                value.setText("3.14159265");
            }
            break;
            case R.id.b_toc: {
                if(checkValue())
                    value.setText(value.getText().toString().replace(".", "") + ".");
                else
                    value.setText("0.");
            }
            break;
            default:
                value.setText(value.getText());
        }
    }

    private void getHistory(){
        his = "";
        for(int i = 0; i < history.size(); i++){
            his += history.get(i) + "\r\n";
        }
        textinfo.setText(his);
    }

    private boolean checkValOne(){
        if(Double.isNaN(valueOne)){
            valueOne = Double.parseDouble(value.getText().toString());
            return true;
        }
        return false;
    }

    public void preCalc(){
        switch (CURRENT_ACTION) {
            case '+': {
                if(!checkValOne()) {
                    valueResult = valueOne + Double.parseDouble(value.getText().toString());
                    history.add(String.valueOf(valueOne) + " + " + Double.parseDouble(value.getText().toString()) + " = " + valueResult);
                    valueOne = valueResult;
                }
            }
            break;

            case '-': {
                if(!checkValOne()) {
                    valueResult = valueOne - Double.parseDouble((value.getText().toString()));
                    history.add(String.valueOf(valueOne) + " - " + Double.parseDouble(value.getText().toString()) + " = " + valueResult);
                    valueOne = valueResult;
                }
            }
            break;

            case '*': {
                if(!checkValOne()) {
                    valueResult = valueOne * Double.parseDouble((value.getText().toString()));
                    history.add(String.valueOf(valueOne) + " * " + Double.parseDouble(value.getText().toString()) + " = " + valueResult);
                    valueOne = valueResult;
                }
            }
            break;

            case '/': {
                if(!checkValOne()) {
                    valueResult = valueOne / Double.parseDouble((value.getText().toString()));
                    history.add(String.valueOf(valueOne) + " / " + Double.parseDouble(value.getText().toString()) + " = " + valueResult);
                    valueOne = valueResult;
                }
            } break;

            case 'l': {
                if(!checkValOne()) {
                    valueResult = Math.log10(valueOne);
                    history.add("log10(" + String.valueOf(valueOne) + ") = " + valueResult);
                    valueOne = valueResult;
                }
            } break;

            case 't': {
                if(!checkValOne()) {
                    valueResult = Math.tan(Math.toRadians(valueOne));
                    history.add("tan(" + String.valueOf(valueOne) + ") = " + valueResult);
                    valueOne = valueResult;
                }
            } break;

            case 's': {
                if(!checkValOne()) {
                    valueResult = Math.sin(Math.toRadians(valueOne));
                    history.add("sin(" + String.valueOf(valueOne) + ") = " + valueResult);
                    valueOne = valueResult;
                }
            } break;

            case 'c': {
                if(!checkValOne()) {
                    valueResult = Math.cos(Math.toRadians(valueOne));
                    history.add("cos(" + String.valueOf(valueOne) + ") = " + valueResult);
                    valueOne = valueResult;
                }
            } break;

            case 'q': {
                if(!checkValOne()){
                    valueResult = Math.sqrt(valueOne);
                    history.add("√" + String.valueOf(valueOne) + " = " + valueResult);
                    valueOne = valueResult;
                }
            } break;

            case '%': {
                if(!checkValOne()){
                    valueResult = (valueOne / 100) * Double.parseDouble(value.getText().toString());
                    history.add(String.valueOf(valueOne) + " % " + Double.parseDouble(value.getText().toString()) + " = " + valueResult);
                    valueOne = valueResult;
                }
            } break;
            default:
                valueOne = Double.parseDouble(value.getText().toString());
                break;
        }
    }
}
