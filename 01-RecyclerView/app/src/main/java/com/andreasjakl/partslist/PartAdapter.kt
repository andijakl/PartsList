package com.andreasjakl.partslist
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andreasjakl.partslist.databinding.PartListItemBinding

class PartAdapter (var partItemList: List<PartData>, private val clickListener: (PartData) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        // LayoutInflater: takes ID from layout defined in XML.
        // Instantiates the layout XML into corresponding View objects.
        // Use context from main app -> also supplies theme layout values!
        val inflater = LayoutInflater.from(parent.context)
        // Inflate XML. Last parameter: don't immediately attach new view to the parent view group
        val binding = PartListItemBinding.inflate(inflater, parent, false)
        return PartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        // Populate ViewHolder with data that corresponds to the position in the list
        // which we are told to load
        (holder as PartViewHolder).bind(partItemList[position], clickListener)
    }

    override fun getItemCount() = partItemList.size

    inner class PartViewHolder(private val binding: PartListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(part: PartData, clickListener: (PartData) -> Unit) {
            binding.tvPartItemName.text = part.itemName
            binding.tvPartId.text = part.id.toString()
            binding.root.setOnClickListener { clickListener(part) }
        }
    }
}