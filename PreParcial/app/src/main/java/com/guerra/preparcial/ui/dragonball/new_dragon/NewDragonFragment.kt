package com.guerra.preparcial.ui.dragonball.new_dragon

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.guerra.preparcial.databinding.FragmentNewDragonBinding
import com.guerra.preparcial.ui.dragonball.viewmodel.DragonViewModel

/**
This fragments handles adding new movie to app data
 */
class NewDragonFragment : Fragment() {

    private lateinit var binding : FragmentNewDragonBinding

    private val dragonViewModel: DragonViewModel by activityViewModels<DragonViewModel> {
        DragonViewModel.Factory
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dragonViewModel.SetNewDragonFragment()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding  = FragmentNewDragonBinding.inflate(inflater, container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        observerStatus()
    }


    private fun setViewModel(){
        binding.viewmodel = dragonViewModel
    }

    private fun observerStatus(){
        dragonViewModel.status.observe(viewLifecycleOwner){
            when{
                it.equals(DragonViewModel.WRONG_INFORMATION)->{
                    Log.d("APP_TAG", it)
                    dragonViewModel.clearStatus()
                }
                it.equals(DragonViewModel.DRAGON_CREATED)->{
                    Log.d("APP_TAG", it)
                    Log.d("APP_TAG", dragonViewModel.getDragons().toString())

                    dragonViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }

}