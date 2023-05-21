package com.guerra.preparcial.ui.dragonball.dragon_board

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.guerra.preparcial.R
import com.guerra.preparcial.data.adapter.DragonRecylcerViewAdapter
import com.guerra.preparcial.data.model.DragonModel
import com.guerra.preparcial.databinding.FragmentDragonBoardBinding
import com.guerra.preparcial.ui.dragonball.viewmodel.DragonViewModel

/**
 * Billboard fragment works as main view wich displays
 * each movie data information.
 * Use it to display information on main screen
 */
class DragonBoardFragment : Fragment() {


    //UI
    private lateinit var recyclerViewDragons: RecyclerView
    private lateinit var binding : FragmentDragonBoardBinding
    private  lateinit var adapter:  DragonRecylcerViewAdapter
    private val dragonViewModel: DragonViewModel by activityViewModels<DragonViewModel> {
        DragonViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding  = FragmentDragonBoardBinding.inflate(inflater, container , false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        bind()
        listeners()
//
//        val adapter = MovieRecylcerViewAdapter()
//        adapter.setData(movieViewModel.getMovies())
//        //adapter.setData(MovieRepository(movies).getMovies())
//
//        recyclerViewMovies.adapter = adapter
//        recyclerViewMovies.layoutManager = LinearLayoutManager(context)

        setRecyclerView(view)

    }

    private fun bind(){
        //cardViewFragmentStarWars = view?.findViewById(R.id.card_view_star_wars) as CardView
        recyclerViewDragons = view?.findViewById(R.id.dragons_recycle_view) as RecyclerView
    }

    private fun listeners(){

        binding.btnLinkNewDragon.setOnClickListener{
            dragonViewModel.clearData()
            it.findNavController().navigate(R.id.action_dragonBoardFragment_to_newDragonFragment)
        }
    }


    private fun showSelectedItem(dragon: DragonModel){
        dragonViewModel.setSelectedDragon(dragon)
        findNavController().navigate(R.id.action_dragonBoardFragment_to_dragonFragment)
    }

    private fun displayDragons(){
        adapter.setData(dragonViewModel.getDragons())
        adapter.notifyDataSetChanged()
    }
    private fun setRecyclerView(view: View){
        binding.dragonsRecycleView.layoutManager = LinearLayoutManager(view.context)

        adapter = DragonRecylcerViewAdapter { selectedDragon ->
            showSelectedItem(selectedDragon)
        }

        binding.dragonsRecycleView.adapter = adapter
        displayDragons()
    }


}
