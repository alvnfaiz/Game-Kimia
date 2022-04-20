package com.alvindev.aplikasibelajaruts.gameplay;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.alvindev.aplikasibelajaruts.databinding.FragmentSalahBinding;

/**
 * {@link SalahFragment} is a condition when {@link GameFragment} answer goes wrong.
 */
public class SalahFragment extends Fragment {

    private FragmentSalahBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSalahBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Retrieve safe args from GameFragment
        // more info about safe args check this link below
        // https://developer.android.com/guide/navigation/navigation-pass-data#Safe-args
        Bundle bundle = getArguments();

        if (bundle == null) {
            Log.e("SalahFragment", "onCreateView: Data Not Retrieved");
        }

        SalahFragmentArgs args = SalahFragmentArgs.fromBundle(bundle);
        String correctAnswer = args.getCorrectAnswerArgument();
        binding.jawaban.setText(correctAnswer);

        binding.btnLanjut.setOnClickListener(v ->
                Navigation.findNavController(v).navigateUp());

        binding.btnHome.setOnClickListener(v ->
                Navigation.findNavController(v).navigate(SalahFragmentDirections.actionSalahFragmentToStartFragment()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}