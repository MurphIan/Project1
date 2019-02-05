package w7249732.cs134.miracosta.project1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;
/*
This is the main class that will run the app.
 */
public class MainActivity extends AppCompatActivity
{
    //Instance variables that belong the the app.
    private EditText weightEditText;
    private TextView displayBCost;
    private TextView displayACost;
    private TextView displayTCost;

    private ShipItem itemToBeShipped;

    //Main method.
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Paring the widgets to the java code.
        weightEditText.findViewById(R.id.weightEditText);
        displayBCost.findViewById(R.id.DisplayBcost);
        displayACost.findViewById(R.id.DisplayACost);
        displayTCost.findViewById(R.id.DisplayTCost);

        //the event listener to start the calculations.
        weightEditText.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                //converting the
                String str = s.toString();
                //converting the data to a double to pass the the argument.
                double data = Double.parseDouble(str);

                /*
                    diplaying the cost information to the base cost display, added cost display, and
                    total cost display
                 */
                displayBCost.setText(R.string.bcost);

                displayACost.setText(Double.toString(itemToBeShipped.calculateAddedCost(data)));

                displayTCost.setText(Double.toString(itemToBeShipped.calculateShippingCost(data)));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
