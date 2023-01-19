package com.sarrawi.msgs.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.sarrawi.msgs.databinding.MsgstypeslayoutadapterBinding
import com.sarrawi.msgs.models.MsgsTypesModel

class MsgsTypes_Adapter : RecyclerView.Adapter<MsgsTypes_Adapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: MsgstypeslayoutadapterBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<MsgsTypesModel>(){
        override fun areItemsTheSame(oldItem: MsgsTypesModel, newItem: MsgsTypesModel): Boolean {
            return oldItem.id == newItem.id

        }

        override fun areContentsTheSame(oldItem: MsgsTypesModel, newItem: MsgsTypesModel): Boolean {
            return newItem == oldItem
        }

    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var msgsTypesModel: List<MsgsTypesModel>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            MsgstypeslayoutadapterBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val current_msgsTypesModel = msgsTypesModel[position]
        holder.binding.apply {
            name.text=current_msgsTypesModel.MsgTypes
            newmsg.text = current_msgsTypesModel.new_msg.toString()
        }

    }

    override fun getItemCount(): Int {
       return msgsTypesModel.size
    }
}