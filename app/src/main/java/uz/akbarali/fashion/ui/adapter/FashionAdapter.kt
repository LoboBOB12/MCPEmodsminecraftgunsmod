package uz.akbarali.fashion.ui.adapter

import android.content.Intent
import android.content.SharedPreferences
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.akbarali.fashion.R
import uz.akbarali.fashion.databinding.MenuItemBinding
import uz.akbarali.fashion.ui.SubscribeActivity
import uz.akbarali.fashion.ui.modal.Download
import uz.akbarali.fashion.ui.modal.Fashion
private val SHARED_PREFS_NAME = "my_prefs"

// Создаем ключ для параметра, который мы будем сохранять
private val PARAMETER_KEY = "my_parameter"

// Объявляем переменную SharedPreferences
private lateinit var sharedPreferences: SharedPreferences
class FashionAdapter(private var list: ArrayList<Fashion>, var myClickListener: MyClickListener,    private var sharedPreferences: SharedPreferences) :
    RecyclerView.Adapter<FashionAdapter.VH>() {
    inner class VH(private var binding: MenuItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(fashion: Fashion, position: Int) {
            // Получаем значение параметра из SharedPreferences
            val savedValue = sharedPreferences.getInt("my_parameter_key", 0)

            // Используем значение в приложении
            Log.d("FashionAdapter", "Значение параметра: $savedValue")
            if (savedValue == 0) {
                if (position == 1 || position == 3 || position == 5 || position == 7 || position == 9 || position == 11 || position == 13) {
                    binding.moreBtn.visibility = View.INVISIBLE
                    binding.downloadBtn.setBackgroundResource(R.drawable.button__2_)
                    binding.downloadBtn.setOnClickListener {
                        myClickListener.onClick(fashion, position)
                    }
                    binding.downloadBtn.setOnClickListener {
                        myClickListener.download(fashion, position)
                    }

                }
            }
            binding.image.setImageResource(fashion.image)
            binding.title.text = fashion.title
            binding.description.text = fashion.description

            binding.moreBtn.setOnClickListener {
                myClickListener.onClick(fashion, position)
            }


            binding.downloadBtn.setOnClickListener {
                val intent = Intent(binding.root.context, SubscribeActivity::class.java)
                binding.root.context.startActivity(intent)
            }

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
        fun download(fashion: Fashion, position: Int)
    }
}