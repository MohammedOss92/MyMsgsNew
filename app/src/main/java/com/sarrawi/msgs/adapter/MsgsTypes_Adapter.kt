package com.sarrawi.msgs.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.sarrawi.msgs.databinding.MsgstypeslayoutBinding
import com.sarrawi.msgs.models.MsgsTypesModel

class MsgsTypes_Adapter : RecyclerView.Adapter<MsgsTypes_Adapter.MyViewHolder>() {

//    var onItemClick: ((Int,String) -> Unit)? = null
    var onItemClick: ((Int) -> Unit)? = null

    inner class MyViewHolder(val binding : MsgstypeslayoutBinding) : RecyclerView.ViewHolder(binding.root){

        init {
            binding.root.setOnClickListener {
//                onItemClick?.invoke(msgsTypesModel[layoutPosition].id,msgsTypesModel[layoutPosition].MsgTypes!!)
                onItemClick?.invoke(msgsTypesModel[layoutPosition].id)

            }
        }

    }

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
        return MyViewHolder(MsgstypeslayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
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