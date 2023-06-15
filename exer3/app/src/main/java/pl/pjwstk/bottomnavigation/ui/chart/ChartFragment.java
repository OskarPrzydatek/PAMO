package pl.pjwstk.bottomnavigation.ui.chart;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import pl.pjwstk.bottomnavigation.R;
import android.widget.Button;
import android.widget.EditText;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class ChartFragment extends Fragment {

    private GraphView graphView;
    private EditText weightEditText;
    private EditText heightEditText;
    private Button calculateButton;

    private LineGraphSeries<DataPoint> series;

    public ChartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chart, container, false);

        graphView = view.findViewById(R.id.graphView);
        weightEditText = view.findViewById(R.id.weightEditText);
        heightEditText = view.findViewById(R.id.heightEditText);
        calculateButton = view.findViewById(R.id.calculateButton);

        series = new LineGraphSeries<>();

        graphView.addSeries(series);
        graphView.getViewport().setXAxisBoundsManual(true);
        graphView.getViewport().setMinX(0);
        graphView.getViewport().setMaxX(10);
        graphView.getViewport().setYAxisBoundsManual(true);
        graphView.getViewport().setMinY(0);
        graphView.getViewport().setMaxY(40);
        graphView.getGridLabelRenderer().setHorizontalAxisTitle("Time");
        graphView.getGridLabelRenderer().setVerticalAxisTitle("BMI");

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });

        return view;
    }

    private void calculateBMI() {
        String weightText = weightEditText.getText().toString();
        String heightText = heightEditText.getText().toString();

        if (weightText.isEmpty() || heightText.isEmpty()) {
            return;
        }

        float weight = Float.parseFloat(weightText);
        float height = Float.parseFloat(heightText) / 100f; // Convert height from cm to meters

        float bmi = weight / (height * height);

        series.appendData(new DataPoint(series.getHighestValueX() + 1, bmi), true, 10);
    }

}