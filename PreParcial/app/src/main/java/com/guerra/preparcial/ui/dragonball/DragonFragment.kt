package com.guerra.preparcial.ui.dragonball

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.guerra.preparcial.databinding.FragmentDragonBinding
import com.guerra.preparcial.ui.dragonball.viewmodel.DragonViewModel

/**
 * this fragment handles show each movie complete information
 */
class DragonFragment : Fragment() {

    private val dragonViewModel: DragonViewModel by activityViewModels {
        DragonViewModel.Factory
    }
    private lateinit var binding : FragmentDragonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dragonViewModel.SetDragonFragment()


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding  = FragmentDragonBinding.inflate(inflater, container , false)
        return binding.root
    }

    private fun setViewModel(){
        binding.viewmodel = dragonViewModel
    }
}