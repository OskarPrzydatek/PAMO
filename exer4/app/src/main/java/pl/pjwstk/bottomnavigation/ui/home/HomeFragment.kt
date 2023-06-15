package pl.pjwstk.bottomnavigation.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import pl.pjwstk.bottomnavigation.R
import pl.pjwstk.bottomnavigation.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var binding: FragmentHomeBinding? = null
    private var ETPersonWeight: EditText? = null
    private var ETPersonHeight: EditText? = null
    private var BMIInfo: TextView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val homeViewModel = ViewModelProvider(this).get(
            HomeViewModel::class.java
        )
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        ETPersonWeight = root.findViewById(R.id.editTextTextPersonWeight)
        ETPersonHeight = root.findViewById(R.id.editTextTextPersonHeight)
        BMIInfo = root.findViewById(R.id.textViewBMIInfo)
        val BCalculate = root.findViewById<Button>(R.id.buttonCalculate)
        BCalculate.setOnClickListener { CalculateBMI() }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    @SuppressLint("SetTextI18n", "DefaultLocale")
    private fun CalculateBMI() {
        val weight = ETPersonWeight!!.text.toString().toFloat()
        val height = ETPersonHeight!!.text.toString().toFloat()
        val bmi = 100 * 100 * weight / (height * height)
        BMIInfo!!.text = "Your BMI is: " + String.format("%.2f", bmi)
    }
}