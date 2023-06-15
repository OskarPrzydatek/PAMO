package pl.pjwstk.bottomnavigation.ui.chart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import pl.pjwstk.bottomnavigation.R

class ChartFragment : Fragment() {
    private var graphView: GraphView? = null
    private var weightEditText: EditText? = null
    private var heightEditText: EditText? = null
    private var calculateButton: Button? = null
    private var series: LineGraphSeries<DataPoint>? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_chart, container, false)
        graphView = view.findViewById(R.id.graphView)
        weightEditText = view.findViewById(R.id.weightEditText)
        heightEditText = view.findViewById(R.id.heightEditText)
        calculateButton = view.findViewById(R.id.calculateButton)
        series = LineGraphSeries()
        graphView.addSeries(series)
        graphView.getViewport().isXAxisBoundsManual = true
        graphView.getViewport().setMinX(0.0)
        graphView.getViewport().setMaxX(10.0)
        graphView.getViewport().isYAxisBoundsManual = true
        graphView.getViewport().setMinY(0.0)
        graphView.getViewport().setMaxY(40.0)
        graphView.getGridLabelRenderer().horizontalAxisTitle = "Time"
        graphView.getGridLabelRenderer().verticalAxisTitle = "BMI"
        calculateButton.setOnClickListener(View.OnClickListener { calculateBMI() })
        return view
    }

    private fun calculateBMI() {
        val weightText = weightEditText!!.text.toString()
        val heightText = heightEditText!!.text.toString()
        if (weightText.isEmpty() || heightText.isEmpty()) {
            return
        }
        val weight = weightText.toFloat()
        val height = heightText.toFloat() / 100f // Convert height from cm to meters
        val bmi = weight / (height * height)
        series!!.appendData(DataPoint(series!!.highestValueX + 1, bmi.toDouble()), true, 10)
    }
}