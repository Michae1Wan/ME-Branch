package com.michae1.codechallenge.fragment.listfragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import com.michae1.codechallenge.R
import com.michae1.codechallenge.adapter.GenericRecyclerViewBindingAdapter
import com.michae1.codechallenge.data.model.EmployeeModel
import com.michae1.codechallenge.databinding.ListFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() {

    companion object {
        fun newInstance() =
            ListFragment()
    }

    private lateinit var binding: ListFragmentBinding
    private val viewModel: ListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.list_fragment, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

        return binding.root
    }

    fun onItemClicked (model: EmployeeModel) {
        //TODO transition to details fragment
        Log.i("ListFragment", "You clicked!")
        Toast.makeText(context, "You clicied : " + model.first_name, Toast.LENGTH_SHORT).show()
    }

}