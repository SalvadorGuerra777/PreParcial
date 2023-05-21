package com.guerra.preparcial.ui.dragonball.dragon_board.recyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.guerra.preparcial.databinding.FragmentDragonItemBinding

/**
 * Fragment to display movie items in main screen
 */
class DragonItemFragment : Fragment() {

    private lateinit var binding: FragmentDragonItemBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDragonItemBinding.inflate(inflater, container, false)
        return binding.root
    }

}