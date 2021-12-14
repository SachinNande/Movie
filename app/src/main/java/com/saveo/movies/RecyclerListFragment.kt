package com.saveo.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.saveo.movies.adapter.RecyclerViewAdapter
import com.saveo.movies.model.MovieDetailItem
import com.saveo.movies.viewmodel.MainActivityViewModel


class RecyclerListFragment : Fragment() {


    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_recycler_list, container, false)

        // Inflate the layout for this fragment
        initViewModel()
        initViewModel(view)
        return view
    }


    companion object {

        @JvmStatic
        fun newInstance() =
            RecyclerListFragment()
    }

    private fun initViewModel(view: View) {
        val recyclerView = view?.findViewById<RecyclerView>(R.id.id_recycler_view)
        recyclerView?.apply {
            layoutManager = LinearLayoutManager(activity)
            val decoration = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
            this.addItemDecoration(decoration)
            recyclerViewAdapter = RecyclerViewAdapter()
            this.adapter = recyclerViewAdapter
        }
    }

    private fun initViewModel(){
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getRecyclerListObserver().observe(viewLifecycleOwner, Observer {
            if (it !=null){
               recyclerViewAdapter.setUpdatedData(items = it )
            }else{
                Toast.makeText(requireContext(),"Error in getting Data",Toast.LENGTH_SHORT).show()
            }
        })

        viewModel.makeApiCall()
    }
}