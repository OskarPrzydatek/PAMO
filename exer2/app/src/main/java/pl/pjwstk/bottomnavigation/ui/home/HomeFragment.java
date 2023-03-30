package pl.pjwstk.bottomnavigation.ui.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import pl.pjwstk.bottomnavigation.R;
import pl.pjwstk.bottomnavigation.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    private EditText ETPersonWeight;
    private EditText ETPersonHeight;
    private TextView BMIInfo;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ETPersonWeight = root.findViewById(R.id.editTextTextPersonWeight);
        ETPersonHeight = root.findViewById(R.id.editTextTextPersonHeight);
        BMIInfo = root.findViewById(R.id.textViewBMIInfo);
        Button BCalculate = root.findViewById(R.id.buttonCalculate);

        BCalculate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                CalculateBMI();
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    private void CalculateBMI() {
        float weight = Float.parseFloat(ETPersonWeight.getText().toString());
        float height = Float.parseFloat(ETPersonHeight.getText().toString());

        float bmi = (100*100*weight)/(height*height);

        BMIInfo.setText("Your BMI is: " + String.format("%.2f", bmi));
    }
}