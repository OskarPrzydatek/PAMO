package pl.pjwstk.bottomnavigation.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import pl.pjwstk.bottomnavigation.R;
import pl.pjwstk.bottomnavigation.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        TextView recipes = root.findViewById(R.id.textViewRecipies);
        recipes.setText(GenerateRecipes());
        return root;
    }

    private String GenerateRecipes() {
        return
                "Here's a quick recipe for scrambled eggs in steps: \n\n" +
                        "Step 1: Crack 2-3 eggs into a bowl and whisk with a fork until fully combined.\n\n" +
                        "Step 2: Heat a non-stick frying pan over medium-high heat. \n\n" +
                        "Step 3: Add a small knob of butter to the pan and let it melt.\n\n" +
                        "Step 4: Pour the eggs into the pan and let them cook for a few seconds until the bottom starts to set.\n\n" +
                        "Step 5: Using a spatula, start to scramble the eggs by pushing them around the pan.\n\n" +
                        "Step 6: Cook the eggs for a few more seconds until they are just set and slightly runny.\n\n" +
                        "Step 7: Season with salt and pepper to taste.\n\n" +
                        "Step 8: Serve the scrambled eggs immediately on a plate or in a sandwich.\n\n" +
                        "Enjoy!"
                ;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}