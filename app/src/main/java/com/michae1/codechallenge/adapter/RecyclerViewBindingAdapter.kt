package com.michae1.codechallenge.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity

import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.michae1.codechallenge.BR
import com.michae1.codechallenge.R
import com.michae1.codechallenge.data.model.EmployeeModel
import dagger.hilt.android.internal.managers.ViewComponentManager
import kotlinx.android.synthetic.main.activity_main.*

/**
 *
 * Created by Michae1 (michae1wan@live.com) on 7/24/2020.
 */
@BindingAdapter(value = ["items", "itemLayout"], requireAll = true)
fun <T> setRecyclerViewProperties(recyclerView: RecyclerView, list: List<Any>?, layoutId: Int) {
    val items = list ?:  ArrayList<Nothing>()
    if (recyclerView.adapter == null) {
            recyclerView.adapter = GenericRecyclerViewBindingAdapter(items, layoutId)
    }
    else {
        (recyclerView.adapter as GenericRecyclerViewBindingAdapter<*>).setItems(items as List<Nothing>)
    }
}

class GenericRecyclerViewBindingAdapter<Any> (
    private var listItems: List<Any>,
    private var layoutId: Int
) : RecyclerView.Adapter<GenericRecyclerViewBindingAdapter.GenericDatabindViewHolder<Any>>() {

    private lateinit var binding: ViewDataBinding

    fun setItems(listItems: List<Any>) {
        this.listItems = listItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericDatabindViewHolder<Any> {
        val inflater = LayoutInflater.from(parent.context)
        binding = DataBindingUtil.inflate(inflater, layoutId, parent, false)
        return GenericDatabindViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GenericDatabindViewHolder<Any>, position: Int) {
        holder.bind(listItems[position])
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    class GenericDatabindViewHolder<T>(private val binding: ViewDataBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: T) {
            binding.setVariable(BR.model, item)
            binding.executePendingBindings()
        }
    }

}