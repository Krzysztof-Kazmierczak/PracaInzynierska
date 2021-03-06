package com.example.inzynierka.fragmenty.potwierdzenie

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.inzynierka.R
import com.example.inzynierka.databinding.ConfirmSendFragmentBinding
import com.example.inzynierka.databinding.ConfirmTakeFragmentBinding

class ConfirmTake : Fragment() {

    private val Take_DEBUG = "Take_DEBUG"
    private var _binding:  ConfirmTakeFragmentBinding? = null
    private val binding get() = _binding!!
    private val ConfirmTakeVm by viewModels<ConfirmTakeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ConfirmTakeFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
        return inflater.inflate(R.layout.confirm_take_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var size = String()
        var numerIdBox = String()
        var numerIdPaczki = String()

        ConfirmTakeVm.boxId()
        numerIdBox = ConfirmTakeVm.numerBoxu
        numerIdPaczki = ConfirmTakeVm.numerPaczki
        if(numerIdBox.toInt()<6)
        {
            size = "boxsS"
        }
        else
        {
            if(numerIdBox.toInt()<11)
            {
                size = "boxsM"
            }
            else
            {
                size = "boxsL"
            }
        }

        binding.CTFNie.setOnClickListener {
            ConfirmTakeVm.openBoxCT(size, numerIdBox)
            Toast.makeText(requireContext(), "Otwarto ponownie box " + numerIdBox, Toast.LENGTH_SHORT).show()
        }

        binding.CTFTak.setOnClickListener {
            Log.d("To jest rozmiar paczki",size.toString())
            Log.d("To jest rozmiar paczki",numerIdBox.toString())

            ConfirmTakeVm.boxEmpty(size, numerIdBox)
            ConfirmTakeVm.closeBox(size, numerIdBox)
            findNavController()
                .navigate(ConfirmTakeDirections.actionConfirmTakeToHomeFragment().actionId)
        }
    }



}