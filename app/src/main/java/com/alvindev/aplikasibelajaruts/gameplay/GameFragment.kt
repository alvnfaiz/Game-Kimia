package com.alvindev.aplikasibelajaruts.gameplay

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.alvindev.aplikasibelajaruts.R
import com.alvindev.aplikasibelajaruts.databinding.FragmentGameBinding

/**
 * This is the core of game Tebak Kimia
 *
 * We use a kotlin because data we collected is from ViewModel that use Coroutine only in Kotlin.
 */
class GameFragment : Fragment() {
    // using ViewModel KTX
    private val viewModel: GameViewModel by viewModels()

    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!
    private var correctAnswer = ""
    private var isError = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Observe status from ViewModel
        viewModel.status.observe(viewLifecycleOwner) { status ->
            when (status) {
                KimiaApiStatus.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.UnsurKimia.visibility = View.INVISIBLE
                    binding.lottieError.visibility = View.GONE
                }
                KimiaApiStatus.DONE -> {
                    isError = false
                    binding.progressBar.visibility = View.GONE
                    binding.UnsurKimia.visibility = View.VISIBLE
                    binding.lottieError.visibility = View.GONE
                }
                else -> {
                    isError = true
                    binding.progressBar.visibility = View.GONE
                    binding.UnsurKimia.visibility = View.INVISIBLE
                    binding.lottieError.visibility = View.VISIBLE
                }
            }
        }

        // Observe data from ViewModel
        viewModel.hasil.observe(viewLifecycleOwner) { data ->
            binding.UnsurKimia.text = data.lambang
            correctAnswer = data.unsur.toString().uppercase()
        }

        // Action
        binding.btnJawab.setOnClickListener {
            if (!isError) {
                if (binding.jawaban.text.toString().uppercase() == correctAnswer) {
                    view.findNavController().navigate(R.id.action_gameFragment_to_benarFragment)
                } else {
                    view.findNavController()
                        .navigate(
                            GameFragmentDirections.actionGameFragmentToSalahFragment(
                                correctAnswer
                            )
                        )
                }
                viewModel.retry()
                binding.jawaban.text.clear()
            } else {
                showDialog()
            }
        }
    }

    // Handling error with retry to connect
    private fun showDialog() {
        val builder = AlertDialog.Builder(activity)
        builder.setMessage(resources.getString(R.string.no_connection))
            .setNeutralButton(resources.getString(R.string.retry)) { _, _ ->
                viewModel.retry()
            }.show()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}