package uz.akbarali.fashion.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.akbarali.fashion.R
import uz.akbarali.fashion.databinding.MenuItemBinding
import uz.akbarali.fashion.ui.modal.Fashion

class InstructionAdapter(
    private var list: ArrayList<Fashion>,
    var myClickListener: MyClickListener
) :
    RecyclerView.Adapter<InstructionAdapter.VH>() {
    inner class VH(private var binding: MenuItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(fashion: Fashion, position: Int) {
            binding.moreBtn.visibility = View.INVISIBLE
            binding.downloadBtn.setBackgroundResource(R.drawable.button)
            binding.downloadBtn.setOnClickListener {
                myClickListener.onClick(fashion, position)
            }
            binding.image.setImageResource(fashion.image)
            binding.title.text = fashion.title
            binding.description.text = fashion.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(MenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size

    interface MyClickListener {
        fun onClick(fashion: Fashion, position: Int)
    }
}