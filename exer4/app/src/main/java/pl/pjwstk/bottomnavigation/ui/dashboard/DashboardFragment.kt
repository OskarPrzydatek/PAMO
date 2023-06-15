package pl.pjwstk.bottomnavigation.ui.dashboard

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import androidx.fragment.app.Fragment
import pl.pjwstk.bottomnavigation.R
import pl.pjwstk.bottomnavigation.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {
    private var binding: FragmentDashboardBinding? = null
    private var ETPersonWeight: EditText? = null
    private var ETPersonHeight: EditText? = null
    private var ETPersonAge: EditText? = null

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private var AreYouAWoman: Switch? = null
    private var TVBenHarInfo: TextView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        ETPersonWeight = root.findViewById(R.id.editTextTextPersonWeight)
        ETPersonHeight = root.findViewById(R.id.editTextTextPersonHeight)
        ETPersonAge = root.findViewById(R.id.editTextTextPersonAge)
        TVBenHarInfo = root.findViewById(R.id.textViewBenHarInfo)
        val BCalculate = root.findViewById<Button>(R.id.buttonCalculate)
        AreYouAWoman = root.findViewById(R.id.switchAreYouAWoman)
        BCalculate.setOnClickListener { CalculateBenHar() }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    @SuppressLint("SetTextI18n", "DefaultLocale")
    private fun CalculateBenHar() {
        val weight = ETPersonWeight!!.text.toString().toFloat()
        val height = ETPersonHeight!!.text.toString().toFloat()
        val age = ETPersonAge!!.text.toString().toFloat()
        var benHarCal = 0f
        benHarCal = if (AreYouAWoman!!.isChecked) {
            (66.473 + 13.7516 * weight + 5.0033 * height - 6.755 * age).toFloat()
        } else {
            (655.0955 + 9.5634 * weight + 1.8496 * height - 4.6756 * age).toFloat()
        }
        TVBenHarInfo!!.text = "Your BenHar is: " + String.format("%.2f", benHarCal)
    }
}