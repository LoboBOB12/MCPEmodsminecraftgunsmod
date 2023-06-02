package uz.akbarali.fashion.ui.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.akbarali.fashion.R
import uz.akbarali.fashion.databinding.FragmentInstructionBinding
import uz.akbarali.fashion.ui.adapter.FashionAdapter
import uz.akbarali.fashion.ui.adapter.InstructionAdapter
import uz.akbarali.fashion.ui.modal.Fashion


class InstructionFragment : Fragment(), InstructionAdapter.MyClickListener {
    private lateinit var adapter: InstructionAdapter
    private lateinit var binding: FragmentInstructionBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInstructionBinding.inflate(layoutInflater)
        adapter = InstructionAdapter(loadData(), this)
        binding.toolbar.title = "Инструкция"
        binding.rv.adapter = adapter
        return binding.root
    }

    private fun loadData(): ArrayList<Fashion> {
        val list = ArrayList<Fashion>()
        list.add(
            Fashion(
                R.drawable.media16,
                ".MCPack, .MCWorld",
                "Большинство модов на просторах интернета будут иметь расширения файлов .mcpack \u2028и .mcworld"
            )
        )
        list.add(
            Fashion(
                R.drawable.media17,
                " .ZIP, .RAR",
                "Если же Ваше устанавливаемое дополнение имеет расширение .ZIP или .RAR, то сделайте следующее..."
            )
        )

        return list
    }


    override fun onClick(fashion: Fashion, position: Int) {
        when (position) {
            0 -> {
                findNavController().navigate(R.id.MCWorldFragment)
            }
            1 -> {
                findNavController().navigate(R.id.RARFragment)
            }

        }
    }
}