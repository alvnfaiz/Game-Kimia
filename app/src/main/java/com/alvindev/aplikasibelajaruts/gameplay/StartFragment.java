package com.alvindev.aplikasibelajaruts.gameplay;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.alvindev.aplikasibelajaruts.R;
import com.alvindev.aplikasibelajaruts.databinding.FragmentStartBinding;

/**
 * Start the game screen.
 */
public class StartFragment extends Fragment {

    private FragmentStartBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentStartBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnStartGame.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage(getResources().getString(R.string.begin_alert))
                    .setNeutralButton("OK", (dialogInterface, i) -> {
                        // Start!
                        Navigation.findNavController(view).navigate(StartFragmentDirections.actionStartFragmentToGameFragment());
                    }).show();
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}