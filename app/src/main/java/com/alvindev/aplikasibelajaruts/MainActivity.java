package com.alvindev.aplikasibelajaruts;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.alvindev.aplikasibelajaruts.databinding.ActivityMainBinding;

/**
 * MainActivity sets the content view activity_main, a fragment container that contains a many
 * fragments
 * <br>
 * <br>
 * in this case we use view binding for replace findViewById method.
 *
 * @see <a href="https://developer.android.com/topic/libraries/view-binding"></a>
 */
public class MainActivity extends AppCompatActivity {

    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // gets a binding
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Get the navigation host fragment from this Activity
        NavHostFragment navHostFragment = (NavHostFragment)
                getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);

        // Instantiate the navController using the NavHostFragment
        assert navHostFragment != null;
        navController = navHostFragment.getNavController();

        // Make sure actions in the ActionBar get propagated to the NavController
        // Action Bar went disabled
        // NavigationUI.setupActionBarWithNavController(this, navController);
    }

    /**
     * Enables back button support. Simply navigates one element up on the stack.
     */
    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp() || super.onSupportNavigateUp();
    }
}