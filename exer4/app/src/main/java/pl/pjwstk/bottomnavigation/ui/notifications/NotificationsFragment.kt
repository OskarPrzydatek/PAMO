package pl.pjwstk.bottomnavigation.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import pl.pjwstk.bottomnavigation.R
import pl.pjwstk.bottomnavigation.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {
    private var binding: FragmentNotificationsBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        val recipes = root.findViewById<TextView>(R.id.textViewRecipies)
        recipes.text = GenerateRecipes()
        return root
    }

    private fun GenerateRecipes(): String {
        return """
            Here's a quick recipe for scrambled eggs in steps: 
            
            Step 1: Crack 2-3 eggs into a bowl and whisk with a fork until fully combined.
            
            Step 2: Heat a non-stick frying pan over medium-high heat. 
            
            Step 3: Add a small knob of butter to the pan and let it melt.
            
            Step 4: Pour the eggs into the pan and let them cook for a few seconds until the bottom starts to set.
            
            Step 5: Using a spatula, start to scramble the eggs by pushing them around the pan.
            
            Step 6: Cook the eggs for a few more seconds until they are just set and slightly runny.
            
            Step 7: Season with salt and pepper to taste.
            
            Step 8: Serve the scrambled eggs immediately on a plate or in a sandwich.
            
            Enjoy!
            """.trimIndent()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}