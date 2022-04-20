package com.alvindev.aplikasibelajaruts.gameplay;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.alvindev.aplikasibelajaruts.databinding.FragmentBenarBinding;

/**
 * {@link BenarFragment} is a condition when {@link GameFragment} answer goes correct.
 */
public class BenarFragment extends Fragment {

    private FragmentBenarBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBenarBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnLanjut.setOnClickListener(v ->
                Navigation.findNavController(v).navigateUp());

        binding.btnHome.setOnClickListener(v ->
                Navigation.findNavController(v).navigate(BenarFragmentDirections.actionBenarFragmentToStartFragment()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}